package com.thoughtworks.game_template.render;

import com.thoughtworks.game_template.game.Movable;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite implements Movable {
    private Image image;
    private int x;
    private int y;

    public Sprite(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
