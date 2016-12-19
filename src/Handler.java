package bin;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler extends ArrayList<GameObject> {
	public void tick() {
		for(int i = 0; i < size(); i++) {
			get(i).tick();
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < size(); i++) {
			get(i).render(g);
		}
	}
}