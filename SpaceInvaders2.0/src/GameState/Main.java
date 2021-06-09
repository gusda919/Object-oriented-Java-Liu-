package GameState;

import GameAssets.Game;
import java.io.IOException;


public class Main {
	private MainFrame gameFrame;
	private boolean startGame = false;

	public static void main(String[] args) throws IOException, InterruptedException {

		Main m = new Main();
		m.runGame();

	}

	public void runGame() throws IOException, InterruptedException {

		MainFrame frame = new MainFrame(this);

		boolean go = false;
		do {
			go = frame.isGameRunning();

			// System.out.println(frame.isGameRunning());
			Thread.sleep(500);
		} while (!go);

		if (frame.isGameRunning()) {
			frame.dispose();
			Game g = new Game();
			g.gameLoop();

		}
	}

	public boolean isStartGame() {
		return startGame;
	}

	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}

}
