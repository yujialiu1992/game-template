package com.thoughtworks.game_template.render;

import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class Renderer extends JFrame {
    private List<Sprite> sprites;


    public Renderer(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    @Override
    public void paint(Graphics graphics) {
        for (Sprite sprite : sprites) {
            sprite.draw(graphics);
        }
    }

    @Override
    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void activate() {
        setSize(1600,900);
        setLocation(0, 0);
        setVisible(true);
    }


    public void deactivate() {
        dispose();
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }
}
