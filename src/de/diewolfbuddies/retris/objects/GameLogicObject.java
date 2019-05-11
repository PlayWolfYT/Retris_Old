package de.diewolfbuddies.retris.objects;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.enums.FrameType;
import de.diewolfbuddies.retris.handlers.FrameHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class GameLogicObject<Shape> extends KeyAdapter {

    public static Boolean paused = false;
    public static GameBoardObject gameBoard;

    public GameLogicObject(GameBoardObject gameBoard) {
        GameLogicObject.gameBoard = gameBoard;
        Retris.setGameLogic(this);
    }

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 27) {
            if(paused) {
                togglePause();
            } else {
                togglePause();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            gameBoard.setSpeeding(false);
        }
    }

    public void togglePause() {
        paused = !paused;
        gameBoard.pause(paused);

        if(paused) {
            Retris.getAudioHandler().pauseAll();
        } else {
            Retris.getAudioHandler().resumeAll();
        }
    }

    public static void gameOver() {
        gameBoard.silentGameOver();
        Retris.getAudioHandler().stopMusic();
        Retris.getAudioHandler().playSound("GameOver.wav", 0.05f);
        Retris.final_score = gameBoard.linesRemoved;
        FrameHandler.goToFrame(FrameType.END);
    }

}
