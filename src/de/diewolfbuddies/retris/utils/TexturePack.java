package de.diewolfbuddies.retris.utils;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TexturePack {

	private String packname;
	
	public TexturePack(String packname) {
		this.packname = packname;
	}

	public String getPackName() { return packname; }

	public TexturePack load() {

		TexturesHandler.setLogo(getImage("", "Logo"));
		TexturesHandler.setButtonStyle(getImage("GUI", "Button").getSubimage(0, 0, 200, 50).getScaledInstance(200, 50, 4));
		TexturesHandler.setHoverButtonStyle(getImage("GUI", "Button").getSubimage(0, 50, 200, 50).getScaledInstance(200, 50, 4));
		TexturesHandler.setUncheckedCheckBoxStyle(getImage("GUI", "CheckBox").getSubimage(0, 0, 30, 30).getScaledInstance(30, 30, 4));
		TexturesHandler.setCheckedCheckBoxStyle(getImage("GUI", "CheckBox").getSubimage(0, 30, 30, 30).getScaledInstance(30, 30, 4));

		TexturesHandler.setBlocks(getImage("GUI", "Blocks"));
		TexturesHandler.setBlock(BlockColor.RED, getImage("GUI", "Blocks").getSubimage(0, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.GREEN, getImage("GUI", "Blocks").getSubimage(60, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.GRAY, getImage("GUI", "Blocks").getSubimage(120, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.YELLOW, getImage("GUI", "Blocks").getSubimage(180, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.PINK, getImage("GUI", "Blocks").getSubimage(240, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.BLUE, getImage("GUI", "Blocks").getSubimage(300, 0, 60, 60));
		TexturesHandler.setBlock(BlockColor.ORANGE, getImage("GUI", "Blocks").getSubimage(360, 0, 60, 60));



		TexturesHandler.setLeftArrowStyle(getImage("GUI", "ArrowButton").getSubimage(0, 0, 32, 32));
		TexturesHandler.setLeftHoverArrowStyle(getImage("GUI", "ArrowButton").getSubimage(0, 32, 32, 32));
		TexturesHandler.setRightArrowStyle(getImage("GUI", "ArrowButton").getSubimage(32, 0, 32, 32));
		TexturesHandler.setRightHoverArrowStyle(getImage("GUI", "ArrowButton").getSubimage(32, 32, 32, 32));

		TexturesHandler.setWallpaper("MainMenu1", Retris.ToBufferedImage(getImage("GUI\\wallpapers", "Main_Menu_BG").getScaledInstance(Retris.WIDTH, Retris.HEIGHT, 4)));
		TexturesHandler.setWallpaper("Ingame", Retris.ToBufferedImage(getImage("GUI\\wallpapers", "Ingame_BG").getScaledInstance(Retris.WIDTH, Retris.HEIGHT, 4)));
		TexturesHandler.setWallpaper("Gamefield", Retris.ToBufferedImage(getImage("GUI\\wallpapers", "GameField_BG").getScaledInstance(600, 600, 4)));

		TexturesHandler.setTitleFont(getFont("titles.ttf").deriveFont(Retris.getFontSize("Titles")));
		TexturesHandler.setButtonFont(getFont("buttons.ttf").deriveFont(Retris.getFontSize("Buttons")));
		TexturesHandler.setCreditsCategoryFont(getFont("credits_categorys.ttf").deriveFont(Retris.getFontSize("Credits-Categorys")));
		TexturesHandler.setCreditsNameFont(getFont("credits_names.ttf").deriveFont(Retris.getFontSize("Credits-Names")));
		TexturesHandler.setOptionsCategoryFont(getFont("options_categorys.ttf").deriveFont(Retris.getFontSize("Options-Categorys")));
		TexturesHandler.setOptionsNameFont(getFont("options_names.ttf").deriveFont(Retris.getFontSize("Options-Names")));
		TexturesHandler.setGameOverFont(getFont("gameover.ttf").deriveFont(Retris.getFontSize("GameOver")));
		TexturesHandler.setScoreFont(getFont("score.ttf").deriveFont(Retris.getFontSize("Score")));
		TexturesHandler.setControlsFont(getFont("controls.ttf").deriveFont(Retris.getFontSize("Controls")));
		return this;
	}

	public BufferedImage getImage(String path, String name) {
		try {
			File folder = new File(Retris.getDirectory() + "\\texturepacks\\" + packname + "\\images\\" + path);
			if(folder != null && folder.exists()) {
				for(File file : folder.listFiles()) {
					if(file.getName().startsWith(name)) {
						return ImageIO.read(file);
					}
				}
			} else if(!folder.exists()) {
				System.out.println("Game not installed!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Font getFont(String name) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(Retris.getDirectory() + "\\texturepacks\\" + packname + "\\fonts\\" + name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getMusic(String name) {
		return new File(Retris.getDirectory() + "\\texturepacks\\" + packname + "\\music\\" + name);
	}
	
	public File getSound(String name) {
		return new File(Retris.getDirectory() + "\\texturepacks\\" + packname + "\\sounds\\" + name);
	}

	public BufferedImage getDefaultImage(String path, String name) {
		try {
			File folder = new File(Retris.getDirectory()  +"\\texturepacks\\default\\images\\" + path);
			for(File file : folder.listFiles()) {
				if(file.getName().startsWith(name)) {
					return ImageIO.read(file);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Font getDefaultFont(String name) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(Retris.getDirectory() + "\\texturepacks\\default\\fonts\\" + name));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getDefaultMusic(String name) {
		return new File(Retris.getDirectory() + "\\texturepacks\\default\\music\\" + name);
	}

	public File getDefaultSound(String name) {
		return new File(Retris.getDirectory() + "\\texturepacks\\default\\sounds\\" + name);
	}

	public File getSettings() {
		return new File(Retris.getDirectory() + "\\texturepacks\\" + packname + "\\settings.txt");
	}

}
