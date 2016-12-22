package bin;

import java.awt.image.BufferedImage;

public class BGAssets {
	public static BufferedImage sky;
	public static BufferedImage[] clouds;

	static {
		SpriteLoader.load("backgrounds/sky");
		sky = SpriteLoader.getSprite(0, 0, 640, 480);

		clouds = new BufferedImage[3];
		SpriteLoader.load("backgrounds/clouds/clouds1");
		clouds[0] = SpriteLoader.getSprite(0, 0, 640, 240);
		SpriteLoader.load("backgrounds/clouds/clouds2");
		clouds[1] = SpriteLoader.getSprite(0, 0, 640, 240);
		SpriteLoader.load("backgrounds/clouds/clouds3");
		clouds[2] = SpriteLoader.getSprite(0, 0, 640, 240);
	}
}