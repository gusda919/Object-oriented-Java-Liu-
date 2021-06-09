package GameAssets;

import GameState.GameListener;


import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.WindowAdapter;

import java.awt.image.BufferStrategy;

import java.lang.Math;
/*
 * Superklassen där loopen utgår ifrån även här alla logik uppdateras
 * 
 * 
 * 
 */
public class Game extends Canvas {

	private boolean logicRequiredThisLoop = false;
	private boolean gameRunning = true;
	private double moveSpeed = 300;
	private int playerHp = 3;
	private boolean gameWasStarted = false;

	private int level = 1;
	private long lastFire = 0;
	private boolean buff = false;
	private long firingInterval = 300;
	private int enemyCount;
	private String message = "";
	private int score = 0;
	private int highScore = 0;
	private GameListener listener = new GameListener();
	private GameModels ship;
	private BufferStrategy gameBuffer;
	private ArrayList<GameModels> models = new ArrayList<GameModels>();
	private ArrayList<GameModels> removeModels = new ArrayList<GameModels>();
	private static Image backgroundImage;
	private String levelDesign = "3.jpg";
  
	
	public Game() throws NumberFormatException, IOException {

		getLog();

		JFrame gameFrame = new JFrame("Space Invaders");
		JPanel gamePanel = (JPanel) gameFrame.getContentPane();
		JLabel scoreBoard = new JLabel("Score: " + score);

		
		try {

			Game.backgroundImage = ImageIO.read(getClass().getResource(levelDesign));

		} catch (IOException exc) {
			System.out.println("Failed to load background image. Full error: " + exc);
		}

		gamePanel.setPreferredSize(new Dimension(800, 600));
		gamePanel.setLayout(null);

		this.setBounds(0, 0, 800, 600);
		gameFrame.add(scoreBoard, BorderLayout.WEST);

		gamePanel.add(this);

		this.setIgnoreRepaint(true);

		gameFrame.pack();
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);

		gameFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(listener);
		this.requestFocus();

		this.createBufferStrategy(2);
		this.gameBuffer = getBufferStrategy();

