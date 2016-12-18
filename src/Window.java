package bin;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Window extends JFrame {
	public Window(int width, int height, String title, Game game) {
		super(title);

		setPreferredSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(game);
		game.start();
	}
}