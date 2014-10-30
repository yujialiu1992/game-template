package com.thoughtworks.gametemplate.game;

import java.util.List;

public class World {
    private List<Entity> entities;
    private Box bounds;

    public World(List<Entity> entities, Box bounds) {
        this.entities = entities;
        this.bounds = bounds;
    }

    public void update() {
        for (Entity entity : entities) {
            Box entityBounds = entity.desiredLocation();
            if (bounds.contains(entityBounds)){
                entity.move();
            }
        }
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }
}
