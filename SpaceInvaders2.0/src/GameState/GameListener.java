package GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import GameAssets.Game;

public class GameListener extends KeyAdapter {
	private Game g;
	private boolean KeyNotPressed = true;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean SpacePressed = false;
	private boolean UpPressed = false;
	private boolean DownPressed = false;
	private boolean userInput = true;

	public boolean isUserInput() {
		return userInput;
	}

	public void setUserInput(boolean userInput) {
		this.userInput = userInput;
	}

	private int pressCount = 1;

	public GameListener() {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (KeyNotPressed) {

			return;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			SpacePressed = true;
			System.out.println("jadå");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			UpPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			DownPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (KeyNotPressed) {
			return;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			SpacePressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			UpPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			DownPressed = false;
		}
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public boolean isKeyNotPressed() {
		return KeyNotPressed;
	}

	public void setKeyNotPressed(boolean keyNotPressed) {
		KeyNotPressed = keyNotPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public boolean isSpacePressed() {
		return SpacePressed;
	}

	public void setSpacePressed(boolean spacePressed) {
		SpacePressed = spacePressed;
	}

	public boolean isUpPressed() {
		return UpPressed;
	}

	public void setUpPressed(boolean upPressed) {
		UpPressed = upPressed;
	}

	public boolean isDownPressed() {
		return DownPressed;
	}

	public void setDownPressed(boolean downPressed) {
		DownPressed = downPressed;
	}

	public int getPressCount() {
		return pressCount;
	}

	public void setPressCount(int pressCount) {
		this.pressCount = pressCount;
	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (KeyNotPressed) {
			if (pressCount == 1) {

				KeyNotPressed = false;
				setUserInput(true);

				pressCount = 0;
			}

			else {
				pressCount++;
			}

		}
		if (e.getKeyChar() == 27) {

			System.exit(0);

		}

	}

	public GameListener getListener() {

		return this;
	}
}
