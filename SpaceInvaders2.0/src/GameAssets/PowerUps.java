package GameAssets;

/*
 * 
 * extendar gameMOdels är abstact.
 */
public abstract class PowerUps extends GameModels {

	private double moveSpeed = 150;
	private Game game;
	private boolean used = false;

	public PowerUps(Game game, String resource, int x, int y) {
		super(resource, x, y);
		this.game = game;
		dy = moveSpeed;

	}

	public void move(long delta) {

		if (y < 500) {
			super.move(delta);

		}

	}

	public abstract void collidedWith(GameModels other);
}
