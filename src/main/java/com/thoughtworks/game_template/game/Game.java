package com.thoughtworks.game_template.game;

import com.thoughtworks.game_template.physics.Entity;
import com.thoughtworks.game_template.physics.Physics;
import com.thoughtworks.game_template.render.Renderer;
import com.thoughtworks.game_template.render.Sprite;
import com.thoughtworks.game_template.render.Vector2d;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final Timer timer;
    private Physics physics;
    private Renderer renderer;

    public Game(Physics physics, Renderer renderer) {
        this.physics = physics;
        this.renderer = renderer;
        timer = new Timer(5, this);
        timer.start();
    }

    public void run() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void stop(){
        timer.stop();
        renderer.deactivate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        physics.update();
        renderer.repaint();
    }

    public void spawnEntity(EntityType type, Vector2d position) {
        physics.spawn(new Entity(position));
        renderer.addSprite(new Sprite(type.image(), position));
    }
}
