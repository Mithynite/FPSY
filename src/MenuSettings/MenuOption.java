package MenuSettings;

import GameObjects.PlayerUpgrades;
import Scenes.GameScene;
import Scenes.InGameScene;
import TexturesAndImages.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;
public class MenuOption{
    private int coorX;
    private int coorY;
    private int additionalTextCoorX;
    private int additionalTextCoorY;
    private Font textFont;
    private Texture texture;
    private String text;
    private BufferedImage icon;
    private  boolean clickable;
    private boolean clicked;
    private GameScene required_GameScene;
    private InGameScene required_InGameScene;
    private PlayerUpgrades required_PlayerUpgrade;

    public boolean isClickable() {
        return clickable;
    }
    public boolean wasClicked() {
        return clicked;
    }
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    public MenuOption(int coordinatesX, int coordinatesY, Texture texture, String text, int additionalTextCoorX, int additionalTextCoorY, Font font, boolean clickable) {
        this.texture = texture;
        this.text = text;
        this.coorX = coordinatesX;
        this.coorY = coordinatesY;
        this.additionalTextCoorX = additionalTextCoorX;
        this.additionalTextCoorY = additionalTextCoorY;
        this.clickable = clickable;
        this.textFont = font;
        this.clicked = false;
    }
    public MenuOption(int coorX, int coorY, Texture texture, boolean clickable) {
        this.text = "";
        this.additionalTextCoorX = 0;
        this.additionalTextCoorY = 0;
        this.textFont = null;
        this.coorX = coorX;
        this.coorY = coorY;
        this.texture = texture;
        this.clickable = clickable;
    }
    public void changeText(String changedText){
        this.text = changedText;
    }
    public void switchToScene(GameScene required_scene){
        this.required_GameScene = required_scene;
    }
    public void switchToScene(InGameScene required_ingame_scene){
        this.required_InGameScene = required_ingame_scene;
    }
    public void setPlayerUpgrade(PlayerUpgrades upgrade){
        this.required_PlayerUpgrade = upgrade;
    }
    public PlayerUpgrades getRequired_PlayerUpgrade() {
        return required_PlayerUpgrade;
    }
    public void getImage(int x, int y, int sizeX, int sizeY){
        icon = texture.getTexture().getSubimage(x,y,sizeX,sizeY);
    }
    public void renderIt(Graphics graphics) {
        graphics.setFont(textFont);
        graphics.drawImage(icon, coorX, coorY, texture.getWidth(), texture.getHeight(), null);
        if(isInBounds()&&isClickable()){
            graphics.drawRect(coorX, coorY, texture.getWidth(), texture.getHeight());
        }
        graphics.drawString(text, coorX+additionalTextCoorX, coorY+additionalTextCoorY);
    }
    public boolean isInBounds(){
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        boolean x_condition = Math.abs(mousePos.getX())>coorX && Math.abs(mousePos.getX())<(coorX+texture.getWidth());
        boolean y_condition = mousePos.getY()>coorY && mousePos.getY()<(coorY+texture.getHeight());
        return x_condition && y_condition;
    }
    public void updateIt() {
        if(isInBounds() && required_GameScene != null && isClickable()){
            GameScene.setCurrentGameScene(required_GameScene);
            setClicked(true);
        }
        if(isInBounds() && required_InGameScene != null && isClickable()){
            setClicked(true);
            InGameScene.setCurrentInGameScene(required_InGameScene);
        }
    }
}
