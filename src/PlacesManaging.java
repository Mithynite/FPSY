import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlacesManaging implements SharedMethods{
    private Window window = new Window();
    private Texture grass = new Texture(TextureType.grass, false, "Pictures/Grass.png", 90, 160);
    /*public void paste(Graphics g){
        g.drawImage(spriteParts[2], 0,0,null);
    }*/
    public void pasteTexture(Graphics graphics) throws IOException {
        int sizeX = window.getWidth()/ grass.getWidth();
        int sizeY = window.getHeight()/ grass.getHeight();
        BufferedImage tmp = grass.getTexture();
            Graphics2D graphics2D = (Graphics2D) graphics;
            for (int a = 0; a < 2; a++)
                for (int b = 0; b < sizeY; b++)
                    graphics2D.drawImage(tmp, 160*a, 90*b, grass.getWidth(), grass.getHeight(), null);
    }
    private void countCorrectDisplaySizes(){

    }
    /*public void importSprites() throws IOException {
        BufferedImage current = GetImages.GetImage(GetImages.grassImageAddress);
        spriteParts = new BufferedImage[16];
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++){
                int index = x*4 + y;
                spriteParts[index] = current.getSubimage(x*4,y*4, 4, index);
            }
    }*/
    @Override
    public void update(){

    }
}