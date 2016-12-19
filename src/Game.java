package bin;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;	
	private Thread thread;
	private boolean running = false;

	private Handler handler;

	public Game() {
		new Window(WIDTH, HEIGHT, "Test Game", this);
	}

	private void init() {
		handler = new Handler();
		handler.add(new Player(WIDTH/2, HEIGHT/2, true));
		addKeyListener(new PlayerInput((Player)handler.get(0)));
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

		g.setColor(Color.GREEN);
		g.fillRect(0, 0, WIDTH, HEIGHT);

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
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
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
