package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

import static com.thoughtworks.gametemplate.game.Vector2d.Zero;

public class Entity {
    private Vector2d position;
    private Vector2d velocity;
    private Sprite sprite;

    public Entity(Vector2d position, Sprite sprite) {
        this.position = position;
        this.sprite = sprite;
        this.velocity = Zero;
    }


    public void update(){
        position.add(velocity);
        sprite.move(position);
    }

    public void velocity(Vector2d velocity) {
        this.velocity = velocity;
    }
}
