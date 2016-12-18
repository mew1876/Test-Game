package bin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader {
    private static BufferedImage spriteSheet;

    public static void loadSheet(String file) {
        spriteSheet = null;

        try {
            spriteSheet = ImageIO.read(new File("res/" + file + ".png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getSprite(int xPos, int yPos, int xSize, int ySize) {
        return spriteSheet.getSubimage(xPos, yPos, xSize, ySize);
    }
}