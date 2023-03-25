import java.io.IOException;

public class Game extends Thread {
    private Player player;
    private Window gameWindow;
    private Game gameLoop;
    private final int setFPS = 120;
    public Game() throws IOException {
        player = new Player();
        gameWindow = new Window(player); //gameWindow = new Window(player, new Inputs());
    }

    @Override
    public void run(){ //Zatím zbytečné
        double timePerFrame = 1000000000.0/ setFPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                player.repaint();
                lastFrame = now;
            }
        }
    }
}
