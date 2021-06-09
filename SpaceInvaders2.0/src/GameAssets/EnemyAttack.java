package GameAssets;

import java.io.IOException;
/*
 * fiendes projectile class, med en annan colidedwith metod
 * 
 * 
 * 
 */
public class EnemyAttack extends GameModels {

	private double moveSpeed = 150;
	private Game game;
	private boolean used = false;

	public EnemyAttack(Game game, String gameObject, int x, int y) {
		super(gameObject, x, y);
		this.game = game;
		dy = moveSpeed;

	}

	public void move(long delta) {

		super.move(delta);

		if (y < -100) {

			game.removeGameModels(this);
		}

	}

	public void collidedWith(GameModels other) throws IOException {

		if (used) {

			return;

		}

		if (other instanceof ShipModel) {

			game.removeGameModels(this);
			game.playerHit();

			used = true;

		}

	}

}
