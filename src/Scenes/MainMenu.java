package Scenes;

import AnimationSettings.AnimationMenu;
import Manage.Game;
import Manage.Window;
import MenuSettings.Menu;
import MenuSettings.MenuOption;
import TexturesAndImages.Constants;
import TexturesAndImages.Texture;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class MainMenu extends MenuScene{
	private Game game;
	private Menu mainMenu;

    public MainMenu(Game game) {
        super(game);
        setExternalClasses();
    }

    public void setExternalClasses() {
        mainMenu = new Menu();
        try {
            addDesignToMainMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setFunctionsToMainMenu();
        specifyImagesInMainMenu();
	}
	private void addDesignToMainMenu() throws IOException {
        mainMenu.addMenuOption(new MenuOption(0,0,new Texture(Constants.getForest_PictureAddress(),Window.getWindowWidth(), Window.getWindowHeight()),false));
        mainMenu.addMenuOption(new MenuOption(600, 200,new Texture( Constants.getMenu_spriteAddress(),500, 500),false));
        mainMenu.addMenuOption(new MenuOption(680, 300,new Texture(Constants.getMenu_spriteAddress(),350, 150), "PLAY", 100, 80, new Font("Calibri", Font.BOLD, 50), true));
        mainMenu.addAnimation(new AnimationMenu(25,4, Constants.getPlayer_idleAnimationAddress(), 750,400, 200,240));
    }
    private void setFunctionsToMainMenu(){
        mainMenu.getOption(2).switchToScene( GameScene.InGame);
    }
    private void specifyImagesInMainMenu() {
        mainMenu.getOption(0).getImage(0, 0, 1800, 1200);
        mainMenu.getOption(1).getImage(610, 85, 500, 533);
        mainMenu.getOption(2).getImage(70, 90, 500, 283);
    }

    @Override
    public void renderIt(Graphics graphics) {
        mainMenu.renderIt(graphics);
    }
    @Override
    public void updateIt(){
        mainMenu.updateIt();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        updateIt();
    }
}
