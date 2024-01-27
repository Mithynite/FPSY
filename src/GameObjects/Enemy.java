package GameObjects;
import AnimationSettings.AnimationManager;
import AnimationSettings.AnimationState;

import java.awt.*;
import java.awt.image.BufferedImage;
public class Enemy extends Entity {
    protected int animationSpeed;
    public Enemy(int positionX, int positionY, int sizeX, int sizeY, House house) {
        super(positionX, positionY, sizeX, sizeY);
        this.house = house;
    }
    public void setAttributes(int animation_speed, int movement_speed, int damage, int health){
        this.animationSpeed = animation_speed;
        this.speed = movement_speed;
        this.damage = damage;
        this.health = health;
    }
    public void attackManage(Rectangle collision){
        if(checkForCollision(collision) && animationState != AnimationState.hurt && animationState != AnimationState.die && !exhausted_after_hit){
            animationState = AnimationState.attack;
            stopEveryMove();
        }else if(!exhausted_after_hit){
            moving = true;
        }
        if(hit() && hit_cooldown == 0){
            exhausted_after_hit = true;
            resetAnimationIndex();
        }
    }
    public void changingTheDirection(){
        if(speed > 0){
            right = true;
            left = false;
        }else{
            right = false;
            left = true;
        }
    }
    @Override
    protected void move(){}
    /*@Override
    protected BufferedImage updateAnimation() {
        if(moving){
            animationState = AnimationState.walk;
            if (right) {
                sizeX = Math.abs(sizeX);
            }
            else if(left && sizeX > 0) sizeX *=-1;
        }else if(exhausted_after_hit && !got_hit){
            animationState = AnimationState.idle;
        }
        return animationManager.update().invoke();
    }*/
    @Override
    public void updateIt(){
        move();
        updateInvincibility(1000);
        updateHitCooldown(2000);
        animationManager.changeState(animationState);
    }
    @Override
    public void renderIt(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(updateAnimation(),positionX, positionY, sizeX, sizeY, null);
    }
}