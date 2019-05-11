package de.diewolfbuddies.retris;


import de.diewolfbuddies.retris.enums.FrameType;
import de.diewolfbuddies.retris.enums.GameMode;
import de.diewolfbuddies.retris.handlers.*;
import de.diewolfbuddies.retris.objects.GameLogicObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Retris {

	public static int HEIGHT = 800;
	public static int WIDTH = 800;

	private static HoverClickHandler buttonHandler;
	
	private static AudioHandler audioHandler;
	private static TexturepackHandler texturepackHandler;
	private static GameLogicObject gamelogic;

	private static GameModeHandler gameModeHandler;

	private static File settings;
	private static HashMap<String, Color> csHash = new HashMap<>();
	private static HashMap<String, Float> fontHash = new HashMap<>();
	private static String texturepackMaker;

	private static boolean secret = false;

	public static int final_score = 0;

	public static void main(String[] args) {

		gameModeHandler = new GameModeHandler(GameMode.NORMAL);
		texturepackHandler = new TexturepackHandler();
		appySettings();

		// ONLY CALL ON START
		texturepackHandler.loadDefaultAfterStart();

		buttonHandler = new HoverClickHandler();
		FrameHandler.goToFrame(FrameType.START);

		audioHandler = new AudioHandler();
		audioHandler.startMusic("Main_Menu.wav", "Main Menu", 0.1F);

	}

	public static void appySettings() {
		csHash.clear();
		fontHash.clear();
		texturepackMaker = "N/A";
		settings = texturepackHandler.getSettings();
		try(Scanner input = new Scanner(settings)) {
				while(input.hasNextLine()) {
					String line = input.nextLine();

					/*
					 *
					 *	Colors
					 *
					 */

					if(line.contains("Titles: ")) {
						String numbers = line.replaceAll("Titles: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Title", new Color(r, g, b));
					} else if(line.contains("Music: ")) {
						String numbers = line.replaceAll("Music: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Music", new Color(r, g, b));
					} else if(line.contains("Texturepack: ")) {
						String numbers = line.replaceAll("Texturepack: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Texturepack", new Color(r, g, b));
					} else if(line.contains("TexturepackName: ")) {
						String numbers = line.replaceAll("TexturepackName: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("TexturepackName", new Color(r, g, b));
					} else if(line.contains("GameMode: ")) {
						String numbers = line.replaceAll("GameMode: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Gamemode", new Color(r, g, b));
					} else if(line.contains("GameModeName: ")) {
						String numbers = line.replaceAll("GameModeName: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("GamemodeName", new Color(r, g, b));
					} else if(line.contains("Buttons: ")) {
						String numbers = line.replaceAll("Buttons: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Button", new Color(r, g, b));
					} else if(line.contains("Score: ")) {
						String numbers = line.replaceAll("Score: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Score", new Color(r, g, b));
					} else if(line.contains("GameOver: ")) {
						String numbers = line.replaceAll("GameOver: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("GameOver", new Color(r, g, b));
					} else if(line.contains("Credits-Developer: ")) {
						String numbers = line.replaceAll("Credits-Developer: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Credits-Developer", new Color(r, g, b));
					} else if(line.contains("Credits-DeveloperName: ")) {
						String numbers = line.replaceAll("Credits-DeveloperName: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Credits-DeveloperName", new Color(r, g, b));
					} else if(line.contains("Credits-Supporter: ")) {
						String numbers = line.replaceAll("Credits-Supporter: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Credits-Supporter", new Color(r, g, b));
					} else if(line.contains("Credits-SupporterName: ")) {
						String numbers = line.replaceAll("Credits-SupporterName: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Credits-SupporterName", new Color(r, g, b));
					} else if(line.contains("TexturepackCreator: ")) {
						String numbers = line.replaceAll("TexturepackCreator: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("TexturepackCreator", new Color(r, g, b));
					} else if(line.contains("Controls: ")) {
						String numbers = line.replaceAll("Controls: ", "").replaceAll(" ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("Controls", new Color(r, g, b));
					}

					/*
					 *
					 * Font-Sizes
					 *
					 */

					else if(line.contains("Titles_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Titles_FontSize: ", ""));
						fontHash.put("Titles", fontsize);
					} else if(line.contains("Buttons_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Buttons_FontSize: ", ""));
						fontHash.put("Buttons", fontsize);
					} else if(line.contains("Credits_Categorys_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Credits_Categorys_FontSize: ", ""));
						fontHash.put("Credits-Categorys", fontsize);
					} else if(line.contains("Credits_Names_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Credits_Names_FontSize: ", ""));
						fontHash.put("Credits-Names", fontsize);
					} else if(line.contains("Options_Categorys_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Options_Categorys_FontSize: ", ""));
						fontHash.put("Options-Categorys", fontsize);
					} else if(line.contains("Options_Names_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Options_Names_FontSize: ", ""));
						fontHash.put("Options-Names", fontsize);
					} else if(line.contains("GameOver_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("GameOver_FontSize: ", ""));
						fontHash.put("GameOver", fontsize);
					} else if(line.contains("Score_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Score_FontSize: ", ""));
						fontHash.put("Score", fontsize);
					} else if(line.contains("Controls_FontSize: ")) {
						float fontsize = Float.valueOf(line.replaceAll("Controls_FontSize: ", ""));
					fontHash.put("Controls", fontsize);
				}

					/*
					 *
					 * Texts
					 *
					 */

					else if(line.contains("TexturepackCreatorName: ")) {
						String numbers = line.replaceAll("TexturepackCreatorName: ", "");
						int r = Integer.valueOf(numbers.split(",")[0]);
						int g = Integer.valueOf(numbers.split(",")[1]);
						int b = Integer.valueOf(numbers.split(",")[2]);
						csHash.put("TexturepackCreatorName", new Color(r, g, b));
					} else if(line.contains("YourName: ")) {
						texturepackMaker = line.replaceAll("YourName: ", "");
					}

				}

		} catch(IOException e) {
			System.out.println("ColorSettings not found");
		}

	}

	public static Color getSetting(String name) {
		return csHash.get(name);
	}

	public static float getFontSize(String name) {
		System.out.println(name);
		return fontHash.get(name);
	}

	public static void reload() {
		FrameHandler.goToFrame(FrameType.OPTIONS);
		audioHandler.stopMusic();
		audioHandler.startMusic("Main_Menu.wav", "Main Menu", 0.1f);
	}
	

	public static String getDirectory() {
		return System.getenv("ProgramFiles(x86)") + "\\Retris";
	}
	
	public static HoverClickHandler getButtonHandler() {
		return buttonHandler;
	}
	
	public static AudioHandler getAudioHandler() {
		return audioHandler;
	}

	public static TexturepackHandler getTexturepackHandler() {
		return texturepackHandler;
	}

	public static void setGameLogic(GameLogicObject logic) {
		gamelogic = logic;
	}

	public static GameLogicObject getGameLogic() {
		return gamelogic;
	}

	public static GameModeHandler getGameModeHandler() { return gameModeHandler; }

	public static BufferedImage ToBufferedImage(Image img) {
		if (img instanceof BufferedImage)
		{
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	public static String getTexturepackMaker() {
		return texturepackMaker;
	}

	public static void activateSecret() {
		secret = true;
	}

	public static boolean isSecretActive() {
		return secret;
	}

}
