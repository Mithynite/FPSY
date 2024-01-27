package Scenes;

import Manage.Game;
import MenuSettings.Menu;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MenuScene {
    protected Menu menu;
    protected Game game;
    protected InGame inGame;

    public MenuScene(Game game) {
        this.game = game;
    }
    public MenuScene(InGame inGame) {
        this.inGame = inGame;
    }
    protected void setExternalClasses(){
    }
    protected void updateIt(){
    }
    protected void renderIt(Graphics graphics) {
    }
    protected void mouseClicked(MouseEvent e) {
    }
    protected void mousePressed(MouseEvent e) {
    }
    protected void mouseReleased(MouseEvent e) {
    }
    protected void mouseEntered(MouseEvent e) {
    }
    protected void mouseExited(MouseEvent e) {
    }
}
