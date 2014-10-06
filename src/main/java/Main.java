import java.awt.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

import static java.awt.DisplayMode.REFRESH_RATE_UNKNOWN;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DisplayMode displayMode = new DisplayMode(800, 600, 16, REFRESH_RATE_UNKNOWN);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();

        Renderer renderer = new Renderer(sprites(), device);

        renderer.setFullScreen(displayMode);
        new Game().run();
        renderer.restoreScreen();
    }

    private static List<Sprite> sprites() {
        List<Sprite> sprites = new ArrayList<Sprite>();
        sprites.add(new Sprite(loadImage("starfield.png"), 0, 0));
        sprites.add(new Sprite(loadImage("opaque.png"), 0, 0));
        sprites.add(new Sprite(loadImage("transparent.png"), 320, 0));
        sprites.add(new Sprite(loadImage("translucent.png"), 0, 300));
        sprites.add(new Sprite(loadImage("antialiased.png"), 320, 300));
        return sprites;
    }

    private static Image loadImage(String fileName) {
        return new ImageIcon("src/main/resources/images/" + fileName).getImage();
    }

}
