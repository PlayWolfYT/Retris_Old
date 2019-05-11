package de.diewolfbuddies.retris.gamemodes.t_only;

import de.diewolfbuddies.retris.Retris;
import de.diewolfbuddies.retris.frames.GameFrame;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;
import de.diewolfbuddies.retris.objects.GameBoardObject;

import java.awt.*;

public class GameBoard extends GameBoardObject {

    public Shape currentPiece;

    public Retrominos[] board;

    public int currentX = 0;
    public int currentY = 0;

    public GameBoard() {
        board = new Retrominos[BOARD_WIDTH * BOARD_HEIGHT];

        clearBoard();

        timerSpeed = 800;
        currentPiece = new Shape();
        addKeyListener(new GameLogic(this));
    }

    @Override
    public void pieceDropped() {
        for (int i = 0; i < 4; i++) {
            int x = currentX + currentPiece.getX(i);
            int y = currentY - currentPiece.getY(i);
            board[y * BOARD_WIDTH + x] = currentPiece.getShape();
        }

        removeFullLines();

        if (!isFallingFinished) {
            newPiece();
            Retris.getAudioHandler().playSound("Block_Land.wav", 0.2f);
        }
    }

    @Override
    public void newPiece() {
        currentPiece.setRandomShape();
        currentX = BOARD_WIDTH / 2 + 1;
        currentY = BOARD_HEIGHT - 1 + currentPiece.getMinY();


        if (!tryMove(currentPiece, currentX, currentY - 1)) {
            currentPiece.setShape(Retrominos.NoShape);
            timer.stop();
            isStarted = false;
            scoreBar.setForeground(Color.red.darker());
            scoreBar.setText("Game Over");
            Retris.getGameLogic().gameOver();
        }
    }

    @Override
    public void oneLineDown() {
        if (!tryMove(currentPiece, currentX, currentY - 1))
            pieceDropped();
    }

    public boolean tryMove(Shape newPiece, int newX, int newY) {

        System.out.println("\n\nCHECKING FRAME TITLE");
        if(!FrameHandler.getCurrentFrame().getTitle().contains("Ingame")) {
            System.out.println("No Ingame in title \"" + FrameHandler.getCurrentFrame().getTitle() + "\"");
            silentGameOver();
            return false;
        }
        System.out.println("\n\nFRAME TITLE CHECK PASSED: \n\"" + FrameHandler.getCurrentFrame().getTitle() + "\" contains \"Ingame\"\nGameMode: T_ONLY");

        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.getX(i);
            int y = newY - newPiece.getY(i);

            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT)
                return false;

            if (getShapeAt(x, y) != Retrominos.NoShape)
                return false;
        }

        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        repaint();

        return true;
    }

    @Override
    public void removeFullLines() {
        int numFullLines = 0;

        for (int i = BOARD_HEIGHT - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BOARD_WIDTH; ++j) {
                if (getShapeAt(j, i) == Retrominos.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;

                for (int k = i; k < BOARD_HEIGHT - 1; ++k) {
                    for (int j = 0; j < BOARD_WIDTH; ++j) {
                        board[k * BOARD_WIDTH + j] = getShapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {
            if(!Retris.isSecretActive())
                linesRemoved += numFullLines;
            else
                linesRemoved += (numFullLines * 5);
            scoreBar.setText("Score: " + linesRemoved);
            isFallingFinished = true;
            currentPiece.setShape(Retrominos.NoShape);
            repaint();
            Retris.getAudioHandler().playSound("Line_Break.wav", 0.2f);
        }

        switch(linesRemoved) {
            case 10: case 25: case 50: case 75: case 100:
                timerSpeed /= 1.1;
                this.timer.setDelay(timerSpeed);
                break;
        }

    }

    @Override
    public void dropDown() {
        int newY = currentY;

        while (newY > 0) {
            if (!tryMove(currentPiece, currentX, newY - 1))
                break;

            --newY;
        }

        pieceDropped();
    }

    public Retrominos getShapeAt(int x, int y) {
        return board[y * BOARD_WIDTH + x];
    }

    @Override
    public void clearBoard() {
        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {
            board[i] = Retrominos.NoShape;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                Retrominos shape = getShapeAt(j, BOARD_HEIGHT - i - 1);

                if (shape != Retrominos.NoShape) {
                    drawSquare(g, j * squareWidth(), boardTop + i * squareHeight(), shape);
                }
            }
        }

        if (currentPiece.getShape() != Retrominos.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = currentX + currentPiece.getX(i);
                int y = currentY - currentPiece.getY(i);
                drawSquare(g, x * squareWidth(), boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(), currentPiece.getShape());
            }
        }
    }

    @Override
    public void silentGameOver() {
        currentPiece.setShape(Retrominos.NoShape);
        timer.stop();
        isStarted = false;
        scoreBar.setForeground(Color.red.darker());
        scoreBar.setText("Game Over");
    }

    public void drawSquare(Graphics g, int x, int y, Retrominos shape) {
        String color = shape.colorName;
        Image img = TexturesHandler.getBlock(shape.color);
        g.drawImage(img.getScaledInstance(squareWidth(), squareHeight(), 4), x, y, null);
    }

    @Override
    public void start() {
        super.start();
        clearBoard();
    }
}
