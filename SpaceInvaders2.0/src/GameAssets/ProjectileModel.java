package GameAssets;

import java.io.IOException;

public class ProjectileModel extends GameModels {

	private double moveSpeed = -300;
	private Game game;
	private boolean used = false;
	private int dmg = -1;

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public ProjectileModel getThis() {

		return this;
	}

	public ProjectileModel(Game game, String gameObject, int x, int y) {
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

	public void changeDmg() {

	}

	public void collidedWith(GameModels other) throws IOException, InterruptedException {

		if (used) {

			return;

		}

		if (other instanceof EnemyModel) {

			game.removeGameModels(this);
			game.spawnPowerUps(other);
			other.setHp(dmg);
			if (other.getHp() == 0) {
				game.removeGameModels(other);
				game.notifyEnemyKilled();
			}

			used = true;

		}

	}

}
