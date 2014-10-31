package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.*;
import com.thoughtworks.gametemplate.render.Renderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Game implements ActionListener {
    private final Timer timer;
    private World world;
    private Window window;
    private Renderer renderer;
    private QuitKeyListener user;

    public Game(World world, Window window, Renderer renderer, QuitKeyListener user) {
        this.world = world;
        this.window = window;
        this.user = user;
        this.renderer = renderer;
        timer = new Timer(5, this);
        timer.start();
    }

    public void run() throws InterruptedException {
        window.activate();

        while(!user.hasQuit()){
            Thread.sleep(1);    // save memory, check one time per second
        }

        timer.stop();
        window.deactivate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Entity entityToDestroy = world.update();
        if (entityToDestroy != null) {
            destroyEntity(entityToDestroy);
        }
        window.repaint();
    }

    public Entity spawnEntity(EntityType type, Vector2f position) {
        Sprite sprite = fromFile(type.image(), position);
        renderer.addSprite(sprite);
        Entity entity = new Entity(position, sprite, this, type);
        world.spawn(entity);
        return entity;
    }

    public void destroyEntity(Entity entity) {
        renderer.removeSprite(entity.getSprite());
        world.remove(entity);
    }
}
