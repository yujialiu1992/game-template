import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class Renderer extends JFrame {
    private static final int FONT_SIZE = 24;
    private List<Sprite> sprites;
    private GraphicsDevice device;


    public Renderer(List<Sprite> sprites, GraphicsDevice device) {
        this.sprites = sprites;
        this.device = device;
        setBackground(Color.blue);
        setForeground(Color.white);
        setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
    }

    public void paint(Graphics g) {
        // set text anti-aliasing
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }

    public void setFullScreen(DisplayMode displayMode) {
        setUndecorated(true);
        setResizable(false);

        boolean isWindowed = true;
        if (isWindowed){
            setSize(1024,768);
            setLocation(0, 0);
            setVisible(true);
        } else{
            device.setFullScreenWindow(this);
            if (displayMode != null && device.isDisplayChangeSupported()) {
                try {
                    device.setDisplayMode(displayMode);
                } catch (IllegalArgumentException ex) {
                    // ignore - illegal mode for this device
                }
            }
        }

    }


    public void restoreScreen() {
//        Window window = device.getFullScreenWindow();
//        if (window != null) {
        dispose();
//        }
//        device.setFullScreenWindow(null);
    }

}
