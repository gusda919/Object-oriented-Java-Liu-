package GameAssets;

import java.io.IOException;

public class ShipModel extends GameModels {
	private Game game;

	public ShipModel(Game game, String resource, int x, int y) {
		super(resource, x, y);

		this.game = game;
	}

	public void move(long delta) {

		if ((dx < 0) && (x < 10)) {
			return;
		}

		if ((dx > 0) && (x > 750)) {
			return;
		}

		if ((dy < 0) && (y < 350)) {
			return;
		}
		if ((dy > 0) && (y > 550)) {
			return;
		}

		super.move(delta);
	}

	public void collidedWith(GameModels other) throws IOException {
		if (other instanceof EnemyModel) {
			game.gameOver();
		}

	}
}
