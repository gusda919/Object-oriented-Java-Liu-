package GameState;

import GameAssets.Game;
import java.awt.event.WindowEvent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	private StartScreen startScreen;
	private StartScreenButtons startButtons;
	private boolean gameRunning = false;
	private Main main;
	private Game game;

//	private StartScreen startScreen;
//	private StartScreenButtons startButtons;
//	private HighScoreButtons highScoreButtons;

	public MainFrame(Main m) throws IOException {

		super("Space Invaders");
		main = m;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(800, 600));
		this.setSize(this.getPreferredSize());
		this.setResizable(false);

		startScreen = new StartScreen();
		startButtons = new StartScreenButtons(this);

		this.add(startScreen, BorderLayout.CENTER);
		this.add(startButtons, BorderLayout.SOUTH);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("X-value: " + (e.getX() - 4) + "\nY-Value: " + (e.getY() - 28));
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public StartScreen getStartScreen() {
		return this.startScreen;
	}

	public int getWidth() {
		return 720;
	}

	public int getHeight() {
		return 628;
	}

	public void startGame() {

		System.out.println(isGameRunning());
		setGameRunning(true);
		System.out.println(isGameRunning());
	}

	public boolean isGameRunning() {
		return gameRunning;
	}

	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}

}
