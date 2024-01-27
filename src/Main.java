import Manage.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Game game;
        try {
            game = new Game();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        game.startGame();
    }
}
