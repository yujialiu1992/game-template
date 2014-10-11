package com.thoughtworks.game_template.main;

import com.thoughtworks.game_template.game.Game;
import com.thoughtworks.game_template.game.Movable;
import com.thoughtworks.game_template.render.Renderer;
import com.thoughtworks.game_template.render.Sprite;
import com.thoughtworks.game_template.render.Vector2d;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Renderer renderer = new Renderer(background());
        renderer.activate();

        List<Movable> objects = newArrayList();
        Game game = new Game(objects, renderer);
        game.spawnEntity(new Vector2d(350, 350));

        game.run();

        renderer.deactivate();
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
