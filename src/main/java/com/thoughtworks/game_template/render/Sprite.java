package com.thoughtworks.game_template.render;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite {
    private Image image;
    private Vector2d position;

    public Sprite(Image image, Vector2d position) {
        this.image = image;
        this.position = position;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, position.getX(), position.getY(), null);
    }
}
