package Inputs;
import Manage.*;
import Scenes.GameScene;
import Scenes.InGameScene;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputs implements MouseListener {
    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(GameScene.getCurrentGameScene().equals(GameScene.MMenu)){
            gamePanel.getGame().getMain_menu().mouseClicked(e);
        }
        if(GameScene.getCurrentGameScene().equals(GameScene.InGame) && InGameScene.getCurrentInGameScene().equals(InGameScene.Shop)){
            gamePanel.getGame().getIn_game().getShop().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
