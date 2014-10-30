package com.thoughtworks.gametemplate.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.thoughtworks.gametemplate.game.Vector2d.Zero;

public class PlayerMoveKeyListener implements KeyListener {
    private Entity player;
    private Vector2d left = new Vector2d(-1.0f, 0.0f);
    private Vector2d right = new Vector2d(1.0f, 0.0f);

    public PlayerMoveKeyListener(Entity player) {

        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'a') {
            player.velocity(left);
        }

        if (event.getKeyChar() == 'd') {
            player.velocity(right);
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (event.getKeyChar() == 'a') {
            player.velocity(Zero);
        }

        if (event.getKeyChar() == 'd') {
            player.velocity(Zero);
        }

    }
}
