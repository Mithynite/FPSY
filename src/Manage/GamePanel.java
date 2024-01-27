package Manage;

import GameObjects.Player;
import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel{
    private Game game;
    public Game getGame() {
        return game;
    }
    public GamePanel(Game game, Player player) {
        initialize();
        this.game = game;
        this.addKeyListener(new KeyBoardInputs(this));
        this.addMouseListener(new MouseInputs(this));
    }
    private void initialize() {
        this.setBounds(0, 0, Window.getWindowWidth(), Window.getWindowHeight());
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        try {
            game.renderIt(graphics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
