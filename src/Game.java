import java.awt.*;
import java.io.IOException;

public class Game implements Runnable, SharedMethods { //extends Thread
    private GamePanel gameP;
    private Player player;
    //private Game gameLoop;
    private PlacesManaging manage;
    private Thread gameLoop;
    private final int setFPS = 120;
    public Game() {
        setExternalClasses();
        manage = new PlacesManaging();
        gameP = new GamePanel(this);
        gameP.requestFocus();
    }
    public void setExternalClasses() {
        player = new Player();
    }
    public Player getPlayer() {
        return player;
    }
    public void render(Graphics graphics) throws IOException {
        manage.pasteTexture(graphics);
        player.render(graphics);
    }
    public void focusLost(){
        player.setWindowActivation(false);
        System.out.println("Focus Activation: " + player.isWindowActivation());
    }
    public void focusGained(){
        player.setWindowActivation(true);
        System.out.println("Focus Activation: " + player.isWindowActivation());
    }
    public void startGame() {
        gameLoop = new Thread(this);
        gameLoop.start();
    }
    @Override
    public void update() {
        gameP.update();
        //manage.update();
    }
    @Override
    public void run(){
        double timePerFrame = 1000000000.0/ setFPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                gameP.repaint();
                update();
                lastFrame = now;
            }
        }
    }
}