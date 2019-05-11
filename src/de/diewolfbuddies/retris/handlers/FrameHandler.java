package de.diewolfbuddies.retris.handlers;

import de.diewolfbuddies.retris.enums.FrameType;
import de.diewolfbuddies.retris.frames.*;

import javax.swing.*;

public class FrameHandler {

    private static JFrame currentFrame;

    public static JFrame getCurrentFrame() {
        return currentFrame;
    }

    public static void setCurrentFrame(JFrame frame) {
        currentFrame = frame;
    }

    public static void goToFrame(FrameType frametype) {
        if (currentFrame != null)
            currentFrame.dispose();
        switch (frametype) {
            case START:
                new StartFrame();
                break;
            case GAME:
                new GameFrame();
                break;
            case END:
                new EndFrame();
                break;
            case OPTIONS:
                new OptionsFrame();
                break;
            case CREDITS:
                new CreditsFrame();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Das Spiel ist leider abgestürzt! Tut uns leid.", "Retris - Spielabsturz", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
                break;
        }
    }

}
