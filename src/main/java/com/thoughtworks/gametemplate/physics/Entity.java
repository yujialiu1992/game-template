package com.thoughtworks.gametemplate.physics;

import com.thoughtworks.gametemplate.render.Vector2d;

public class Entity {
    private Vector2d position;

    public Entity(Vector2d position) {
        this.position = position;
    }

    public void move(Vector2d delta) {
        position.add(delta);
    }
}
