package GameObjects;

import AnimationSettings.AnimationGameObject;
import AnimationSettings.AnimationState;
import Manage.*;
import TexturesAndImages.*;
public class Villager extends Enemy {
    public Villager(int positionX, int positionY, int sizeX, int sizeY, House house) {
        super(positionX, positionY, sizeX, sizeY, house);
        setAttributes(25,1,1,8);
        initializeAnimations();
    }
    @Override
    public void initializeAnimations(){
        animationManager.putNewAnimation(AnimationState.idle, new AnimationGameObject(animationSpeed, 4, Constants.getVillager_idleAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.walk, new AnimationGameObject(animationSpeed -15, 6, Constants.getVillager_walkAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.attack, new AnimationGameObject(animationSpeed, 4, Constants.getVillager_attackAnimationAddress(),8));
        animationManager.putNewAnimation(AnimationState.hurt, new AnimationGameObject(animationSpeed, 2, Constants.getVillager_hurtAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.die, new AnimationGameObject(animationSpeed, 4, Constants.getVillager_deathAnimationAddress(), 15));
    }
    @Override
    protected void move() {
       super.move();
       if(moving && !isDead()){
        updatePositionX(speed);
        if(positionX > (Window.getWindowWidth() - Constants.getGeneral_character_sizeX()) || positionX < 100 || checkForCollision(house.getHitbox())){
            speed *=-1;
        }
        changingTheDirection();
       }
    }
}
