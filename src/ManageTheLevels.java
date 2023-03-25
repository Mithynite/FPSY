import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ManageTheLevels implements SharedMethods{
    private Game game;
    private BufferedImage[] spriteParts;

    public ManageTheLevels(Game game) {
        this.game = game;
    }
    public void paste(Graphics g){
        g.drawImage(spriteParts[2], 0,0,null);
    }
   public void importSprites() throws IOException {
        BufferedImage current = GetImages.GetImage(GetImages.grassImageAddress);
        spriteParts = new BufferedImage[16];
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++){
                int index = x*4 + y;
                spriteParts[index] = current.getSubimage(x*4,y*4, 4, index);
            }
    }
    @Override
    public void update(){

    }
}
