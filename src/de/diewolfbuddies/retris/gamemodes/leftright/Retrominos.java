package de.diewolfbuddies.retris.gamemodes.leftright;

import de.diewolfbuddies.retris.utils.BlockColor;

public enum Retrominos {

    NoShape(       new int[][] {   {  0,  0},   {  0,  0},   {  0,  0},  {  0,  0}  }, BlockColor.NONE, ""),
    ZShape(        new int[][] {   {  0, -1},   {  0,  0},   { -1,  0},  { -1,  1}  }, BlockColor.RED, "red"),
    SShape(        new int[][] {   {  0, -1},   {  0,  0},   {  1,  0},  {  1,  1}  }, BlockColor.GREEN, "green"),
    LineShape(     new int[][] {   {  0, -1},   {  0,  0},   {  0,  1},  {  0,  2}  }, BlockColor.GRAY, "gray"),
    TShape(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.YELLOW, "yellow"),
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
