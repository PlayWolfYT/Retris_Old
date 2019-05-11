package de.diewolfbuddies.retris.utils;

import de.diewolfbuddies.retris.Retris;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Audio {
	
	private Clip clip;
	
	private long micros = 0;
	
	private String filepath;
	
	public Audio(String filepath) {
		this.filepath = filepath; 
	}
	
	
	public Audio resumeMusic() {
		if(clip == null) {
			System.err.println("Clip was not started yet.");
			return this;
		}
		try {
			clip.setMicrosecondPosition(micros);				
			clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public Audio playMusic(Float volume) {
		try {
			micros = 0;
			File musicfile = Retris.getTexturepackHandler().getMusic(filepath);
			if(musicfile.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicfile);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				setVolume(volume);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				System.err.println("The musicfile at \"" + filepath + "\" does not exist!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	public Audio stopMusic() {
		if(clip == null) {
			System.err.println("Clip was not started yet.");
			return this;
		}
		micros = clip.getMicrosecondPosition();
		clip.stop();
		return this;
	}
	
	public Audio unloadMusic() {
		clip.stop();
		clip.close();
		return this;
	}
	
	public float getVolume() {
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);   
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}

	public Audio playSound(Float volume) {
		try {
			File soundfile = Retris.getTexturepackHandler().getSound(filepath);
			if(soundfile.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundfile);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				setVolume(volume);
				clip.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}

	public boolean isPlayable() {
		File soundfile = Retris.getTexturepackHandler().getSound(filepath);
		File musicfile = Retris.getTexturepackHandler().getMusic(filepath);
		Boolean isPlayable = true;

		if(soundfile == null && musicfile == null)
			isPlayable = false;

		if(!soundfile.exists() && !musicfile.exists())
			isPlayable = false;

		return isPlayable;
	}
	
	public Audio setVolume(float volume) {
	    if (volume < 0f || volume > 1f) {
	    	throw new IllegalArgumentException("Volume not valid:   " + volume);
	    }

	    try {
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(20f * (float) Math.log10(volume));
		} catch(NullPointerException e) {
			e.printStackTrace();
	    }
		return this;
	}
	
}
