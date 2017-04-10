import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame {

private int width = 300;
private int height = 300;

private BufferedImage img = null;

public Window() {
    setSize(width, height);
    setTitle("File Monitor:D");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

}

public void loadImage(String src) throws IOException {
    //img = new ImageIcon(src).getImage();
    img = ImageIO.read(new File(src));
}

public void drawIcon() {
    Graphics g = getGraphics();
    g.drawImage(img, 0, 0, width, height, null);
}
}