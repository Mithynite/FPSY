import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GetImages {//TODO
    public static final String grassImageAddress ="/Pictures/Grass.png";

    public static BufferedImage GetImage(String address) throws IOException {
        BufferedImage requiredImage;
        try (InputStream is = GetImages.class.getResourceAsStream(address)) {
            requiredImage = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException("Nelze přečíst");
        }
        return requiredImage;
    }

}