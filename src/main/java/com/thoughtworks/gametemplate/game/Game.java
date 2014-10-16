package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.physics.Entity;
import com.thoughtworks.gametemplate.physics.Physics;
import com.thoughtworks.gametemplate.render.*;
import com.thoughtworks.gametemplate.render.Renderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final Timer timer;
    private Physics physics;
    private Window window;
    private Renderer renderer;

    public Game(Physics physics, Window window, Renderer renderer) {
        this.physics = physics;
        this.window = window;
        this.renderer = renderer;
        timer = new Timer(5, this);
        timer.start();
    }

    public void run() throws InterruptedException {
        window.activate();

        // Game loop goes here
        Thread.sleep(5000);

        timer.stop();
        window.deactivate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        physics.update();
        window.repaint();
    }

    public void spawnEntity(EntityType type, Vector2d position) {
        physics.spawn(new Entity(position));
        renderer.addSprite(new Sprite(type.image(), position));
    }
}
