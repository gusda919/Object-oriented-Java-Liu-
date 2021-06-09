package GameAssets;

import java.io.IOException;
/*
 * fiendens model extendar model.
 * 
 */
public class EnemyModel extends GameModels {
	
	

	private double moveSpeed = 75;
	private Game game;

	public EnemyModel(Game game, String resource, int x, int y, int hp) {
		super(resource, x, y, hp);
		this.game = game;
		dx = -moveSpeed;

	}

	public void move(long delta) {
		if ((dx < 0) && (x < 10)) {
			game.updateLogic();
		}
		if ((dx > 0) && (x > 750)) {
			game.updateLogic();
		}
		super.move(delta);
	}
/*
 * 
 * förhindrar att fiender inte åker ut ur skärmen, det åker ner en "rad" och sen vänder håll.
 */
	public void doLogic() throws IOException {
		dx = -dx;
		y += 10;
		if (y > 570) {
			game.gameOver();
		}
	}

	public void collidedWith(GameModels other) {

	}

}
