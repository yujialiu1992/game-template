package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;
import static com.thoughtworks.gametemplate.game.EntityType.*;

public class Entity {
    private Vector2f position;
    private Vector2f velocity;
    private Sprite sprite;
    private Entity shot;
    private Game game;
    private EntityType entityType;

    public Entity(Vector2f position, Sprite sprite, Game game, EntityType entityType) {
        this.position = position;
        this.sprite = sprite;
        this.game = game;
        this.entityType = entityType;
        this.velocity = Zero;

    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Vector2f getPosition() {
        return position;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void move(){
        position = position.plus(velocity);
        sprite.move(position);
    }

    public void velocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Box desiredLocation() {
        Vector2f desiredPosition = position.plus(velocity);
        return new Box(desiredPosition, desiredPosition.plus(sprite.width(), sprite.height()));
    }

    public void fire() {
        this.shot = game.spawnEntity(Shot, new Vector2f(position.getX() + sprite.width() / 2, position.getY()));
        shot.velocity(new Vector2f(0.0f, -5.0f));
    }

}
