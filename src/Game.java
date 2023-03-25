import java.io.IOException;

public class Game implements Runnable, SharedMethods { //extends Thread
    private Player player;
    //private Game gameLoop;
    private ManageTheLevels manage;
    private Thread gameLoop;
    private final int setFPS = 120;
    public Game() throws IOException {
        player = new Player();
        manage = new ManageTheLevels(this);
        Window gameWindow = new Window(player);
        player.requestFocus();
            startGame();
    }
    private void startGame() throws IOException {
        gameLoop = new Thread(this);
        gameLoop.start();
    }
    @Override
    public void update() {
        manage.update();
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
