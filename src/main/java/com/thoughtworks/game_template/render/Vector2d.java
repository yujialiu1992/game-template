package com.thoughtworks.game_template.render;

public class Vector2d {
    private int x;
    private int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void add(Vector2d that) {
        this.x += that.x;
        this.y += that.y;
    }
}
