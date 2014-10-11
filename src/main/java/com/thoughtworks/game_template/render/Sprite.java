package com.thoughtworks.game_template.render;

import com.thoughtworks.game_template.game.Movable;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite implements Movable {
    private Image image;
    private Vector2d position;

    public Sprite(Image image, Vector2d position) {
        this.image = image;
        this.position = position;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, position.getX(), position.getY(), null);
    }

    @Override
    public void move(Vector2d delta) {
        position.add(delta);
    }
}
