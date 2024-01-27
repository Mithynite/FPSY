package GameObjects;


import TexturesAndImages.Constants;
import TexturesAndImages.Texture;
import TexturesAndImages.TextureType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class House extends GameObject {
    private Wave[] waves;
    private BufferedImage image;
    private Texture texture;
    private int completedWaves;
    private int currentWaveIndex;
    private int waveAmount;
    private boolean stopAdding;
    public int getCompletedWaves() {
        return completedWaves;
    }
    public void setStopAdding(boolean stopAdding) {
        this.stopAdding = stopAdding;
    }
    public Wave getCurrentWave(){
        return waves[currentWaveIndex];
    }

    public int getWaveAmount() {
        return waveAmount;
    }

    public House(int positionX, int positionY, int sizeX, int sizeY) {
        super(positionX, positionY, sizeX, sizeY);
        this.completedWaves = 0;
        this.currentWaveIndex = 0;
        this.texture = new Texture(TextureType.house, Constants.getHouse_iconAddress(), sizeX,sizeY);
        this.image = texture.getTexture();
        this.stopAdding = true;
    }
    public void createWaves(int maximalAmountOfEnemiesInSingleWave, int amountOfWaves) {
        this.waveAmount = amountOfWaves;
        Random random = new Random();
        waves = new Wave[amountOfWaves];
        for(int fill = 0; fill < amountOfWaves; fill++){
            int enemies = random.nextInt(maximalAmountOfEnemiesInSingleWave)+2;
            waves[fill] = new Wave(enemies, this);
        }
    }
    public void updateComletedWaves(){
        if(waves[currentWaveIndex].isFinished()){
            completedWaves++;
            if(currentWaveIndex+1 != waveAmount && !stopAdding){
                currentWaveIndex++;
                stopAdding = true;
            }
        }
    }
    public void updateCurrentWave(Rectangle playerHitbox, boolean hit, int damage){
        waves[currentWaveIndex].updateIt(hit, playerHitbox, damage);
            updateComletedWaves();
    }
    public void renderEnemies(Graphics graphics){
        waves[currentWaveIndex].render(graphics);
    }
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        //drawHitbox(graphics);
        graphics2D.drawImage(image, positionX, positionY, texture.getWidth(), texture.getHeight(),null);
    }
}
