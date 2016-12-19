package bin;

public class Player extends AnimatedObject {
	protected Action action;

	public Player(float x, float y, Animation[] animations) {
		super(x, y, animations);
		action = Action.IDLE;
	}

	public void tick() {
		super.tick();
	}

	public void idle() {
		System.out.println("Idlin");
		action = Action.IDLE;
	}

	public void walkLeft() {
		System.out.println("Walkin left");
		action = Action.WALKLEFT;
	}

	public void walkRight() {
		System.out.println("Walkin right");
		action = Action.WALKRIGHT;
	}

	public void runLeft() {
		System.out.println("Runin left");
		action = Action.RUNLEFT;
	}

	public void runRight() {
		System.out.println("Runin right");
		action = Action.RUNRIGHT;
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

	public void setAction(Action newAction) {
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