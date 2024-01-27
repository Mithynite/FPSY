package Manage;

import Scenes.*;

import java.awt.*;
import java.io.IOException;

public class Game implements Runnable{
    private Window window;
    private GamePanel gameP;
    private MainMenu main_menu;
    private InGame in_game;
    private Thread gameLoop;
     private final int setFPS = 120;
     private final int setUpdates = 200;
    public InGame getIn_game() {
        return in_game;
    }

    public MainMenu getMain_menu() {
        return main_menu;
    }

    public Game() throws IOException{
        setExternalClasses();
        gameP = new GamePanel(this, in_game.getPlayer());
        window = new Window(gameP);
    }
    public void setExternalClasses() {
    	main_menu = new MainMenu(this);
        in_game = new InGame();
    }
    public void renderIt(Graphics graphics) throws IOException {
        switch(GameScene.getCurrentGameScene()){
            case MMenu -> {
                main_menu.renderIt(graphics);
            }
            case InGame -> {
                in_game.renderIt(graphics);
            }
        }
    }
    public void updateIt(){
        switch(GameScene.getCurrentGameScene()){
            case MMenu -> {
            }
            case InGame -> {
                in_game.updateIt();
            }
    }
    }
    public void focusLost(){
        in_game.focusLost();
    }
    public void focusGained(){
        in_game.focusGained();
    }
    public void startGame() {
        gameLoop = new Thread(this);
        gameP.requestFocus();
        gameLoop.start();
    }
    @Override
    public void run(){ //TODO NM
        double timePerFrame = 1000000000.0/ setFPS;
        double timePerUpdate = 1000000000.0/ setUpdates;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                updateIt();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                gameP.repaint();
                deltaF--;
                frames++;
            }
        }
    }
}
