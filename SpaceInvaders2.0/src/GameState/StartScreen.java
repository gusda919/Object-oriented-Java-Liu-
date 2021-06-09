package GameState;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import GameAssets.Game;

public class StartScreen extends JPanel {

	private static Image backgroundImg;
	private static Image logo;
	private Game game;
	private int highScore = 0;

	public StartScreen() throws IOException {
		this.setLayout(new BorderLayout());


		try {

			StartScreen.backgroundImg = ImageIO.read(getClass().getResource("1.png"));

		} catch (IOException exc) {
			System.out.println("Failed to load background image. Full error: " + exc);
		}

		try {

			StartScreen.logo = ImageIO.read(getClass().getResource("space-invaders-logo.jpg"));

		} catch (IOException exc) {
			System.out.println("Failed to load background image. Full error: " + exc);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, null);
		g.drawImage(logo, 80, 150, null);
		g.setColor(Color.white);
		g.drawString("High Score: " + highScore, (480 - g.getFontMetrics().stringWidth("current Score: ")) / 2, 460);

	}

}