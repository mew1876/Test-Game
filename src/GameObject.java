package bin;

public class GameObject{
	protected int x, y, vX = 0, vY = 0;
	protected BufferedImage img = null;
	protected boolean visible = false;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		x += vX;
		y += vY;
	}

	public void render(Graphics g) {
		if(visible) {
			g.drawImage(x, y, img, null);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVelX() {
		return vX;
	}

	public int getVelY() {
		return vY;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelX(int vX) {
		this.vX = vX;
	}

	public void setVelY(int vY) {
		this.vY = vY;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}