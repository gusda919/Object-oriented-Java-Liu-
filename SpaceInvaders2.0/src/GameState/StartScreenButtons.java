package GameState;

import GameAssets.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreenButtons extends JPanel {

	public StartScreenButtons(final MainFrame frame) {

		this.setLayout(new GridLayout(1, 3));

		JButton start = new JButton("Start");

		JButton exit = new JButton("Exit");

		ArrayList<JButton> allBtns = new ArrayList<>();
		allBtns.add(start);
		allBtns.add(exit);

		for (JButton btn : allBtns) {
			btn.setPreferredSize(new Dimension(40, 40));
		}

		for (JButton btn : allBtns) {
			this.add(btn);
		}

		start.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.startGame();

				System.out.println("asdsad");
			}

		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}

		});
	}

}
