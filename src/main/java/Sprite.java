import java.awt.*;

public class Sprite {
    private Image image;
    private int x;
    private int y;

    public Sprite(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

}