		createGameObjects();

	}

	public boolean isGameWasStarted() {
		return gameWasStarted;
	}

	public void setGameWasStarted(boolean gameWasStarted) {
		this.gameWasStarted = gameWasStarted;
	}

	public Game getGame() {

		return this;
	}

	public void startGame() {

		if (listener.isUserInput()) {

			models.clear();
			createGameObjects();
			listener.setLeftPressed(false);
			listener.setRightPressed(false);
			listener.setSpacePressed(false);
		}
	}

	/**
	 * skapar alla spelobjekt
	 */
	private void createGameObjects() {

		ship = new ShipModel(this, "GameResources/ship.gif", 370, 550);
		models.add(ship);

		enemyCount = 0;
		for (int row = 0; row < 2; row++) {

			for (int x = 0; x < 2 * level; x++) {
				GameModels enemy2 = new EnemyModel(this, "GameResources/alien2.gif", 75 + (x * 100), (100) + row * 50,
						2);
				models.add(enemy2);
				enemyCount++;

			}

			for (int x = 0; x < 4 * level; x++) {
				GameModels enemy = new EnemyModel(this, "GameResources/alien.gif", 100 + (x * 50), (50) + row * 30, 1);
				models.add(enemy);
				enemyCount++;

			}

		}

	}

	public void updateLogic() {
		logicRequiredThisLoop = true;

	}

	public void removeGameModels(GameModels model) {
		removeModels.add(model);
	}

	/**
	 * resetarr spelet men sparar highScore om det var högre en tidigare.
	 * 
	 * @throws IOException
	 */

	public void gameOver() throws IOException {
		message = "Oh no! They got you, try again?";
		listener.setKeyNotPressed(true);

		score = 0;
		level = 1;
		playerHp = 3;
		moveSpeed = 300;
		this.startGame();

		if (highScore < score) {
			saveLog();
		}
	}

	/**
	 * reset listeners, starta om game men lägger till en nivå;
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void playerWins() throws IOException, InterruptedException {

		message = "Level Complete " + score;
		listener.setKeyNotPressed(true);
		this.setGameWasStarted(true);

		score = +score;
		if (highScore < score) {
			highScore = score;
			saveLog();
		}
		level++;
		levelDesign ="level2.jpg";
		
		try {
			Thread.sleep(500);
			Game.backgroundImage = ImageIO.read(getClass().getResource(levelDesign));

		} catch (IOException exc) {
			System.out.println("Failed to load background image. Full error: " + exc);
		}

	
		this.startGame();
		playerHp = 3;
		moveSpeed = 300;

	}

	/**
	 * när vi har slut på antalet fiender så vinner spelaren // anvancerar till
	 * nästa nivå;
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void notifyEnemyKilled() throws IOException, InterruptedException {
		enemyCount--;
		score = score + 50;

		if (enemyCount == 0) {
			playerWins();
		}

		for (int i = 0; i < models.size(); i++) {
			GameModels gameModel = (GameModels) models.get(i);

			if (gameModel instanceof EnemyModel) {

				gameModel.setHorizontalMovement(gameModel.getHorizontalMovement() * 1.02);
			}
		}

	}

	/**
	 * 
	 * spawnar beroend på chans
	 * 
	 * @param model
	 */
	public void spawnPowerUps(GameModels model) {

		int max = 10000;
		int min = 1;
		int range = max - min + 1;
		int rand;

		for (int i = 0; i < 10; i++) {
			rand = (int) (Math.random() * range) + min;

			if (rand < 50) {
				Hpbuff hpBuff = new Hpbuff(this, "GameResources/HpBuff.gif", model.getX(), model.getY());
				models.add(hpBuff);
			}

			if (rand > 950 && rand < 990) {
				SpeedBuff spdBuff = new SpeedBuff(this, "GameResources/PowerUp.gif", model.getX(), model.getY());
				models.add(spdBuff);
			}

		}

	}

	public void SpeedBuff() {

		moveSpeed = 500;

	}

	public void useHP() {

		playerHp = playerHp + 1;
	}

	public void playerHit() throws IOException {

		playerHp--;
		if (playerHp == 0) {
			gameOver();

		}

	}

	/**
	 * 
	 * slumpar siffror, fiender skjuter baserat på chans.
	 * 
	 */
	public void enemyTryFire(GameModels Model) {

		int max = 5000;
		int min = 1;
		int range = max - min + 1;
		int rand;

		for (int i = 0; i < 10; i++) {
			rand = (int) (Math.random() * range) + min;

			if (rand == 50) {

				EnemyAttack projectile = new EnemyAttack(this, "GameResources/shot3.gif", Model.getX(), Model.getY());
				models.add(projectile);

			}

		}

	}

	public boolean isBuff() {
		return buff;
	}

	public void setBuff(boolean buff) {
		this.buff = buff;
	}

	/*
	 * last < firinginterval är till för att minska skottspam, annars så gör vi en
	 * projectile som flyttar sig över skärmen.
	 */
	public void tryToFire() {
		if (System.currentTimeMillis() - lastFire < firingInterval) {

			return;
		}
		lastFire = System.currentTimeMillis();
		ProjectileModel projectile = new ProjectileModel(this, "GameResources/shot.gif", ship.getX() + 10,
				ship.getY() - 30);
		models.add(projectile);

	}

	/**
	 * hämtar highScore....
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void getLog() throws NumberFormatException, IOException {

		FileReader inFile = new FileReader("C:\\Users\\Gusta\\eclipse-workspace\\SpaceInvaders\\log.txt");
		BufferedReader in = new BufferedReader(inFile);
		String line;
		while ((line = in.readLine()) != null) {
			String[] tokens = line.split(",");
			line.split(",");
			highScore = Integer.parseInt(tokens[0]);
		}
		;

		inFile.close();
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	/**
	 * spara highScore
	 * 
	 * @throws IOException
	 */
	public void saveLog() throws IOException {

		FileWriter fileWriter = new FileWriter("SpaceInvaders\\log.txt");
		PrintWriter out = new PrintWriter(fileWriter);
		out.println(highScore + "");
		fileWriter.close();

	}

	/**
	 * gameloopen, vi ritar allt om igen och flyttar spelarn samt kollar alla
	 * listeners.
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void gameLoop() throws IOException, InterruptedException {

		long lastLoopTime = System.currentTimeMillis();

		while (gameRunning) {
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();

			Graphics2D g = (Graphics2D) gameBuffer.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);

			g.setColor(Color.white);
			g.drawImage(backgroundImage, 0, 0, null);

			g.drawString("Current Score: " + score,
					(200 - g.getFontMetrics().stringWidth("current Score: " + score)) / 2, 25);
			g.drawString("High Score: " + highScore,
					(1400 - g.getFontMetrics().stringWidth("current Score: " + score)) / 2, 25);
			g.drawString("Current Level: " + level,
					(100 - g.getFontMetrics().stringWidth("current Score: " + score)) / 2, 575);

			g.drawString("Health: " + playerHp, (1400 - g.getFontMetrics().stringWidth("current Score: " + score)) / 2,
					575);

			if (!listener.isKeyNotPressed()) {
				for (int i = 0; i < models.size(); i++) {
					GameModels gameModel = (GameModels) models.get(i);
					gameModel.move(delta);

				}

			}

			for (int i = 0; i < models.size(); i++) {
				GameModels gameModel = (GameModels) models.get(i);

				gameModel.draw(g);

			}

			for (int k = 0; k < models.size(); k++) {
				for (int j = k + 1; j < models.size(); j++) {

					GameModels object1 = (GameModels) models.get(k);
					GameModels object2 = (GameModels) models.get(j);

					if (object1.collidesWith(object2)) {

						object1.collidedWith(object2);
						object2.collidedWith(object1);

					}

				}

			}
			for (int l = 1; l < models.size(); l++) {
				GameModels object = (GameModels) models.get(l);
				enemyTryFire(object);

			}

			models.removeAll(removeModels);
			removeModels.clear();

			if (logicRequiredThisLoop) {
				for (int i = 0; i < models.size(); i++) {
					GameModels gameModel = (GameModels) models.get(i);
					gameModel.doLogic();

				}
				logicRequiredThisLoop = false;

			}

			if (listener.isKeyNotPressed()) {
				g.setColor(Color.white);
				g.drawString(message, (800 - g.getFontMetrics().stringWidth(message)) / 2, 250);
				g.drawString("Press any key", (800 - g.getFontMetrics().stringWidth("Press any key")) / 2, 300);
			}

			g.dispose();
			gameBuffer.show();

			ship.setHorizontalMovement(0);
			ship.setVerticalMovement(0);

			if ((listener.isLeftPressed()) && (!listener.isRightPressed())) {

				ship.setHorizontalMovement(-moveSpeed);
			} else if ((listener.isRightPressed()) && (!listener.isLeftPressed())) {

				ship.setHorizontalMovement(moveSpeed);

			}
			if ((listener.isUpPressed()) && (!listener.isDownPressed())) {

				ship.setVerticalMovement(moveSpeed);

			}
			if ((listener.isDownPressed()) && (!listener.isUpPressed())) {

				ship.setVerticalMovement(-moveSpeed);

			}
			if (listener.isSpacePressed()) {
				tryToFire();

			}

			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}

		}

	}

	
	public boolean noHp(EnemyAttack enemyAttack) {

		return false;
	}

}
