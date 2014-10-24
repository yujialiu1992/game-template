package com.thoughtworks.gametemplate.render;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite {
    private Image image;
    private Vector2d position;

    public static Sprite fromFile(String fileName, Vector2d position){
        ImageLoader loader = new ImageLoader();
        return new Sprite(loader.loadImage(fileName), position);
    }

    Sprite(Image image, Vector2d position) {
        this.image = image;
        this.position = position;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, position.getX(), position.getY(), null);
    }
}
