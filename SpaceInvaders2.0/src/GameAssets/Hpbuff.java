package GameAssets;
/*
 * powerupclass med annan colidedwith metod
 */
public class Hpbuff extends PowerUps {

	private double moveSpeed = 150;
	private Game game;
	private boolean used = false;

	public Hpbuff(Game game, String resource, int x, int y) {
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

			game.useHP();
			game.removeGameModels(this);

			used = true;

		}

	}

}
