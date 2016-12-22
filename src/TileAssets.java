package bin;

import java.awt.image.BufferedImage;

public class TileAssets {
	public static BufferedImage dirt;
	public static BufferedImage grass;

	static {
		SpriteLoader.load("tiles/dirt");
		dirt = SpriteLoader.getSprite(0, 0, 16, 16);
		SpriteLoader.load("tiles/grass_side");
		grass = SpriteLoader.getSprite(0, 0, 16, 16);
	}
}