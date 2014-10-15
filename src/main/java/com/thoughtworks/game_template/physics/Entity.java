package com.thoughtworks.game_template.physics;

import com.thoughtworks.game_template.render.Vector2d;

public class Entity {
    private Vector2d position;

    public Entity(Vector2d position) {
        this.position = position;
    }

    public void move(Vector2d delta) {
        position.add(delta);
    }
}
