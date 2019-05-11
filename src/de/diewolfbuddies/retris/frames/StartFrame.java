package de.diewolfbuddies.retris.frames;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	
	private JPanel panel;
	private JButton start_Button;
	private JButton options_Button;
	private JButton close_Button;
	private JButton credits_Button;
	private JLabel logotext;
	private JLabel background;

	private int secret_position = 0;
	private int[] secret_codes = new int[] {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};

	public StartFrame() {
		
		FrameHandler.setCurrentFrame(this);

		//Panel setup
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		background = new JLabel(new ImageIcon(TexturesHandler.getWallpaper("MainMenu1")));
		background.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		//Button Setup
		
		start_Button = TexturesHandler.getButtonTemplate();
		options_Button = TexturesHandler.getButtonTemplate();
		credits_Button = TexturesHandler.getButtonTemplate();
		close_Button = TexturesHandler.getButtonTemplate();
		
		
		start_Button.setName("StartButton");
		options_Button.setName("OptionsButton");
		credits_Button.setName("CreditsButton");
		close_Button.setName("QuitButton");
		
		start_Button.setText("Spiel starten");
		options_Button.setText("Optionen");
		credits_Button.setText("Credits");
		close_Button.setText("Spiel beenden");
		
		start_Button.setLocation(Retris.WIDTH / 2 - 100, 300);
		options_Button.setLocation(Retris.WIDTH / 2 - 100, 400);
		credits_Button.setLocation(Retris.WIDTH / 2 - 100, 500);
		close_Button.setLocation(Retris.WIDTH / 2 - 100, 600);
		
		start_Button.addMouseListener(Retris.getButtonHandler());
		options_Button.addMouseListener(Retris.getButtonHandler());
		credits_Button.addMouseListener(Retris.getButtonHandler());
		close_Button.addMouseListener(Retris.getButtonHandler());
		
		//Text setup
		logotext = new JLabel("Retris");
		logotext.setBounds(0, 50, Retris.WIDTH, 150);
		logotext.setHorizontalAlignment(0);
		//Set fonts

		logotext.setFont(TexturesHandler.getTitleFont());
		start_Button.setFont(TexturesHandler.getButtonFont());
		options_Button.setFont(TexturesHandler.getButtonFont());
		credits_Button.setFont(TexturesHandler.getButtonFont());
		close_Button.setFont(TexturesHandler.getButtonFont());

		//Coloring
		logotext.setForeground(Retris.getSetting("Title"));
		start_Button.setForeground(Retris.getSetting("Button"));
		options_Button.setForeground(Retris.getSetting("Button"));
		close_Button.setForeground(Retris.getSetting("Button"));
		credits_Button.setForeground(Retris.getSetting("Button"));

		//Add stuff to panel
		panel.add(start_Button);
		panel.add(options_Button);
		panel.add(close_Button);
		panel.add(credits_Button);
		panel.add(logotext);
		
		panel.add(background);


		//Frame setup
		setTitle("Retris");
		setSize(Retris.WIDTH, Retris.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setIconImage(TexturesHandler.getLogo());
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(this);

		if(Retris.isSecretActive()) {
			setTitle("Retris - Secret Mode!");
			logotext.setText("CHEAT UNLOCKED!");
			logotext.setFont(TexturesHandler.getTitleFont().deriveFont(logotext.getFont().getSize() - 70f));
			JLabel label = new JLabel("Have fun with the remix!");
			label.setFont(TexturesHandler.getTitleFont().deriveFont(logotext.getFont().getSize() - 50f));
			label.setBounds(logotext.getX(), logotext.getY() + logotext.getHeight() - 20, Retris.WIDTH, 50);
			label.setForeground(Retris.getSetting("Title"));
			label.setHorizontalAlignment(0);
			panel.remove(background);
			panel.add(label);
			panel.add(background);
			this.update(getGraphics());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {

		if(Retris.isSecretActive()) return;

		if(secret_position == 9) {
			Retris.activateSecret();
			setTitle("Retris - Secret Mode!");
			logotext.setText("CHEAT UNLOCKED!");
			logotext.setFont(TexturesHandler.getTitleFont().deriveFont(logotext.getFont().getSize() - 70f));
			JLabel label = new JLabel("Have fun with the remix!");
			label.setFont(TexturesHandler.getTitleFont().deriveFont(logotext.getFont().getSize() - 50f));
			label.setBounds(logotext.getX(), logotext.getY() + logotext.getHeight() - 20, Retris.WIDTH, 50);
			label.setForeground(Retris.getSetting("Title"));
			label.setHorizontalAlignment(0);
			panel.remove(background);
			panel.add(label);
			panel.add(background);
			this.update(getGraphics());
			Retris.getAudioHandler().playSound("Game_Start.wav", 0.3f);

			return;
		}

		if(e.getKeyCode() == secret_codes[secret_position]) {
			Retris.getAudioHandler().playSound("Button_Click.wav", 0.025f);
			System.out.println("Correct answer");
			secret_position++;
		} else {
			System.out.println("Wrong answer, expected \"" + secret_codes[secret_position] + "\"");
			secret_position = 0;
		}
	}
}


