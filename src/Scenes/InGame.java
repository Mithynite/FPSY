package Scenes;

import GameObjects.House;
import GameObjects.Player;
import TexturesAndImages.*;

import java.awt.*;
import java.io.IOException;
public class InGame {
    private Shop shop;
    private Gameplay gameplay;
    private PlaceManager manage;
    private Player player;
    private House house;

    public Player getPlayer() {
        return player;
    }
    public Gameplay getGameplay() {
        return gameplay;
    }
    public Shop getShop() {
        return shop;
    }

    public InGame() {
        setExternalClasses();
    }
    public void setExternalClasses() {
        manage = new PlaceManager();
        house = new House(-190,-95,Constants.getGeneral_building_sizeX(),Constants.getGeneral_building_sizeY());
        player = new Player(800,200,Constants.getGeneral_character_sizeX(), Constants.getGeneral_character_sizeY(), house);
        shop = new Shop(this, house, player);
        gameplay = new Gameplay(house, player, this);
        createWaves();
        setHitboxes();
    }
    public void setHitboxes(){
        player.initializeHitbox(-60,40,74,80);
        house.initializeHitbox(-100,105,300,280);
    }
    public void createWaves() {
        house.createWaves(4,3);
    }
    public void renderIt(Graphics graphics) {

        try {
            manage.pasteTexture(graphics);
        } catch (IOException e) {
            throw new RuntimeException("Problém týkající se renderování pozadí.");
        }
        house.render(graphics);

        switch(InGameScene.getCurrentInGameScene()){
            case Gameplay -> {
                gameplay.renderIt(graphics);
            }
            case Shop -> {
                shop.renderIt(graphics);
            }
        }
    }
    public void updateIt(){
        switch(InGameScene.getCurrentInGameScene()){
            case Gameplay -> {
               gameplay.updateIt();
            }
            case Shop -> {
            }
        }
    }
    public void focusLost(){
        player.setWindowActivation(false);
        System.out.println("Focus Activation: " + player.isWindowActivation());
    }
    public void focusGained(){
        player.setWindowActivation(true);
        System.out.println("Focus Activation: " + player.isWindowActivation());
    }
}
