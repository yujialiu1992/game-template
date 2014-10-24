package com.thoughtworks.gametemplate.render;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {

    public Image loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + fileName);
        return imageIcon.getImage();
    }
}
