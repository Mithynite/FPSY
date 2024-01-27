package GameObjects;

import AnimationSettings.AnimationManager;
import AnimationSettings.AnimationState;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.SimpleTimeZone;

public class Entity extends GameObject{
    protected House house;
    protected AnimationState animationState = AnimationState.idle;
    protected final AnimationManager animationManager = new AnimationManager(animationState);
    protected boolean invincible_after_damage;
    protected long invincible_after_damage_counter;
    private long invincible_after_damage_initial_time;
    protected boolean got_hit;
    protected boolean exhausted_after_hit;
    protected long hit_cooldown;
    private long hit_cooldown_initial_time;
    protected boolean right;
    protected boolean left;
    protected boolean up;
    protected boolean down;
    protected boolean moving;
    protected int speed = 2;
    protected int damage = 2;
    protected int health = 10;
    protected int maxHealth = health;
    public Entity(int positionX, int positionY, int sizeX, int sizeY) {
        super(positionX, positionY, sizeX, sizeY);
        this.invincible_after_damage = false;
        this.invincible_after_damage_counter = 0;
        this.invincible_after_damage_initial_time = 0;
        this.got_hit = false;
        this.exhausted_after_hit = false;
        this.hit_cooldown = 0;
        this.hit_cooldown_initial_time = 0;
    }
    protected void initializeAnimations(){

    }
    public boolean isDead(){
        return health <= 0;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void changeHealth(int change) {
        this.health += change;
        System.out.println("Player health: " + health);
    }
    public void recieveDamage(int takenDamage) {
        if(!invincible_after_damage){
            changeHealth(-takenDamage);
            invincible_after_damage = true;
        }
    }
    public void updatePositionX(int sp) {
        this.positionX += sp;
    }
    public void updatePositionY(int sp) {
        this.positionY += sp;
    }
    protected void updateInvincibility(long cooldown){
        if(invincible_after_damage){
            if(invincible_after_damage_counter == 0 && invincible_after_damage_initial_time == 0){
                invincible_after_damage_initial_time = System.nanoTime();
            }
            long time_pass = System.nanoTime();
            invincible_after_damage_counter = (time_pass - invincible_after_damage_initial_time)/1000000;
            if(invincible_after_damage_counter > cooldown){
                invincible_after_damage = false;
                invincible_after_damage_counter = 0;
                invincible_after_damage_initial_time = 0;
            }
        }
    }
    protected void updateHitCooldown(long cooldown){
        if(exhausted_after_hit){
            if(hit_cooldown == 0 && hit_cooldown_initial_time == 0){
                hit_cooldown_initial_time = System.nanoTime();
            }
            long time_pass = System.nanoTime();
            hit_cooldown = (time_pass - hit_cooldown_initial_time)/1000000;
            if(hit_cooldown > cooldown){
                exhausted_after_hit = false;
                hit_cooldown = 0;
                hit_cooldown_initial_time = 0;
            }
        }
    }
    protected void attackManage(){}
    public boolean hit(){
        return animationManager.animationFinished(AnimationState.attack) && animationState == AnimationState.attack;
    }
    protected void checkForHitFromAttacker(boolean hit, int takenDamage, Rectangle collision){
        if(hit && checkForCollision(collision) && !invincible_after_damage){
            stopEveryMove();
            recieveDamage(takenDamage);
            animationState = AnimationState.hurt;
            got_hit = true;
        }else if(animationState == AnimationState.hurt && animationManager.animationFinished(animationState)){
            got_hit = false;
            resetAnimationIndex();
        }
    }
    protected void attackManage(Rectangle collision){
    }
    protected boolean playDeathAnimation(){
        stopEveryMove();
        animationState = AnimationState.die;
        return animationManager.animationFinished(animationState);
    }
    protected BufferedImage updateAnimation() {
        if(moving){
            animationState = AnimationState.walk;
            if (right) {
                sizeX = Math.abs(sizeX);
            }
            else if(left && sizeX > 0){
                sizeX *= -1;
            }
        }else if(exhausted_after_hit && !got_hit){
            animationState = AnimationState.idle;
        }
        return animationManager.update().invoke();
    }
    protected void resetAnimationIndex(){
        animationManager.resetAnimationIndex(animationState);
    }
    protected void move(){
    }
    protected void stopEveryMove(){
        left = false;
        right = false;
        up = false;
        down = false;
        moving = false;
    }
    protected void updateIt(){

    }
    protected void renderIt(Graphics graphics){
    }
}
