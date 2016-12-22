package bin;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile extends GameObject{
	public Tile(float x, float y, BufferedImage img) {
		super(x, y);
		this.img = img;
	}

	public Tile(float x, float y, boolean visible, BufferedImage img) {
		super(x, y, visible);
		this.img = img;
	}

	public void render(Graphics g) {
		g.drawImage(img, (int)x, (int)y, 24, 24, null);
	}
}