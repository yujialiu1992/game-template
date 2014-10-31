package com.thoughtworks.gametemplate.main;

import com.thoughtworks.gametemplate.game.*;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;
import com.thoughtworks.gametemplate.render.Sprite;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.*;
import static com.thoughtworks.gametemplate.game.EntityType.Player;
import static com.thoughtworks.gametemplate.game.Vector2f.Zero;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Entity> entities = newArrayList();
        Vector2f gameSize = new Vector2f(800.0f, 600.0f);
        Box bounds = new Box(Zero, gameSize);
        World world = new World(entities, bounds);
        Sprite background = fromFile("starfield.png", new Vector2f(0.0f, 0.0f));
        Renderer renderer = new Renderer(newArrayList(background));
        Window window = new Window(renderer, gameSize);

        QuitKeyListener user = new QuitKeyListener();

        Game game = new Game(world, window, renderer, user);
        Entity player = game.spawnEntity(Player, new Vector2f(350.0f, 470.0f));
        //Entity shot = game.spawnEntity(Shot, new Vector2f(350.0f, 465.0f));
        game.spawnEntity(Enemy, new Vector2f(350.0f, 50.0f));
        //game.spawnEntity(Shot, new Vector2f(350.0f, 425.0f));
        window.addKeyListener(user);
        window.addKeyListener(new PlayerMoveKeyListener(player));

        //window.addKeyListener(new PlayerShotKeyListener(player, game));

        game.run();

    }
}
