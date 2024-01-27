package GameObjects;

import java.awt.*;
public class GameObject {
    protected int positionX;
    protected int positionY;
    protected int sizeX;
    protected int sizeY;
    protected int hitboxSizeX;
    protected int hitboxSizeY;
    protected int hitboxPosX;
    protected int hitboxPosY;
    protected Rectangle hitbox;
    public GameObject(int positionX, int positionY, int sizeX, int sizeY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public boolean checkForCollision(Rectangle bounds){
        return getHitbox().intersects(bounds);
    }
    public void initializeHitbox(int additional_X, int additional_Y, int width, int height){
        this.hitboxPosX = additional_X;
        this.hitboxPosY = additional_Y;
        this.hitboxSizeX = width;
        this.hitboxSizeY = height;
        this.hitbox = new Rectangle((additional_X+positionX),(additional_Y+positionY),width,height);
    }
    public void updateHitbox(){
        hitbox.y = (positionY+ hitboxPosY);
        if(sizeX < 0){
            hitbox.x = (positionX + sizeX);
        }else if (sizeX > 0){
            hitbox.x = (positionX + hitboxSizeX + hitboxPosX);
        }
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
    protected void drawHitbox(Graphics graphics){
        graphics.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
}

