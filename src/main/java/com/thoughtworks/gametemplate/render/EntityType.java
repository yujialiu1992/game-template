package com.thoughtworks.gametemplate.render;

public enum EntityType {
    Player("playerShip.png"),
    Enemy("enemyShip.png"),
    Shot("shot.png");

    protected String image;

    EntityType(String image) {
        this.image = image;
    }

    public String image() {
        return image;
    }
}
