package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.utils.TexturePack;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TexturepackHandler {

	private TexturePack pack;
	private File packfolder;

	private TexturePack[] texturePacks;
	private File[] texturepacksFolders;
	private int texturepacksIndex = 0;

	public TexturepackHandler() {
		packfolder = new File(Retris.getDirectory() + "\\texturepacks");

		texturepacksFolders = packfolder.listFiles(File::isDirectory);

		texturePacks = new TexturePack[texturepacksFolders.length];
		for(int i = 0; i < texturepacksFolders.length; i++) {
			texturePacks[i] = new TexturePack(texturepacksFolders[i].getName());
			if(texturepacksFolders[i].getName().equals("default"))
				texturepacksIndex = i;

		}

		pack = texturePacks[texturepacksIndex];

	}

	// CALL ONLY ON START!!
	public void loadDefaultAfterStart() {
		pack.load();
	}

	public TexturepackHandler loadPack(String name) {
		for (int i = 0; i < texturePacks.length; i++) {
			if(texturePacks[i].getPackName().equals(name))
				pack = texturePacks[i].load();
		}
		return this;
	}

	public String getPackName() {
		return pack.getPackName();
	}

	public TexturePack[] getPacks() {
		return texturePacks;
	}

	public void unloadPack() {
		pack = new TexturePack("default");
		pack.load();
	}

	public BufferedImage getImage(String path, String name) {

		BufferedImage image = pack.getImage(path, name);
		if (image == null)
				image = pack.getDefaultImage(path, name);


		return image;
	}

	public Font getFont(String name) {
		Font font = pack.getFont(name);
		if (font == null) {
			font = pack.getDefaultFont(name);
		}

		return font;
	}

	public File getMusic(String name) {
		File music = pack.getMusic(name);
		if (music == null) {
			music = pack.getDefaultMusic(name);
			System.out.println("Music \"" + name + "\" in pack \"" + pack.getPackName() + "\" not found...");
		}

		return music;
	}

	public File getSound(String name) {
		File sound = pack.getSound(name);
		if (sound == null) {
			sound = pack.getDefaultSound(name);
		}
		return sound;
	}

	public File getSettings() {
		return pack.getSettings();
	}

	public Boolean hasNext() {
		return !(texturepacksIndex >= (texturePacks.length - 1));
	}

	public Boolean hasPrevious() {
		return !(texturepacksIndex <= 0);
	}

	public void loadNext() {
		if(hasNext()) {
			texturepacksIndex++;
			pack = texturePacks[texturepacksIndex].load();
			Retris.reload();
		}
	}

	public void loadPrevious() {
		if(hasPrevious()) {
			texturepacksIndex--;
			pack = texturePacks[texturepacksIndex].load();
			Retris.reload();
		}
	}

}
