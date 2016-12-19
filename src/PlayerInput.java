package bin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerInput extends KeyAdapter {
	private Player player;
	private KeyEvent lastKey = null;
	private int doublePressSpeed = 500;
	private boolean released = true;
	public PlayerInput(Player player) {
		this.player = player;
	}

	public void keyPressed(KeyEvent e) {//perhaps ignore the input if it matches the state of the player? somehow deal with spammy inputs on hold
		Action newAction = null;
		if(lastKey != null && released && e.getKeyCode() == lastKey.getKeyCode() && ((e.getWhen() - lastKey.getWhen()) < doublePressSpeed)) {
			//Key was double pressed
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				newAction = Action.RUNLEFT;
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				newAction = Action.RUNRIGHT;
			}
		}
		else {
			//Key was pressed once
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				newAction = Action.WALKLEFT;
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				newAction = Action.WALKRIGHT;
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				newAction = Action.JUMP;
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				newAction = Action.CROUCH;
			}
		}

		Action currentAction = player.getAction();

		if(newAction != null && newAction != currentAction && !(newAction == Action.WALKLEFT && currentAction == Action.RUNLEFT) && !(newAction == Action.WALKRIGHT && currentAction == Action.RUNRIGHT)) {
			player.doAction(newAction);
		}

		lastKey = e;
		released = false;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_DOWN) {
				player.idle();
		}
		released = true;
	}
}