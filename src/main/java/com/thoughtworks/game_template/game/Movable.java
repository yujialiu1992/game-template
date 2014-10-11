package com.thoughtworks.game_template.game;

import com.thoughtworks.game_template.render.Vector2d;

public interface Movable {
    void move(Vector2d delta);
}
