package com.thoughtworks.gametemplate.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class QuitKeyListener implements KeyListener {
    private boolean hasQuit = false;

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyChar() == 'q') {
            hasQuit = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean hasQuit() {
        return hasQuit;
    }
}
