package de.diewolfbuddies.retris.enums;

public enum GameMode {

    NORMAL,T_ONLY,UPSIDEDOWN,LEFTRIGHT;

    public String getName() {
      return this.name().replaceAll("_", " ");
    }

}
