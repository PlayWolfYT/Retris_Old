package de.diewolfbuddies.retris.gamemodes.upsidedown;

import de.diewolfbuddies.retris.utils.BlockColor;
import de.diewolfbuddies.retris.utils.Horizontal;
import de.diewolfbuddies.retris.utils.Vertical;

public enum Retrominos {

    NoShape(       new int[][] {   {  0,  0},   {  0,  0},   {  0,  0},  {  0,  0}  }, BlockColor.NONE, ""),

    ZShape(        new int[][]{    {Vertical.NONE, Horizontal.DOWN * 1},   {Vertical.NONE, Horizontal.NONE}, {Vertical.RIGHT * 1, Horizontal.NONE}, {Vertical.RIGHT * 1, Horizontal.UP * 1}}, BlockColor.RED, "RED"),
    SShape(        new int[][] {   {  0, -1},   {  0,  0},   {  1,  0},  {  1,  1}  }, BlockColor.GREEN, "green"),
    LineShape(     new int[][] {   {  0, -1},   {  0,  0},   {  0,  1},  {  0,  2}  }, BlockColor.GRAY, "gray"),
    TShape(        new int[][] {   {Vertical.LEFT * 1, Horizontal.NONE}, {Vertical.NONE, Horizontal.NONE}, {Vertical.RIGHT * 1, Horizontal.NONE}, {Vertical.NONE, Horizontal.UP * 1}}, BlockColor.YELLOW, "YELLOW"),
    SquareShape(   new int[][] {   {  0,  0},   {  1,  0},   {  0,  1},  {  1,  1}  }, BlockColor.PINK, "pink"),

    LShape(        new int[][] {   { -1, -1},   {  0, -1},   {  0,  0},  {  0,  1}  }, BlockColor.BLUE, "blue"),
    MirroredLShape(new int[][] {   {  1, -1},   {  0, -1},   {  0,  0},  {  0,  1}  }, BlockColor.ORANGE, "orange");

    public int[][] coords;
    public BlockColor color;
    public String colorName;

    Retrominos(int[][] coords, BlockColor color, String colorName) {
        this.coords = coords;
        this.color = color;
        this.colorName = colorName;
    }

}
