package de.diewolfbuddies.retris.utils;

import java.awt.*;

public enum BlockColor {

    RED(Color.RED, "RED"),
    GREEN(Color.GREEN, "GREEN"),
    GRAY(Color.GRAY, "GRAY"),
    YELLOW(Color.YELLOW, "YELLOW"),
    PINK(Color.PINK, "PINK"),
    BLUE(Color.BLUE, "BLUE"),
    ORANGE(Color.ORANGE, "ORANGE"),
    NONE(Color.BLACK, "NONE");

    private Color color;
    private String name;

    BlockColor(Color color, String name) {
        this.color = color;
        this.name = name;
    }

}
