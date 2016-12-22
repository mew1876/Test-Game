package bin;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class LayeredBackground {
	protected BufferedImage background;
	protected BufferedImage[] layers;

	public LayeredBackground(BufferedImage bg, BufferedImage[] layers) {
		this.layers = layers;
		background = bg;
	}

	public void render(Graphics g, int offset) {
		g.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		for(int i = 0; i < layers.length; i++) {
			g.drawImage(layers[i], (Game.WIDTH - offset/(layers.length -i)) % Game.WIDTH, 0, null);
		}
	}
}