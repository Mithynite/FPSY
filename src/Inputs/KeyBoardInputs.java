package Inputs;
import Manage.GamePanel;
import Scenes.InGameScene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyBoardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyBoardInputs(GamePanel gamePanel) { //TODO Player
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(InGameScene.getCurrentInGameScene()){
            case Gameplay -> {
                gamePanel.getGame().getIn_game().getGameplay().keyPressed(e);
            }
            }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(InGameScene.getCurrentInGameScene()){
            case Gameplay -> {
                gamePanel.getGame().getIn_game().getGameplay().keyReleased(e);
            }
        }
    }
}
