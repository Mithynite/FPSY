package Scenes;
import AnimationSettings.AnimationState;
import GameObjects.House;
import GameObjects.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
public class Gameplay {
	private InGame inGame;
	private House house;
	private Player player;
	private boolean enemiesActive;
	private int enemyIndexCounter;
	public void setEnemiesActive(boolean enemiesActive) {
		this.enemiesActive = enemiesActive;
	}
	public Gameplay(House house, Player player, InGame inGame) {
		this.player = player;
		this.house = house;
		this.inGame = inGame;
		this.enemyIndexCounter = 0;
	}
	public void checkForShopOpen(boolean isInBounds, AnimationState currentPlayerState){
		if(isInBounds && currentPlayerState.equals(AnimationState.attack) && !enemiesActive){
			InGameScene.setCurrentInGameScene(InGameScene.Shop);
		}
	}
	public void renderEnemies(Graphics graphics){
		if(enemiesActive){
			house.renderEnemies(graphics);
		}
	}
	public void updateEnemies(){
		if(enemiesActive){
			house.updateCurrentWave(player.getHitbox(), player.hit(), player.getDamage());
		}
		if(house.getCurrentWave().isFinished()){
			enemiesActive = false;
			house.setStopAdding(false);
			inGame.getShop().increaseCoins();
		}
	}
	public int updateEnemyIndexCounter(){

		if(!(house.getCurrentWave().getAlive_enemies()-1 <= enemyIndexCounter)){
			enemyIndexCounter++;
		}else{
			enemyIndexCounter = 0;
		}
		return enemyIndexCounter;
	}
	public void renderIt(Graphics graphics) {
		renderEnemies(graphics);
		player.renderIt(graphics);
	}
	public void updateIt(){
		updateEnemyIndexCounter();
		checkForShopOpen(player.checkForCollision(house.getHitbox()), player.getAnimationState());
		player.updateIt();
		house.updateHitbox();
		updateEnemies();
		//player.checkForHitFromAttacker(house.getCurrentWave().getEnemyByIndex(enemyIndexCounter).getHitbox(), house.getCurrentWave().getEnemyByIndex(enemyIndexCounter).hit(), house.getCurrentWave().getEnemyByIndex(enemyIndexCounter).getDamage());
	}

	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W -> player.setUp(true);
			case KeyEvent.VK_A -> player.setLeft(true);
			case KeyEvent.VK_S -> player.setDown(true);
			case KeyEvent.VK_D -> player.setRight(true);
			case KeyEvent.VK_ENTER -> player.attackManage(true);
		}
		player.setMoving(true);
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W -> player.setUp(false);
			case KeyEvent.VK_A -> player.setLeft(false);
			case KeyEvent.VK_S -> player.setDown(false);
			case KeyEvent.VK_D -> player.setRight(false);
			case KeyEvent.VK_ENTER -> player.attackManage(false);
		}
		player.setMoving(false);
	}
	
}
