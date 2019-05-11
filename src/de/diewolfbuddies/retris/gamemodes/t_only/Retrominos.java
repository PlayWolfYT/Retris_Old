package de.diewolfbuddies.retris.gamemodes.t_only;

import de.diewolfbuddies.retris.utils.BlockColor;

public enum Retrominos {

    NoShape(       new int[][] {   {  0,  0},   {  0,  0},   {  0,  0},  {  0,  0}  }, BlockColor.NONE, ""),
    TShape_1(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.YELLOW, "yellow"),
    TShape_2(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.BLUE, "blue"),
    TShape_3(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.GRAY, "gray"),
    TShape_4(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.GREEN, "green"),
    TShape_5(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.ORANGE, "orange"),
    TShape_6(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.PINK, "pink"),
    TShape_7(        new int[][] {   { -1,  0},   {  0,  0},   {  1,  0},  {  0,  1}  }, BlockColor.RED, "red");


    public int[][] coords;
    public BlockColor color;
    public String colorName;

    Retrominos(int[][] coords, BlockColor color, String colorName) {
        this.coords = coords;
        this.color = color;
        this.colorName = colorName;
    }

}
