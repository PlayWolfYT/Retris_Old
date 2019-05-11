package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.enums.GameMode;
import de.diewolfbuddies.retris.frames.OptionsFrame;
import de.diewolfbuddies.retris.objects.GameBoardObject;

public class GameModeHandler {

    private GameMode gameMode;
    private GameBoardObject gameBoard;

    public GameModeHandler(GameMode gameMode) {
            this.gameMode = gameMode;
    }

    private GameBoardObject updateGameBoard() {
        switch (gameMode) {
            case NORMAL:
                System.out.println("NORMAL STARTED");
                gameBoard = new de.diewolfbuddies.retris.gamemodes.normal.GameBoard();
                return gameBoard;
            case T_ONLY:
                System.out.println("MIRRORED STARTED");
                gameBoard = new de.diewolfbuddies.retris.gamemodes.t_only.GameBoard();
                return gameBoard;
            case UPSIDEDOWN:
                System.out.println("UPSIDEDOWN STARTED");
                gameBoard = new de.diewolfbuddies.retris.gamemodes.upsidedown.GameBoard();
                return gameBoard;
            case LEFTRIGHT:
                System.out.println("LEFTRIGHT STARTED");
                gameBoard = new de.diewolfbuddies.retris.gamemodes.leftright.GameBoard();
                return gameBoard;
            default:
                System.exit(0);
                return null;
        }
    }

    public GameBoardObject startGameBoard(int width, int height) {
        if(gameBoard == null) {
            updateGameBoard();
        }

        if(!gameBoard.isStarted) {
            updateGameBoard();
            if(!gameBoard.isStarted) {
                gameBoard.start();
                gameBoard.setBounds(50, 50, width, height);
            } else {
                System.out.println("DOUBLE START");
            }
        } else {
            System.out.println("DOUBLE START");
        }
        return gameBoard;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public GameBoardObject getGameBoard() {
        updateGameBoard();
        return gameBoard;
    }

    public boolean hasPrevious() {
        try {
            return GameMode.values()[gameMode.ordinal() - 1] != null;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean hasNext() {
        try {
            return GameMode.values()[gameMode.ordinal() + 1] != null;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public GameMode getPrevious() {
        if(hasPrevious())
            return GameMode.values()[gameMode.ordinal() - 1];
        return null;
    }

    public GameMode getNext() {
        if(hasNext())
            return GameMode.values()[gameMode.ordinal() + 1];
        return null;
    }

    public void loadPrevious() {
        if(hasPrevious()) {
            setGameMode(getPrevious());
            OptionsFrame.updateGameMode(gameMode.getName());
            OptionsFrame.updateArrows();
        }
    }

    public void loadNext() {
        if(hasNext()) {
            setGameMode(getNext());
            OptionsFrame.updateGameMode(gameMode.getName());
            OptionsFrame.updateArrows();
        }
    }

}
