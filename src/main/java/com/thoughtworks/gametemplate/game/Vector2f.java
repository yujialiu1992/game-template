package com.thoughtworks.gametemplate.game;

public class Vector2f {
    public static Vector2f Zero = new Vector2f(0.0f, 0.0f);
    private Float x;
    private Float y;

    public Vector2f(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x.intValue();
    }

    public int getY() {
        return y.intValue();
    }

    public void add(Vector2f that) {
        this.x += that.x;
        this.y += that.y;
    }

    public void scale(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public Vector2f plus(float x, float y) {
        return new Vector2f(this.x + x, this.y + y);
    }

    public Vector2f plus(Vector2f that) {
        return new Vector2f(this.x + that.x, this.y + that.y);
    }
}
