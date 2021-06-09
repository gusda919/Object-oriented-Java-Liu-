package GameAssets;

public class SpeedBuff extends PowerUps {

	private double moveSpeed = 150;
	private Game game;
	private boolean used = false;

	public SpeedBuff(Game game, String resource, int x, int y) {
		super(game, resource, x, y);
		this.game = game;
		dy = moveSpeed;

	}

	@Override
	public void collidedWith(GameModels other) {

		if (used) {

			return;

		}

		if (other instanceof ShipModel) {

		    game.SpeedBuff();
			game.removeGameModels(this);

			used = true;

		}

	}

}
