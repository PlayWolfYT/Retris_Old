package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.utils.Audio;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({"WeakerAccess", "Duplicates"})
public class AudioHandler {
	
	private final HashMap<String, Audio> musichash = new HashMap<>();
	private final ArrayList<String> musicnames = new ArrayList<>();
	
	private Boolean canPlay = true;

	private float masterVolume = 0.2f;

	public void startMusic(String filepath, String name, float volume) {
		if(!canPlay()) return;
		if(!exists(filepath)) return;
		if(volume > masterVolume) volume = masterVolume;
		Audio audio = new Audio(filepath);
		audio.playMusic(volume);
		musichash.put(name, audio);
		musicnames.add(name);
	}
	
	public void playSound(String name, float volume) {
		if(!exists(name)) return;
		if(volume > masterVolume) volume = masterVolume;
		Audio audio = new Audio(name).playSound(volume);
	}

	public boolean exists(String name) {
		return new Audio(name).isPlayable();
	}
	
	public void stopMusic(String name) {
		if(!musichash.containsKey(name)) {
			System.err.println("Music " + name + " was never started.");
			return;
		}
		
		Audio audio = musichash.get(name);
		audio.unloadMusic();
		musichash.remove(name);
		musicnames.remove(name);
	}
	
	public void pauseMusic(String name) {
		if(!musichash.containsKey(name)) {
			System.err.println("Music " + name + " was never started.");
			return;
		}
		Audio audio = musichash.get(name);
		audio.stopMusic();

		System.out.println(name + " paused");
	}
	
	public void resumeMusic(String name) {
		if(!canPlay()) return;
		if(!musichash.containsKey(name)) {
			System.err.println("Music \"" + name + "\" was never started.");
			return;
		}
		Audio audio = musichash.get(name);
		audio.resumeMusic();

		System.out.println(name + " resumed");
	}
	
	public void setVolume(String name, float volume) {
		if(!musichash.containsKey(name)) {
			System.err.println("Music \"" + name + "\" was never started.");
			return;
		}
		if(volume > masterVolume) volume = masterVolume;

		Audio audio = musichash.get(name);
		audio.setVolume(volume);
	}
	
	public void setMasterVolume(float masterVolume) {
		this.masterVolume = masterVolume;
		for(String name : musicnames) {
			Audio audio = musichash.get(name);
			audio.setVolume(masterVolume);
		}
	}
	
	public void pauseAll() {
		musicnames.forEach(this::pauseMusic);
	}
	
	public void resumeAll() {
		if(canPlay()) {
			musicnames.forEach(this::resumeMusic);
		}
	}
	
	public void canPlay(Boolean can) {
		this.canPlay = can;
		if(!can) {
			stopMusic();
		}
	}
	
	public Boolean canPlay() {
		return canPlay;
	}
	
	public void stopMusic() {
			for(String names : musicnames) {
				if(!musichash.containsKey(names)) {
					System.err.println("Music " + names + " was never started.");
					return;
				}

				Audio audio = musichash.get(names);
				audio.unloadMusic();
				musichash.remove(names);
			}
			musicnames.clear();
	}

	public Float getMasterVolume() {
		return masterVolume;
	}

}
