package de.diewolfbuddies.retris.frames;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.swing.*;
import java.awt.*;

public class CreditsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JButton back_Button;

	private JLabel credits;

	private JLabel developers;
	private JLabel programmer1;

	private JLabel supported_by;
	private JLabel supporter1;

	private JLabel texturepack_creator;
	private JLabel texturepack_creator_Name;

	private JLabel background;

	public CreditsFrame() {

		FrameHandler.setCurrentFrame(this);
		
		//Panel setup
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		panel.setBackground(Color.BLACK);

		background = new JLabel(new ImageIcon(TexturesHandler.getWallpaper("MainMenu1")));
		background.setBounds(0, 0, Retris.WIDTH, Retris.HEIGHT);
		
		//Button setup
		back_Button = TexturesHandler.getButtonTemplate();
		
		back_Button.setName("BackButton");
		back_Button.addMouseListener(Retris.getButtonHandler());
		back_Button.setLocation(Retris.WIDTH / 2 - 100, 600);
		
		back_Button.setText("Zurück");
		
		//Text setup
		credits = new JLabel("CREDITS");
		credits.setBounds(0, 50, Retris.WIDTH, 150);
		credits.setHorizontalAlignment(0);

		developers = new JLabel("Entwickler:");
		developers.setBounds(0, 250, Retris.WIDTH, 50);
		developers.setHorizontalAlignment(0);

		programmer1 = new JLabel("Ruben Martins");
		programmer1.setBounds(0, 280, Retris.WIDTH, 50);
		programmer1.setHorizontalAlignment(0);

		supported_by = new JLabel("Mit Hilfe von:");
		supported_by.setBounds(0, 340, Retris.WIDTH, 50);
		supported_by.setHorizontalAlignment(0);

		supporter1 = new JLabel("Cyril Kuhny");
		supporter1.setBounds(0, 370, Retris.WIDTH, 50);
		supporter1.setHorizontalAlignment(0);

		texturepack_creator = new JLabel("Texturepack von:");
		texturepack_creator.setBounds(0, 430, Retris.WIDTH, 50);
		texturepack_creator.setHorizontalAlignment(0);

		texturepack_creator_Name = new JLabel(Retris.getTexturepackMaker());
		texturepack_creator_Name.setBounds(0, 460, Retris.WIDTH, 50);
		texturepack_creator_Name.setHorizontalAlignment(0);

		//Set fonts
		
		credits.setFont(TexturesHandler.getTitleFont());
		developers.setFont(TexturesHandler.getCreditsCategoryFont());
		programmer1.setFont(TexturesHandler.getCreditsNameFont());
		supported_by.setFont(TexturesHandler.getCreditsCategoryFont());
		supporter1.setFont(TexturesHandler.getCreditsNameFont());
		texturepack_creator.setFont(TexturesHandler.getCreditsCategoryFont());
		texturepack_creator_Name.setFont(TexturesHandler.getCreditsNameFont());

		//Coloring

		credits.setForeground(Retris.getSetting("Title"));
		developers.setForeground(Retris.getSetting("Credits-Developer"));
		programmer1.setForeground(Retris.getSetting("Credits-DeveloperName"));
		supported_by.setForeground(Retris.getSetting("Credits-Supporter"));
		supporter1.setForeground(Retris.getSetting("Credits-SupporterName"));
		back_Button.setForeground(Retris.getSetting("Button"));
		texturepack_creator.setForeground(Retris.getSetting("TexturepackCreator"));
		texturepack_creator_Name.setForeground(Retris.getSetting("TexturepackCreatorName"));


		//Add stuff to panel
		panel.add(back_Button);
		panel.add(credits);
		panel.add(developers);
		panel.add(programmer1);
		panel.add(supported_by);
		panel.add(supporter1);
		panel.add(texturepack_creator);
		panel.add(texturepack_creator_Name);

		pack();

		panel.add(background);
		
		setTitle("Retris - Credits");
		setSize(Retris.WIDTH, Retris.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(TexturesHandler.getLogo());
	}
	
}
