package bin;

import java.awt.Graphics;

public class Player extends AnimatedObject {
	protected Action action;

	public Player(float x, float y) {
		super(x, y);
		idle();
	}

	public Player(float x, float y, boolean visible) {
		super(x, y, visible);
		idle();
	}

	public void tick() {
		super.tick();
	}

	public void idle() {
		System.out.println("Idlin");
		action = Action.IDLE;
		setAnimation(PlayerAssets.animations[0]);
	}

	public void walkLeft() {
		System.out.println("Walkin left");
		action = Action.WALKLEFT;
		inverted = true;
		setAnimation(PlayerAssets.animations[1]);
	}

	public void walkRight() {
		System.out.println("Walkin right");
		action = Action.WALKRIGHT;
		inverted = false;
		setAnimation(PlayerAssets.animations[1]);
	}

	public void runLeft() {
		System.out.println("Runin left");
		action = Action.RUNLEFT;
		inverted = true;
		setAnimation(PlayerAssets.animations[2]);
	}

	public void runRight() {
		System.out.println("Runin right");
		action = Action.RUNRIGHT;
		inverted = false;
		setAnimation(PlayerAssets.animations[2]);
	}

	public void jump() {
		System.out.println("Jumpin");
		action = Action.JUMP;
		System.out.println("Landed");
		idle();
	}

	public void crouch() {
 		System.out.println("Crouchin");
 		action = Action.CROUCH;
	}

	public Action getAction() {
		return action;
	}

	public void doAction(Action newAction) {
		switch(newAction) {
			case IDLE:
				idle();
				break;
			case WALKLEFT:
				walkLeft();
				break;
			case WALKRIGHT:
				walkRight();
				break;
			case RUNLEFT:
				runLeft();
				break;
			case RUNRIGHT:
				runRight();
				break;
			case JUMP:
				jump();
				break;
			case CROUCH:
				crouch();
				break;
		}
	}
}