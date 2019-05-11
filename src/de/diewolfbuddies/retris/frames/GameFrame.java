package de.diewolfbuddies.retris.frames;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.HoverClickHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;
import de.diewolfbuddies.retris.objects.GameBoardObject;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panel;
	
	private JButton pause_Button;
	private JButton quit_Button;
	
	private JLabel background;
	
	public static GameBoardObject gameBoard;

	public static int gb_WIDTH = 600;
	public static int gb_HEIGHT = 600;

	public GameFrame() {
		
		FrameHandler.setCurrentFrame(this);
		setName("Ingame");
		setTitle("Retris - Ingame");


		//Panel setup
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		
		background = new JLabel(new ImageIcon(TexturesHandler.getWallpaper("Ingame").getScaledInstance(Retris.WIDTH, Retris.HEIGHT, 10)));
		background.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		//Board setup

		//gameBoard = Retris.getGameModeHandler().getGameBoard();
		gameBoard = Retris.getGameModeHandler().startGameBoard(gb_WIDTH, gb_HEIGHT);
		//gameBoard.setBounds(50, 50, gb_WIDTH, gb_HEIGHT);

		//gameBoard = new GameBoardOld(scoreBar);
		//gameBoardOld.start();
		//gameBoardOld.setBounds(50, 50, 600, 600);


		// Text setup

		JLabel controls_arrow_left = null, controls_arrow_right = null, controls_arrow_up = null, controls_arrow_down = null, controls_spacebar = null, controls_shift = null;

		switch(Retris.getGameModeHandler().getGameMode()) {
			case NORMAL:
				controls_arrow_left = new JLabel("[LEFT] / A : Links");
				controls_arrow_right = new JLabel("[RIGHT] / D : Rechts");
				controls_arrow_up = new JLabel("[UP] / W : R-Drehen");
				controls_arrow_down = new JLabel("[DOWN] / S : L-Drehen");
				controls_spacebar = new JLabel("[SPACE] : Fallen lassen");
				controls_shift = new JLabel("[SHIFT] : Schneller");
				break;
			case LEFTRIGHT:
				controls_arrow_left = new JLabel("[LEFT] / [A] : L-Drehen");
				controls_arrow_right = new JLabel("[RIGHT] / [D] : R-Drehen");
				controls_arrow_up = new JLabel("[UP] / [W] : Hoch");
				controls_arrow_down = new JLabel("[DOWN] / [S] : Runter");
				controls_spacebar = new JLabel("[SPACE] : Fallen lassen");
				controls_shift = new JLabel("[SHIFT] : Schneller");
				break;
			case T_ONLY:
				controls_arrow_left = new JLabel("[LEFT] / [A] : Nach Links");
				controls_arrow_right = new JLabel("[RIGHT] / [D] : Nach Rechts");
				controls_arrow_up = new JLabel("[UP] / [W] : R-Drehen");
				controls_arrow_down = new JLabel("[DOWN] / [S] : L-Drehen");
				controls_spacebar = new JLabel("[SPACE] : Fallen lassen");
				controls_shift = new JLabel("[SHIFT] : Schneller");
				break;
			case UPSIDEDOWN:
				controls_arrow_left = new JLabel("[LEFT] / [A] : Nach Links");
				controls_arrow_right = new JLabel("[RIGHT] / [D] : Nach Rechts");
				controls_arrow_up = new JLabel("[UP] / [W] : L-Drehen");
				controls_arrow_down = new JLabel("[DOWN] / [S] : R-Drehen");
				controls_spacebar = new JLabel("[SPACE] : Fallen lassen");
				controls_shift = new JLabel("[SHIFT] : Schneller");
				break;
			default:
					break;
		}

		controls_arrow_left.setBounds(50,75 + gb_HEIGHT, 200, 50);
		controls_arrow_left.setFont(TexturesHandler.getControlsFont());
		controls_arrow_left.setForeground(Retris.getSetting("Controls"));

		controls_arrow_right.setBounds(50, 100 + gb_HEIGHT, 200, 50);
		controls_arrow_right.setFont(TexturesHandler.getControlsFont());
		controls_arrow_right.setForeground(Retris.getSetting("Controls"));

		controls_arrow_up.setBounds(50 + 200, 75 + gb_HEIGHT, 200, 50);
		controls_arrow_up.setFont(TexturesHandler.getControlsFont());
		controls_arrow_up.setForeground(Retris.getSetting("Controls"));

		controls_arrow_down.setBounds(50 + 200, 100 + gb_HEIGHT, 200, 50);
		controls_arrow_down.setFont(TexturesHandler.getControlsFont());
		controls_arrow_down.setForeground(Retris.getSetting("Controls"));

		controls_spacebar.setBounds(50 + 200 + 200, 75 + gb_HEIGHT, 200, 50);
		controls_spacebar.setFont(TexturesHandler.getControlsFont());
		controls_spacebar.setForeground(Retris.getSetting("Controls"));

		controls_shift.setBounds(50 + 200 + 200, 100 + gb_HEIGHT, 200, 50);
		controls_shift.setFont(TexturesHandler.getControlsFont());
		controls_shift.setForeground(Retris.getSetting("Controls"));

		//Button setup
		pause_Button = TexturesHandler.getButtonTemplate();
		quit_Button = TexturesHandler.getButtonTemplate();

		pause_Button.setText("Pause");
		quit_Button.setText("Beenden");

		pause_Button.setName("PauseButton");
		quit_Button.setName("GameEnd");
		
		quit_Button.setBounds(Retris.WIDTH - 125, 430, 100, 25);
		pause_Button.setBounds(Retris.WIDTH - 125, 400, 100, 25);
		
		quit_Button.addMouseListener(new HoverClickHandler());
		pause_Button.addMouseListener(new HoverClickHandler());

		//Coloring
		pause_Button.setForeground(Retris.getSetting("Button"));
		quit_Button.setForeground(Retris.getSetting("Button"));

		//Add stuff to panel

		panel.add(controls_arrow_left);
		panel.add(controls_arrow_right);
		panel.add(controls_arrow_up);
		panel.add(controls_arrow_down);
		panel.add(controls_spacebar);
		panel.add(controls_shift);

		panel.add(gameBoard);
		panel.add(pause_Button);
		panel.add(quit_Button);
		panel.add(gameBoard.getScoreBar());

		panel.add(background);

		pack();

		add(panel);
		setSize(Retris.WIDTH,Retris.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(TexturesHandler.getLogo());

	}
}
