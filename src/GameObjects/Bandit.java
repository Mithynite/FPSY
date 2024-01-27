package GameObjects;

import AnimationSettings.AnimationGameObject;
import AnimationSettings.AnimationState;
import Manage.*;
import TexturesAndImages.*;

public class Bandit extends Enemy {
    public Bandit(int positionX, int positionY, int sizeX, int sizeY, House house) {
        super(positionX, positionY, sizeX, sizeY, house);
        setAttributes(20,1,5,12);
        initializeAnimations();
    }
    @Override
    public void initializeAnimations(){
        animationManager.putNewAnimation(AnimationState.idle, new AnimationGameObject(animationSpeed, 4, Constants.getBandit_idleAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.walk, new AnimationGameObject(animationSpeed -10, 6, Constants.getBandit_walkAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.attack, new AnimationGameObject(animationSpeed, 6, Constants.getBandit_attackAnimationAddress(),8));
        animationManager.putNewAnimation(AnimationState.hurt, new AnimationGameObject(animationSpeed, 3, Constants.getBandit_hurtAnimationAddress()));
        animationManager.putNewAnimation(AnimationState.die, new AnimationGameObject(animationSpeed, 6, Constants.getBandit_deathAnimationAddress(), 15));
    }

    @Override
    protected void move() {
        super.move();
        if(moving && !isDead()){
        updatePositionY(speed);
        moving = true;
        if(positionY>(Window.getWindowHeight()- Constants.getGeneral_character_sizeY())||positionY<20 || checkForCollision(house.getHitbox())){//TODO Mohlo by být RANDOM
            speed *=-1;
        }
            changingTheDirection();
        }
    }
}
