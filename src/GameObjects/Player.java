package GameObjects;

import AnimationSettings.AnimationGameObject;
import AnimationSettings.AnimationState;
import Manage.Window;
import TexturesAndImages.Constants;

import java.awt.*;

public class Player extends Entity{
    //private boolean attacking;
    private boolean windowActivation;
    @Override
    public void initializeAnimations() {
        animationManager.putNewAnimation(AnimationState.idle, new AnimationGameObject(25, 4, Constants.getPlayer_idleAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.walk, new AnimationGameObject(10, 6, Constants.getPlayer_walkAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.attack, new AnimationGameObject(10, 6, Constants.getPlayer_attackAnimationAddress(), 8));
        animationManager.putNewAnimation(AnimationState.hurt, new AnimationGameObject(15, 3, Constants.getPlayer_hurtAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.die, new AnimationGameObject(10, 6, Constants.getPlayer_deathAnimationAddress()));
    }
    public Player(int positionX, int positionY, int sizeX, int sizeY, House house) {
        super(positionX, positionY, sizeX, sizeY);
        this.house = house;
        initializeAnimations();
    }
    public boolean isWindowActivation() {
        return windowActivation;
    }
    public void setWindowActivation(boolean windowActivation) {
        this.windowActivation = windowActivation;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public AnimationState getAnimationState() {
        return animationState;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void healToMaximum(){
        this.health = maxHealth;
    }
    @Override
    public void changeHealth(int change) {
        this.health += change;
        System.out.println("Player health: " + health);
    }
    public void attackManage(boolean attacking) {
        if(animationState != AnimationState.hurt && animationState != AnimationState.die && attacking) {
            animationState = AnimationState.attack;
            //this.attacking = true;
        }
        if(hit() && hit_cooldown == 0){
            exhausted_after_hit = true;
            resetAnimationIndex();
        }
    }
    @Override
    public void move(){
        stopEveryMove();
        boolean checkHouseCollision = checkForCollision(house.getHitbox());
        moving = false;
        if(!isDead() && animationState != AnimationState.attack && !exhausted_after_hit){ //!attacking
        if(left && !right && !(positionX+sizeX <= 0) && !checkHouseCollision) {
            updatePositionX(-speed);
            moving = true;
        }
        if(!left && right && !(positionX >= Window.getWindowWidth() - sizeX)) {
            updatePositionX(speed);
            moving = true;
        }
        if(up && !down && !(positionY+40 <= 0) && !checkHouseCollision){
            updatePositionY(-speed);
            moving = true;
        }
        if(!up && down && !(positionY >= Window.getWindowHeight() - 180)) {
            updatePositionY(speed);
            moving = true;
        }
    }/*else if(){
            animationState = AnimationState.attack;
        }*/
    }
    @Override
    public void stopEveryMove(){
        if(!windowActivation){
            left = false;
            right = false;
            up = false;
            down = false;
            moving = false;
        }
    }
    /*@Override
    public BufferedImage updateAnimation() {
        if(moving){
            animationState = AnimationState.walk;
            if (right) {
                sizeX = Math.abs(sizeX);
            }
            else if(left && sizeX > 0){
                sizeX *= -1;
            }
        }else if(exhausted_after_hit && !got_hit){ //!attacking &&animationState != AnimationState.hurt && animationState != AnimationState.die
            animationState = AnimationState.idle;
        }
        return animationManager.update().invoke();
    }*/
    @Override
    public void updateIt(){
        animationManager.changeState(animationState);
        move();
        System.out.println(moving);
        updateInvincibility(1000);
        updateHitCooldown(2000);
        updateHitbox();
    }
    @Override
    public void renderIt(Graphics graphics){
        //drawHitbox(graphics);
        graphics.drawImage(updateAnimation(), positionX, positionY, sizeX, sizeY, null);
    }
}