package com.thoughtworks.gametemplate.game;

public class Vector2d {
    public static Vector2d Zero = new Vector2d(0.0f, 0.0f);
    private Float x;
    private Float y;

    public Vector2d(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x.intValue();
    }

    public int getY() {
        return y.intValue();
    }

    public void add(Vector2d that) {
        this.x += that.x;
        this.y += that.y;
    }

    public void scale(Float scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }
}
