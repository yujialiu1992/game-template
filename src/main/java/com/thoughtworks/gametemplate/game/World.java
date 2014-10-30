package com.thoughtworks.gametemplate.game;

import java.util.List;

public class World {
    private List<Entity> entities;

    public World(List<Entity> entities) {
        this.entities = entities;
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }
}
