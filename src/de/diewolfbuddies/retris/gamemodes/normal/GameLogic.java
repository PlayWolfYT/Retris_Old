package de.diewolfbuddies.retris.gamemodes.normal;

import de.diewolfbuddies.retris.objects.GameLogicObject;

import java.awt.event.KeyEvent;

public class GameLogic extends GameLogicObject {

    private GameBoard gameBoard;

    public GameLogic(GameBoard gameBoard) {
        super(gameBoard);
        this.gameBoard = gameBoard;
    }



    

    @Override
    public void keyPressed(KeyEvent e) {
        Shape currentPiece = gameBoard.currentPiece;
        int currentX = gameBoard.currentX;
        int currentY = gameBoard.currentY;

        if(!gameBoard.isStarted || currentPiece.getShape() == Retrominos.NoShape)
            return;

        if(paused)
            return;


        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
                gameBoard.tryMove(currentPiece, currentX - 1, currentY);
                break;
            case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
                gameBoard.tryMove(currentPiece, currentX + 1, currentY);
                break;
            case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
                gameBoard.tryMove(currentPiece.rotateRight(), currentX, currentY);
                break;
            case KeyEvent.VK_UP: case KeyEvent.VK_W:
                gameBoard.tryMove(currentPiece.rotateLeft(), currentX, currentY);
                break;
            case KeyEvent.VK_SPACE:
                gameBoard.dropDown();
                break;
            case KeyEvent.VK_SHIFT:
                gameBoard.setSpeeding(true);
                break;
        }
    }
}
