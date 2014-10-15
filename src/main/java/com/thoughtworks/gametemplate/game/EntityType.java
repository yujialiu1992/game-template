package com.thoughtworks.gametemplate.game;

import javax.swing.*;
import java.awt.*;

public enum EntityType {
    Player(loadImage("playerShip.png").getScaledInstance(60, 60, 0)),
    Enemy(loadImage("enemyShip.png").getScaledInstance(60, 60, 0)),
    Shot(loadImage("shot.png").getScaledInstance(10, 20, 0));

    protected Image image;

    EntityType(Image image) {
        this.image = image;
    }


    public Image image() {
        return image;
    }

    private static Image loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + fileName);
        return imageIcon.getImage();
    }

}
