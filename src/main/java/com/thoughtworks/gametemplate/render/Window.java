package com.thoughtworks.gametemplate.render;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;

public class Window extends JFrame {
    public static final int exitOnClose = WindowConstants.EXIT_ON_CLOSE;
    private Renderer renderer;

    public Window(Renderer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void paint(Graphics graphics) {
        renderer.draw(graphics);
    }

    @Override
    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void activate() {
        setSize(800,600);
        setLocation(0, 0);
        setVisible(true);
        setDefaultCloseOperation(exitOnClose);
    }


    public void deactivate() {
        dispose();
    }
}
