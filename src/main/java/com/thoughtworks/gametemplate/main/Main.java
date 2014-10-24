package com.thoughtworks.gametemplate.main;

import com.thoughtworks.gametemplate.physics.Entity;
import com.thoughtworks.gametemplate.game.Game;
import com.thoughtworks.gametemplate.physics.Physics;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;
import com.thoughtworks.gametemplate.render.Sprite;
import com.thoughtworks.gametemplate.render.Vector2d;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.render.EntityType.*;
import static com.thoughtworks.gametemplate.render.EntityType.Player;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Entity> entities = newArrayList();
        Physics physics = new Physics(entities);
        Sprite background = fromFile("starfield.png", new Vector2d(0, 0));
        Renderer renderer = new Renderer(newArrayList(background));
        Window window = new Window(renderer);
        Game game = new Game(physics, window, renderer);
        game.spawnEntity(Player, new Vector2d(350, 475));
        game.spawnEntity(Enemy, new Vector2d(350, 50));
        game.spawnEntity(Shot, new Vector2d(350, 425));

        game.run();

    }
}
