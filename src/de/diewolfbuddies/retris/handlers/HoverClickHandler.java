package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.enums.FrameType;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HoverClickHandler implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			
			switch(button.getName()) {
			case "QuitButton":
				System.exit(0);
				break;
			case "StartButton":
				Retris.getAudioHandler().playSound("Game_Start.wav", 0.25f);
				FrameHandler.goToFrame(FrameType.GAME);
				Retris.getAudioHandler().stopMusic("Main Menu");
				if(Retris.isSecretActive()) {
					Retris.getAudioHandler().startMusic("Ingame_Remix.wav", "Ingame Music", 0.1f);
				} else {
					Retris.getAudioHandler().startMusic("Ingame_Music.wav", "Ingame Music", 0.1f);
				}
				break;
			case "OptionsButton":
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				FrameHandler.goToFrame(FrameType.OPTIONS);
				break;
			case "CreditsButton":
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				FrameHandler.goToFrame(FrameType.CREDITS);
				break;
			case "BackButton":
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				FrameHandler.goToFrame(FrameType.START);
				break;
			case "PauseButton":
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				Retris.getGameLogic().togglePause();
				break;
			case "GameEnd":
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				Retris.getGameLogic().gameOver();
				break;

			case "Restart":
				Retris.final_score = 0;
				Retris.getAudioHandler().playSound("Button_Click.wav", 0.25f);
				Retris.getAudioHandler().startMusic("Main_Menu.wav", "Main Menu", 0.1f);
				FrameHandler.goToFrame(FrameType.START);
				break;

			case "TexturepackArrowLeft":
				Retris.getTexturepackHandler().loadPrevious();
				break;
			case "TexturepackArrowRight":
				Retris.getTexturepackHandler().loadNext();
				break;
			case "GamemodeArrowLeft":
				Retris.getGameModeHandler().loadPrevious();
				break;
			case "GamemodeArrowRight":
				Retris.getGameModeHandler().loadNext();
				break;
			}
		} else if(e.getSource() instanceof JCheckBox) {
			JCheckBox box = (JCheckBox) e.getSource();
			switch(box.getName()) {
			case "Music":
				if(box.isSelected()) {
					System.out.println("Box unselect triggered");
					box.setIcon(TexturesHandler.getUncheckedCheckBoxStyle());
					Retris.getAudioHandler().canPlay(false);
					Retris.getAudioHandler().stopMusic();
					System.out.println("Music disabled");
					break;
				} else {
					System.out.println("Box select triggered");
					box.setIcon(TexturesHandler.getCheckedCheckBoxStyle());
					Retris.getAudioHandler().canPlay(true);
					Retris.getAudioHandler().startMusic("Main_Menu.wav", "Main Menu", 0.1f);
					System.out.println("Music enabled");
					break;
				}
				
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(!(e.getSource() instanceof JButton)) return;
		JButton button = (JButton) e.getSource();

		if(!button.getName().contains("Arrow")) {
			button.setIcon(TexturesHandler.getHoverButtonStyle());
		} else {
			if(button.getName().contains("ArrowLeft")) {
				if(!button.getIcon().equals(TexturesHandler.getLeftArrowStyle())) return;
				button.setIcon(TexturesHandler.getLeftHoverArrowStyle());
			}
			if(button.getName().contains("ArrowRight")) {
				if(!button.getIcon().equals(TexturesHandler.getRightArrowStyle())) return;
				button.setIcon(TexturesHandler.getRightHoverArrowStyle());
			}
		}

		Retris.getAudioHandler().playSound("Button_Hover.wav", 0.1f);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(!(e.getSource() instanceof JButton)) return;
		JButton button = (JButton) e.getSource();

		if(!button.getName().contains("Arrow")) {
			button.setIcon(TexturesHandler.getButtonStyle());
		} else {

			String buttonName = button.getName();

			if (buttonName.equals("TexturepackArrowRight")) {
				if (!Retris.getTexturepackHandler().hasNext()) return;
				button.setIcon(TexturesHandler.getRightArrowStyle());
			}
			if (buttonName.equals("TexturepackArrowLeft")) {
				if (!Retris.getTexturepackHandler().hasPrevious()) return;
				button.setIcon(TexturesHandler.getLeftArrowStyle());
			}
			if (buttonName.equals("GamemodeArrowRight")) {
				if (!Retris.getGameModeHandler().hasNext()) return;
				button.setIcon(TexturesHandler.getRightArrowStyle());
			}
			if (buttonName.equals("GamemodeArrowLeft")) {
				if (!Retris.getGameModeHandler().hasPrevious()) return;
				button.setIcon(TexturesHandler.getLeftArrowStyle());
			}
		}
		Retris.getAudioHandler().playSound("Button_Unhover.wav", 0.1f);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	
	
}
