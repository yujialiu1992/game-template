package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public class Entity {
    private Vector2f position;
    private Vector2f velocity;
    private Sprite sprite;

    public Entity(Vector2f position, Sprite sprite) {
        this.position = position;
        this.sprite = sprite;
        this.velocity = Zero;
    }


    public void move(){
        position.add(velocity);
        sprite.move(position);
    }

    public void velocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Box desiredLocation() {
        Vector2f desiredPosition = position.plus(velocity);
        return new Box(desiredPosition, desiredPosition.plus(sprite.width(), sprite.height()));
    }
}
