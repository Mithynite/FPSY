package Scenes;

import GameObjects.House;
import GameObjects.Player;
import GameObjects.PlayerUpgrades;
import MenuSettings.Menu;
import MenuSettings.MenuOption;
import TexturesAndImages.Constants;
import TexturesAndImages.Texture;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Shop extends MenuScene{
	private Menu shop;
	private House house;
	private Player player;
	private int coins;
	public void increaseCoins() {
		this.coins = house.getCompletedWaves();
	}
	public Shop(InGame inGame, House house, Player player) {
		super(inGame);
		this.coins = 0;
		this.house = house;
		this.player = player;
		try {
			createShopMenu();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	private void addDesignToShop() {
		shop.addMenuOption(new MenuOption(600, 200,new Texture(Constants.getMenu_spriteAddress(),500,500), "Shop", 150,0,new Font("Calibri", Font.BOLD, 70), false));
		shop.addMenuOption(new MenuOption(700,340, new Texture(Constants.getHealth_potion_iconAddresss(),80,100),true));
		shop.addMenuOption(new MenuOption(820, 340, new Texture(Constants.getSpeed_iconAddresss(),80,100),true));
		shop.addMenuOption(new MenuOption(940, 340, new Texture(Constants.getBetter_axe_iconAddresss(),80,100),true));
		shop.addMenuOption(new MenuOption(700,520, new Texture(Constants.getMenu_spriteAddress(),300,100), "Start new wave", 70, 60, new Font("Calibri", Font.BOLD, 25), true));
		shop.addMenuOption(new MenuOption(660, 260, new Texture(Constants.getCoin_iconAddress(),25, 30), String.valueOf(coins),30, 25, new Font("Calibri", Font.BOLD, 35), false));
	}
	private void specifyImagesInShop(){
		shop.getOption(0).getImage(610,85, 500, 533);
		shop.getOption(1).getImage(49,13,147,198);
		shop.getOption(2).getImage(27,67,353,253);
		shop.getOption(3).getImage(0,0,420,505);
		shop.getOption(4).getImage(1167,372,326,120);
		shop.getOption(5).getImage(110, 76, 300,348);
	}
	public void setFunctionsToShop(){
		shop.getOption(1).setPlayerUpgrade(PlayerUpgrades.HP);
		shop.getOption(2).setPlayerUpgrade(PlayerUpgrades.Speed);
		shop.getOption(3).setPlayerUpgrade(PlayerUpgrades.Damage);
		shop.getOption(4).switchToScene(InGameScene.Gameplay);
	}
	private void createShopMenu() throws IOException {
		shop = new Menu();
		addDesignToShop();
		specifyImagesInShop();
		setFunctionsToShop();
	}
	public void upgradePlayerAbility(PlayerUpgrades required_PlayerUpgrade, MenuOption current){
		if(!current.wasClicked() && current.isInBounds() && coins > 0){ //TODO snad OK
			String upgrade_name = "";
			switch(required_PlayerUpgrade){
				case HP ->{
					player.setMaxHealth(player.getMaxHealth()+5);
					upgrade_name = "životů";
				}
				case Speed -> {
					player.setSpeed(player.getSpeed() + 1);
					upgrade_name = "rychlosti";
				}
				case Damage -> {
					player.setDamage(player.getDamage() + 2);
					upgrade_name = "sekery";
				}
			}
			System.out.println("Vylepšení " + upgrade_name + " zakoupeno!");
			current.setClicked(true);
			coins--;
		}
	}
	public void updateText(){
		shop.getOption(5).changeText(String.valueOf(coins));
	}
	public void updatingPlayerAbilities(){
		for(MenuOption option: shop.getOptions()){
			if(option.isClickable() && option.getRequired_PlayerUpgrade()!=null){
				upgradePlayerAbility(option.getRequired_PlayerUpgrade(), option);
		}
		}
	}
	public void spawn(){
		if(shop.getOption(4).wasClicked()){
			inGame.getGameplay().setEnemiesActive(true);
		}
		shop.getOption(4).setClicked(false);
	}
	public void shopRender(Graphics graphics){
		shop.renderIt(graphics);
	}
	@Override
	public void renderIt(Graphics graphics) {
		shopRender(graphics);
	}
	@Override
	public void updateIt(){
		shop.updateIt();
		updateText();
		updatingPlayerAbilities();
		spawn();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		updateIt();
	}
}
