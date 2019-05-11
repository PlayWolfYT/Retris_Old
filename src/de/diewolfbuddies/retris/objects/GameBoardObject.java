package de.diewolfbuddies.retris.objects;

import de.diewolfbuddies.retris.frames.GameFrame;
import de.diewolfbuddies.retris.handlers.FrameHandler;
import de.diewolfbuddies.retris.handlers.TexturesHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class GameBoardObject<Shape> extends JPanel implements ActionListener {

    public static final int BOARD_WIDTH = 15,
                             BOARD_HEIGHT = 15;

    public static final Color[] COLORS = {
            new Color(0,0,0),
            new Color(204,102,102),
            new Color(102,204,102),
            new Color(102,102,204),
            new Color(204,204,102),
            new Color(204,102,204),
            new Color(102,204,204),
            new Color(218,170,0)
    };

    public Timer timer;

    public Boolean speeding = false;

    public boolean isFallingFinished = false,
                   isStarted = false,
                   isPaused = false;

    public int linesRemoved = 0;

    public JLabel scoreBar;

    public int timerSpeed = 800;

    public GameBoardObject() {
        //Scorebar setup

        scoreBar = new JLabel("Score: 0");
        scoreBar.setFont(TexturesHandler.getButtonFont().deriveFont(30f));
        scoreBar.setHorizontalAlignment(SwingConstants.CENTER);
        scoreBar.setBounds(50 + 300 - 150, 0, 300, 50);
        scoreBar.setForeground(Color.cyan);

        setFocusable(true);
        timer = new Timer(timerSpeed, this);
    }

    public abstract void pieceDropped();
    public abstract void newPiece();
    public abstract void oneLineDown();
    public abstract void removeFullLines();
    public abstract void dropDown();
    public JLabel getScoreBar() { return scoreBar; }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    public void tryMove(Shape newPiece, int x, int y) {}





    public int boardTop = (int) getSize().getHeight() - BOARD_HEIGHT * squareHeight();

    public void start() {
        if(!FrameHandler.getCurrentFrame().getTitle().contains("Ingame")) {
            System.out.println("No Ingame in title \"" + FrameHandler.getCurrentFrame().getTitle() + "\"");
            return;
        }
        if (isPaused)
            return;

        clearBoard();

        isStarted = true;
        isFallingFinished = false;
        linesRemoved = 0;
        newPiece();
        timer.start();
    }

    public void pause(boolean isPaused) {
        if (!isStarted)
            return;

        this.isPaused = isPaused;

        if (isPaused) {
            timer.stop();
            scoreBar.setText("Paused");
        } else {
            timer.start();
            scoreBar.setText("Score: " + linesRemoved);
        }

        repaint();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(TexturesHandler.getWallpaper("Gamefield").getScaledInstance(GameFrame.gb_WIDTH, GameFrame.gb_HEIGHT, 10), 0, 0, null);
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    public void setSpeeding(boolean speeding) {
        if(speeding != this.speeding) {
            this.speeding = speeding;
            if(speeding) {
                timerSpeed /= 3.5;
            } else {
                timerSpeed *= 3.5;
                this.timer.setInitialDelay(0);
            }

            this.timer.setDelay(timerSpeed);
            this.timer.restart();
        }
    }

    public abstract void silentGameOver();

    public abstract void clearBoard();



}
