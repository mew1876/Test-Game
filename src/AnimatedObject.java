package bin;

import java.awt.image.BufferedImage;

public class AnimatedObject extends GameObject {
	protected Animation[] animations = null;
	protected Animation currentAnimation = null;

	public AnimatedObject(float x, float y, Animation[] animations) {
		super(x, y);
		this.animations = animations;
	}

	public void tick() {
		super.tick();
		currentAnimation.update();
		img = currentAnimation.getSprite();
	}
}