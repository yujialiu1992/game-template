package com.thoughtworks.gametemplate.game;

import java.util.List;

public class World {
    private List<Entity> entities;
    private Box bounds;

    public World(List<Entity> entities, Box bounds) {
        this.entities = entities;
        this.bounds = bounds;
    }

    public Entity update() {
        Entity res = null;
        for (Entity entity : entities) {
            if (entity.getEntityType().equals(EntityType.Enemy)) {
                res = getEnemyToDestroy(entity);
            }
            Box entityBounds = entity.desiredLocation();
            if (bounds.contains(entityBounds)){
                entity.move();
            }
        }
        return res;
    }

    public Entity getEnemyToDestroy(Entity enemy) {
        Entity res = null;
        Box enemyBox = enemy.desiredLocation();
        for (Entity entity : entities) {
            if (entity.getEntityType().equals(EntityType.Shot)) {
                Box shotBox = entity.desiredLocation();
                if (enemyBox.contains(shotBox)) {
                    res = enemy;
                    break;
                }
            }
        }
        return res;
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }

    public void remove(Entity entity) {
        entities.remove(entity);
    }
}
