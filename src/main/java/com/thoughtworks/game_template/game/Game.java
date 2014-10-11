package com.thoughtworks.game_template.game;

import com.thoughtworks.game_template.render.Renderer;
import com.thoughtworks.game_template.render.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class Game implements ActionListener {
    private final Timer timer;
    private List<Movable> entities;
    private Renderer renderer;
    Random random = new Random();

    public Game(List<Movable> entities, Renderer renderer) {
        this.entities = entities;
        this.renderer = renderer;
        timer = new Timer(5, this);
        timer.start();
    }

    public void run() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Movable entity : entities) {
            int x = random.nextInt(3) - 1;
            int y = 0;
            entity.move(x, y);
        }
        renderer.repaint();
    }

    public void spawnEntity(int x, int y) {
        Image playerShipImage = loadImage("playerShip.png").getScaledInstance(40, 40, 0);
        Sprite entity = new Sprite(playerShipImage, x, y);
        entities.add(entity);
        renderer.addSprite(entity);

    }
    private static Image loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + fileName);
        return imageIcon.getImage();
    }

}
