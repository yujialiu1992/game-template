package com.thoughtworks.gametemplate.main;

import com.thoughtworks.gametemplate.physics.Entity;
import com.thoughtworks.gametemplate.game.Game;
import com.thoughtworks.gametemplate.physics.Physics;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;
import com.thoughtworks.gametemplate.render.Sprite;
import com.thoughtworks.gametemplate.render.Vector2d;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.*;
import static com.thoughtworks.gametemplate.game.EntityType.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Entity> entities = newArrayList();
        Physics physics = new Physics(entities);
        Renderer renderer = new Renderer(background());
        Window window = new Window(renderer);
        Game game = new Game(physics, window, renderer);
        game.spawnEntity(Player, new Vector2d(350, 500));
        game.spawnEntity(Enemy, new Vector2d(350, 50));
        game.spawnEntity(Shot, new Vector2d(350, 450));

        game.run();

    }

    private static List<Sprite> background() {
        Sprite backgroundSprite = new Sprite(loadImage("starfield.png"), new Vector2d(0, 0));
        return newArrayList(backgroundSprite);
    }

    private static Image loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + fileName);
        return imageIcon.getImage();
    }

}
