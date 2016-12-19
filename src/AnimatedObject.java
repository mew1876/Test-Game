package bin;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class AnimatedObject extends GameObject {
	protected Animation currentAnimation = null;

	public AnimatedObject(float x, float y) {
		super(x, y);
	}

	public AnimatedObject(float x, float y, boolean visible) {
		super(x, y, visible);
	}

	public void tick() {
		super.tick();
		currentAnimation.update();
		img = currentAnimation.getSprite();
		lastInverted = false;
	}

	public void setAnimation(Animation animation) {
		if(currentAnimation != null) {
			currentAnimation.stop();
			currentAnimation.reset();
		}

		currentAnimation = animation;
		currentAnimation.start();
	}
}