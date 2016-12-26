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
			int pos = (layers[i].getWidth() * (i + 2) * (i + 2)/layers.length) - (offset/(layers.length - i + 2));

			if(pos > Game.WIDTH) {
				pos -= Game.WIDTH + layers[i].getWidth();
			}
			else if(pos < -layers[i].getWidth()) {
				pos += Game.WIDTH + layers[i].getWidth();
			}

			g.drawImage(layers[i], pos, 0, null);
		}
	}
}