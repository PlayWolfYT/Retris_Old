package de.diewolfbuddies.retris.frames;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("FieldCanBeLocal")
public class OptionsFrame extends JFrame /*implements ChangeListener */{

	private static final long serialVersionUID = 1L;

	
	private JPanel panel;
	
	private JLabel title;

	private JLabel music_label;
	private JCheckBox music_cbox;

	private JButton back_Button;
	
	private JLabel texturepack_label;
	private JButton texturepack_previous;
	private JButton texturepack_next;
	private JLabel texturepack_name;

	private JLabel gamemode_label;
	private static JButton gamemode_previous;
	private static JButton gamemode_next;
	private static JLabel gamemode_name;

	private Timer timer;

	//private JSlider volume;
	//private JLabel volume_label;

	private JLabel background;


	public OptionsFrame() {

		FrameHandler.setCurrentFrame(this);

		//Panel setup
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);

		background = new JLabel(new ImageIcon(TexturesHandler.getWallpaper("MainMenu1")));
		background.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);

		//Button setup
		music_cbox = TexturesHandler.getCheckboxTemplate();
		back_Button = TexturesHandler.getButtonTemplate();
		texturepack_previous = TexturesHandler.getLeftArrowButtonTemplate();
		texturepack_next = TexturesHandler.getRightArrowButtonTemplate();
		gamemode_previous = TexturesHandler.getLeftArrowButtonTemplate();
		gamemode_next = TexturesHandler.getRightArrowButtonTemplate();

		//volume = new JSlider(JSlider.HORIZONTAL, 0, 100,(int) (Retris.getAudioHandler().getMasterVolume() * 100));
		//volume.setMajorTickSpacing(50);

		//volume_label = new JLabel("Lautstaerke: ");
		//volume_label.setFont(TexturesHandler.getOptionsCategoryFont());
		//volume_label.setBounds(50, 400, 400, 30);
		//volume_label.setForeground(Retris.getSetting("GameMode"));

		if(!Retris.getTexturepackHandler().hasPrevious())
			texturepack_previous.setIcon(TexturesHandler.getLeftHoverArrowStyle());
		if(!Retris.getTexturepackHandler().hasNext())
			texturepack_next.setIcon(TexturesHandler.getRightHoverArrowStyle());

		if(!Retris.getGameModeHandler().hasPrevious())
			gamemode_previous.setIcon(TexturesHandler.getLeftHoverArrowStyle());
		if(!Retris.getGameModeHandler().hasNext())
			gamemode_next.setIcon(TexturesHandler.getRightHoverArrowStyle());


		music_cbox.setName("Music");
		back_Button.setName("BackButton");
		texturepack_previous.setName("TexturepackArrowLeft");
		texturepack_next.setName("TexturepackArrowRight");

		gamemode_previous.setName("GamemodeArrowLeft");
		gamemode_next.setName("GamemodeArrowRight");

		back_Button.setText("Zurück");

		music_cbox.addMouseListener(Retris.getButtonHandler());

		back_Button.addMouseListener(Retris.getButtonHandler());
		texturepack_next.addMouseListener(Retris.getButtonHandler());
		texturepack_previous.addMouseListener(Retris.getButtonHandler());
		gamemode_next.addMouseListener(Retris.getButtonHandler());
		gamemode_previous.addMouseListener(Retris.getButtonHandler());
		//volume.addChangeListener(this);

		music_cbox.setLocation(Retris.WIDTH / 2 - 25, 250);
		back_Button.setLocation(Retris.WIDTH / 2 - 100, 600);
		texturepack_previous.setBounds(Retris.WIDTH / 2 - 32, 300, 32, 32);
		texturepack_next.setBounds(Retris.WIDTH / 2 + 300 + 32, 300, 32, 32);
		//volume.setBounds(Retris.WIDTH / 2 - 25, 400, 200, 10);

		gamemode_previous.setBounds(Retris.WIDTH / 2 - 32, 350, 32, 32);
		gamemode_next.setBounds(Retris.WIDTH / 2 + 300 + 32, 350, 32, 32);
		//Text setup

		title = new JLabel("Optionen");
		title.setBounds(0, 50, Retris.WIDTH, 150);
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);

		music_label = new JLabel("Musik:");
		music_label.setBounds(50, 250, 400, 30);
		music_label.setForeground(Color.white);

		texturepack_label = new JLabel("Texturepack:");
		texturepack_label.setBounds(50, 300, 400, 30);
		texturepack_label.setForeground(Color.white);

		texturepack_name = new JLabel(Retris.getTexturepackHandler().getPackName());
		texturepack_name.setBounds(Retris.WIDTH / 2 + 25, 300, 250, 30);
		texturepack_name.setForeground(Color.darkGray);

		gamemode_label = new JLabel("Spielmodus:");
		gamemode_label.setBounds(50, 350, 400, 30);
		gamemode_label.setForeground(Color.white);

		gamemode_name = new JLabel(Retris.getGameModeHandler().getGameMode().getName());
		gamemode_name.setBounds(Retris.WIDTH / 2 + 25, 350, 250, 30);
		gamemode_name.setForeground(Color.darkGray);

		//Set fonts
		title.setFont(TexturesHandler.getTitleFont());
		music_label.setFont(TexturesHandler.getOptionsCategoryFont());
		texturepack_label.setFont(TexturesHandler.getOptionsCategoryFont());
		texturepack_name.setFont(TexturesHandler.getOptionsNameFont());
		gamemode_label.setFont(TexturesHandler.getOptionsCategoryFont());
		gamemode_name.setFont(TexturesHandler.getOptionsNameFont());

		//Coloring
		title.setForeground(Retris.getSetting("Title"));
		music_label.setForeground(Retris.getSetting("Music"));
		texturepack_label.setForeground(Retris.getSetting("Texturepack"));
		texturepack_name.setForeground(Retris.getSetting("TexturepackName"));
		gamemode_label.setForeground(Retris.getSetting("Gamemode"));
		gamemode_name.setForeground(Retris.getSetting("GamemodeName"));
		back_Button.setForeground(Retris.getSetting("Button"));

		//Add stuff to panel
		panel.add(title);
		panel.add(music_cbox);
		panel.add(music_label);
		panel.add(texturepack_previous);
		panel.add(texturepack_next);
		panel.add(texturepack_label);
		panel.add(texturepack_name);
		panel.add(gamemode_next);
		panel.add(gamemode_previous);
		panel.add(gamemode_label);
		panel.add(gamemode_name);

		//panel.add(volume);
		//panel.add(volume_label);

		panel.add(back_Button);

		panel.add(background);

		pack();

		//Frame setup
		add(panel);
		setTitle("Retris - Options");
		setSize(Retris.WIDTH,Retris.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(TexturesHandler.getLogo());


		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				texturepack_name.setText(Retris.getTexturepackHandler().getPackName());
			}
		}, 0, 5000);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(Retris.getAudioHandler().canPlay()) {
				music_cbox.setIcon(TexturesHandler.getCheckedCheckBoxStyle());
				music_cbox.setSelected(false);
			} else {
				music_cbox.setSelected(true);
				music_cbox.setIcon(TexturesHandler.getUncheckedCheckBoxStyle());
				}	}
		}, 0, 2000);

	}

	public static void updateGameMode(String gamemode) {
		gamemode_name.setText(gamemode);
	}

	public static void updateArrows() {
		if(!Retris.getGameModeHandler().hasPrevious())
			gamemode_previous.setIcon(TexturesHandler.getLeftHoverArrowStyle());
		else
			gamemode_previous.setIcon(TexturesHandler.getLeftArrowStyle());

		if(!Retris.getGameModeHandler().hasNext())
			gamemode_next.setIcon(TexturesHandler.getRightHoverArrowStyle());
		else
			gamemode_next.setIcon(TexturesHandler.getRightArrowStyle());
	}

	//@Override
	//public void stateChanged(ChangeEvent e) {
	//	if(e.getSource() == volume) {
	//		Retris.getAudioHandler().setMasterVolume((float) volume.getValue() / 100);
	//	}
	//}
}
