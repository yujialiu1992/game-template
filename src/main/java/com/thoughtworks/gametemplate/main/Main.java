package com.thoughtworks.gametemplate.main;

import com.thoughtworks.gametemplate.game.PlayerMoveKeyListener;
import com.thoughtworks.gametemplate.game.QuitKeyListener;
import com.thoughtworks.gametemplate.game.Entity;
import com.thoughtworks.gametemplate.game.Game;
import com.thoughtworks.gametemplate.game.World;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;
import com.thoughtworks.gametemplate.render.Sprite;
import com.thoughtworks.gametemplate.game.Vector2d;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.*;
import static com.thoughtworks.gametemplate.game.EntityType.Player;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Entity> entities = newArrayList();
        World world = new World(entities);
        Sprite background = fromFile("starfield.png", new Vector2d(0.0f, 0.0f));
        Renderer renderer = new Renderer(newArrayList(background));
        Window window = new Window(renderer);

        QuitKeyListener user = new QuitKeyListener();

        Game game = new Game(world, window, renderer, user);
        Entity player = game.spawnEntity(Player, new Vector2d(350.0f, 475.0f));
        game.spawnEntity(Enemy, new Vector2d(350.0f, 50.0f));
        game.spawnEntity(Shot, new Vector2d(350.0f, 425.0f));

        window.addKeyListener(user);
        window.addKeyListener(new PlayerMoveKeyListener(player));

        game.run();

    }
}
