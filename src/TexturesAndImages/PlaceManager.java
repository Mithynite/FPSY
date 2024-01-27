package TexturesAndImages;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class PlaceManager{
    private Texture grass = new Texture(TextureType.grass, Constants.getGrass_backgroundAddress(), 200, 200);
    public void pasteTexture(Graphics graphics) throws IOException { //TODO
        BufferedImage tmp = grass.getTexture();
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (int a = 0; a < 10; a++)
            for (int b = 0; b < 6; b++)
                graphics2D.drawImage(tmp, grass.getWidth() * a, grass.getHeight() * b, grass.getWidth(), grass.getHeight(), null);
    }
}
