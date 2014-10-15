package com.thoughtworks.game_template.physics;

import com.thoughtworks.game_template.render.Vector2d;

import java.util.List;
import java.util.Random;

public class Physics {
    Random random = new Random();
    private List<Entity> entities;

    public Physics(List<Entity> entities) {
        this.entities = entities;
    }

    public void update() {
        for (Entity entity : entities) {
            Vector2d delta = new Vector2d(random.nextInt(3) - 1, 0);
            entity.move(delta);
        }
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }
}
