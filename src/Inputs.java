import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Inputs implements KeyListener{
    private int horizontalMovement;
    private int vertiqalMovement;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;
    public boolean isUp() {
        return up;
    }
    public boolean isDown() {
        return down;
    }
    public boolean isRight() {
        return right;
    }
    public boolean isLeft() {
        return left;
    }
    public int getHorizontalMovement() {
        return horizontalMovement;
    }
    public void setHorizontalMovement(int horizontalMovement) {
        this.horizontalMovement = horizontalMovement;
    }
    public int getVertiqalMovement() {
        return vertiqalMovement;
    }
    public void setVertiqalMovement(int vertiqalMovement) {
        this.vertiqalMovement = vertiqalMovement;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        Player player = null;
        try {
            player = new Player();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                setVertiqalMovement(-player.getSpeed());
                System.out.println("W Pressed");
                up = true;
                break;
            case KeyEvent.VK_A:
                setHorizontalMovement(-player.getSpeed());
                System.out.println("A Pressed");
                left = true;
                break;
            case KeyEvent.VK_S:
                setVertiqalMovement(player.getSpeed());
                System.out.println("S Pressed");
                down = true;
                break;
            case KeyEvent.VK_D:
                setHorizontalMovement(player.getSpeed());
                System.out.println("D Pressed");
                right = true;
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                up = false;
                if(!down) setVertiqalMovement(0);
                break;
            case KeyEvent.VK_A:
                left = false;
                if(!right) setHorizontalMovement(0);
                break;
            case KeyEvent.VK_S:
                down = false;
                if(!up) setVertiqalMovement(0);
                break;
            case KeyEvent.VK_D:
                right = false;
                if(!left) setHorizontalMovement(0);
                break;
        }
    }
}
