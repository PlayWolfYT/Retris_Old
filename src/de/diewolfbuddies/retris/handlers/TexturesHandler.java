package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.utils.BlockColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class TexturesHandler {

	private static HashMap<String, BufferedImage> wallpaperhash = new HashMap<>();

	private static Image logo;

	private static ImageIcon button;

	private static ImageIcon hover_Button;

	private static ImageIcon arrowStyle_left;

	private static ImageIcon hover_arrowStyle_left;

	private static ImageIcon arrowStyle_right;

	private static ImageIcon hover_arrowStyle_right;

	private static ImageIcon CheckBox_Unchecked;

	private static ImageIcon CheckBox_Checked;

	private static BufferedImage blocks;

	private static Font credits_Category_Font = null;
	private static Font credits_Names_Font = null;
	private static Font button_Font = null;
	private static Font title_Font = null;
	private static Font options_Category_Font = null;
	private static Font options_Names_Font = null;
	private static Font gameover_Font = null;
	private static Font score_Font = null;
	private static Font controls_Font = null;
	
	public static void setLogo(Image img) {
		logo = img;
	}

	public static Image getLogo() {
		return logo;
	}

	public static void setButtonStyle(Image img) {
		button = new ImageIcon(img);
	}

	public static ImageIcon getButtonStyle() {
		return button;
	}

	public static void setLeftArrowStyle(Image img) { arrowStyle_left = new ImageIcon(img);}

	public static ImageIcon getLeftArrowStyle() { return arrowStyle_left; }

	public static void setLeftHoverArrowStyle(Image img) { hover_arrowStyle_left = new ImageIcon(img); }

	public static ImageIcon getLeftHoverArrowStyle() { return hover_arrowStyle_left; }

	public static void setRightArrowStyle(Image img) { arrowStyle_right = new ImageIcon(img);}

	public static ImageIcon getRightArrowStyle() { return arrowStyle_right; }

	public static void setRightHoverArrowStyle(Image img) { hover_arrowStyle_right = new ImageIcon(img); }

	public static ImageIcon getRightHoverArrowStyle() { return hover_arrowStyle_right; }

	public static JButton getButtonTemplate() {
		JButton button = new JButton(getButtonStyle());
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setBounds(0, 0, 200, 50);
		button.setForeground(Color.black);
		button.setText("N/A");
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setFont(button_Font);
		return button;
	}

	public static void setHoverButtonStyle(Image img) {
		hover_Button = new ImageIcon(img);
	}

	public static ImageIcon getHoverButtonStyle() {
		return hover_Button;
	}

	public static void setUncheckedCheckBoxStyle(Image img) {
		CheckBox_Unchecked = new ImageIcon(img);
	}

	public static ImageIcon getUncheckedCheckBoxStyle() {
		return CheckBox_Unchecked;
	}

	public static void setCheckedCheckBoxStyle(Image img) {
		CheckBox_Checked = new ImageIcon(img);
	}

	public static ImageIcon getCheckedCheckBoxStyle() {
		return CheckBox_Checked;
	}

	public static JCheckBox getCheckboxTemplate() {
		JCheckBox box = new JCheckBox(getCheckedCheckBoxStyle());
		box.setSelected(true);
		box.setBorder(BorderFactory.createEmptyBorder());
		box.setContentAreaFilled(false);
		box.setFocusable(false);
		box.setSize(getCheckedCheckBoxStyle().getIconWidth(), getCheckedCheckBoxStyle().getIconHeight());
		return box;
	}

	public static JButton getLeftArrowButtonTemplate() {
		JButton button = new JButton(getLeftArrowStyle());
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setSize(32, 32);
		return button;
	}

	public static JButton getRightArrowButtonTemplate() {
		JButton button = new JButton(getRightArrowStyle());
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setSize(32, 32);
		return button;
	}

	public static void setWallpaper(String name, BufferedImage image) {
		wallpaperhash.put(name, image);
	}

	public static BufferedImage getWallpaper(String name) {
		if (wallpaperhash.containsKey(name)) {
			return wallpaperhash.get(name);
		}
		return null;

	}

	public static void setButtonFont(Font font) {
		button_Font = font;
	}

	public static void setTitleFont(Font font) {
		title_Font = font;
	}

	public static void setCreditsCategoryFont(Font font) {
		credits_Category_Font = font;
	}

	public static void setCreditsNameFont(Font font) {
		credits_Names_Font = font;
	}

	public static void setOptionsCategoryFont(Font font) {
		options_Category_Font = font;
	}

	public static void setOptionsNameFont(Font font) {
		options_Names_Font = font;
	}

	public static void setGameOverFont(Font font) {
		gameover_Font = font;
	}

	public static void setScoreFont(Font font) {
		score_Font = font;
	}

	public static void setControlsFont(Font font) {
		controls_Font = font;
	}

	public static Font getButtonFont() {
		return button_Font;
	}

	public static Font getTitleFont() {
		return title_Font;
	}

	public static Font getCreditsCategoryFont() {
		return credits_Category_Font;
	}

	public static Font getCreditsNameFont() {
		return credits_Names_Font;
	}

	public static Font getOptionsCategoryFont() {
		return options_Category_Font;
	}

	public static Font getOptionsNameFont() {
		return options_Names_Font;
	}

	public static Font getGameOverFont() {
		return gameover_Font;
	}

	public static Font getScoreFont() {
		return score_Font;
	}

	public static Font getControlsFont() {
		return controls_Font;
	}

	public static void setBlocks(BufferedImage img) { blocks = img; }

    public static BufferedImage getBlocks() { return blocks; }

    private static HashMap<BlockColor, Image> blocks_hash = new HashMap<>();

    public static void setBlock(BlockColor color, Image image) { blocks_hash.put(color, image); }

    public static Image getBlock(BlockColor color) {
    	if(blocks_hash.containsKey(color))
    		return blocks_hash.get(color);
    	else
    		switch (color) {
				case RED:
					return getBlocks().getSubimage(0, 0, 60, 60);
				case GREEN:
					return getBlocks().getSubimage(60, 0, 60, 60);
				case GRAY:
					return getBlocks().getSubimage(120, 0, 60, 60);
				case YELLOW:
					return getBlocks().getSubimage(180, 0, 60, 60);
				case PINK:
					return getBlocks().getSubimage(240, 0, 60, 60);
				case BLUE:
					return getBlocks().getSubimage(300, 0, 60, 60);
				case ORANGE:
					return getBlocks().getSubimage(360, 0, 60, 60);
				default:
					return getBlocks().getSubimage(420, 0, 60, 60);
			}
	}
}
