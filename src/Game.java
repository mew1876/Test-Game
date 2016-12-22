package bin;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {	
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9;	
	private Thread thread;
	private boolean running = false;

	private Handler handler;

	private LayeredBackground bg;

	public Game() {
		new Window(WIDTH, HEIGHT, "Test Game", this);
	}

	private void init() {
		handler = new Handler();
		LevelLoader.load("map1", handler);
		addKeyListener(new PlayerInput((Player)handler.get(0)));

		bg = new LayeredBackground(BGAssets.sky, BGAssets.clouds);
	}

	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();

		if(bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;

		int playerX = (int)handler.get(0).getX();
		int playerY = (int)handler.get(0).getY();

		bg.render(g, playerX);

		g2d.translate(WIDTH/2 - playerX, HEIGHT/2 - playerY);

		handler.render(g);
	
		g.dispose();
		bs.show();
	}	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();	
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();

		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0; 
		boolean newFrame = true;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
				newFrame = true;
			}
			if(running && newFrame) {
				render();
				frames++;
				newFrame = false;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}			
		}
		stop();
	}

	public static void main(String[] args) {
		new Game();		
	}
}
