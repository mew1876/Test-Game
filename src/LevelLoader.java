package bin;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class LevelLoader {
	public static void load(String file, Handler handler) {
		try {
			BufferedImage tileMap = ImageIO.read(new File("res/maps/" + file + ".png"));
			
			for(int x = 0; x < tileMap.getWidth(); x++) {
				for(int y = 0; y < tileMap.getHeight(); y++) {
					int color = tileMap.getRGB(x, y);

					if(color == 0xffff61ee) {
						//kirby!
						handler.add(0, new Player(x*24, y*24, true));
					}
					else if(color == 0xff945102) {
						//dirt
						handler.add(new Tile(x*24, y*24, TileAssets.dirt));
					}
					else if(color == 0xff06a006){
						//grass
						handler.add(new Tile(x*24, y*24, TileAssets.grass));   
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}