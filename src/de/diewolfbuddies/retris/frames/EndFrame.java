package de.diewolfbuddies.retris.frames;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class EndFrame extends JFrame {

	private static final long serialVersionUID = 1L;


	private JPanel panel;
	private JButton restart_Button;
	private JButton quit_Button;

	private JLabel score_Text;
	private JLabel gameover_Text;

	private JLabel background;
	
	public EndFrame() {

		FrameHandler.setCurrentFrame(this);

		//Panel setup

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		background = new JLabel(new ImageIcon(TexturesHandler.getWallpaper("MainMenu1")));
		background.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		
		//Button setup
		restart_Button = TexturesHandler.getButtonTemplate();
		quit_Button = TexturesHandler.getButtonTemplate();

		restart_Button.setText("Erneut Spielen");
		quit_Button.setText("Beenden");

		restart_Button.setName("Restart");
		quit_Button.setName("QuitButton");

		restart_Button.setLocation(Retris.WIDTH / 2 - 100, Retris.HEIGHT / 2 - 100);
		quit_Button.setLocation(Retris.WIDTH / 2 - 100, Retris.HEIGHT / 2);

		restart_Button.addMouseListener(Retris.getButtonHandler());
		quit_Button.addMouseListener(Retris.getButtonHandler());



		//Text setup

		gameover_Text = new JLabel("Spiel Vorbei");
		gameover_Text.setBounds(0, 50, Retris.WIDTH, 50);
		gameover_Text.setVerticalAlignment(JLabel.CENTER);
		gameover_Text.setHorizontalAlignment(JLabel.CENTER);
		gameover_Text.setFont(TexturesHandler.getGameOverFont());
		gameover_Text.setForeground(Color.red);

		score_Text = new JLabel("Dein Score: " + Retris.final_score);
		score_Text.setBounds(0 , 125, Retris.WIDTH, 40);
		score_Text.setVerticalAlignment(JLabel.CENTER);
		score_Text.setHorizontalAlignment( JLabel.CENTER);
		score_Text.setFont(TexturesHandler.getScoreFont());
		score_Text.setForeground(new Color(36, 244, 91));

		//Coloring
		restart_Button.setForeground(Retris.getSetting("Button"));
		quit_Button.setForeground(Retris.getSetting("Button"));
		score_Text.setForeground(Retris.getSetting("Score"));
		gameover_Text.setForeground(Retris.getSetting("GameOver"));


		//Others setup

		panel.add(restart_Button);
		panel.add(quit_Button);
		panel.add(gameover_Text);
		panel.add(score_Text);
		panel.add(background);

		pack();

		add(panel);
		setTitle("Retris - Game Over");
		setSize(Retris.WIDTH, Retris.HEIGHT);
		setIconImage(TexturesHandler.getLogo());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
