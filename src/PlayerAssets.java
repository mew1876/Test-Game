package bin;

import java.awt.image.BufferedImage;

public class PlayerAssets {
	public static Animation[] animations;

	static {
		SpriteLoader.loadSheet("kirby");
		animations = new Animation[] {	new Animation(new BufferedImage[] {SpriteLoader.getSprite(9, 9, 24, 22), SpriteLoader.getSprite(38, 9, 24, 22), SpriteLoader.getSprite(67, 9, 24, 22)}, 6),
										new Animation(new BufferedImage[] {SpriteLoader.getSprite(6, 67, 26, 23), SpriteLoader.getSprite(37, 68, 24, 22), SpriteLoader.getSprite(66, 70, 23, 20), SpriteLoader.getSprite(94, 69, 23, 21), SpriteLoader.getSprite(122, 68, 24, 22), SpriteLoader.getSprite(151, 67, 26, 23), SpriteLoader.getSprite(182, 68, 24, 22), SpriteLoader.getSprite(211, 70, 23, 20), SpriteLoader.getSprite(239, 69, 21, 21), SpriteLoader.getSprite(265, 68, 22, 22)}, 4),
										new Animation(new BufferedImage[] {SpriteLoader.getSprite(6, 96, 30, 24), SpriteLoader.getSprite(41, 97, 23, 23), SpriteLoader.getSprite(69, 98, 21, 22), SpriteLoader.getSprite(95, 97, 22, 23), SpriteLoader.getSprite(122, 97, 23, 23), SpriteLoader.getSprite(150, 97, 22, 23), SpriteLoader.getSprite(177, 98, 22, 22), SpriteLoader.getSprite(203, 97, 23, 23)}, 2, 1)};
		animations[0].updateFrameDuration(0, 300);
	}
}