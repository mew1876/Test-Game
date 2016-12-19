package bin;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class GameObject{
	protected float x, y, vX = 0f, vY = 0f;
	protected BufferedImage img = null;
	protected boolean visible = false, inverted = false, lastInverted = false;

	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public GameObject(float x, float y, boolean visible) {
		this.x = x;
		this.y = y;
		this.visible = visible;
	}

	public void tick() {
		x += vX;
		y += vY;
	}

	public void render(Graphics g) {
		if(visible) {
			if(inverted && !lastInverted) {
				AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
				tx.translate(-img.getWidth(null), 0);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
				img = op.filter(img, null);
				lastInverted = true;
			}

			g.drawImage(img, (int)x, (int)y, null);
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getVelX() {
		return vX;
	}

	public float getVelY() {
		return vY;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isInverted() {
		return inverted;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setVelX(float vX) {
		this.vX = vX;
	}

	public void setVelY(float vY) {
		this.vY = vY;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}
}