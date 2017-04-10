import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

public void loadImage() throws IOException {
    //img = new ImageIcon(src).getImage();
    //img = ImageIO.read(new File(src));
	img = getImageFromClipboard();
}

public void drawIcon() {
    Graphics g = getGraphics();
    g.drawImage(img, 0, 0, width, height, null);
}
public static BufferedImage getImageFromClipboard(){
	  Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
	  if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
	  {
	    try
	    {
	      return (BufferedImage) transferable.getTransferData(DataFlavor.imageFlavor);
	    }
	    catch (UnsupportedFlavorException e)
	    {
	      // handle this as desired
	      e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	      // handle this as desired
	      e.printStackTrace();
	    }
	  }
	  else
	  {
	    System.err.println("getImageFromClipboard: That wasn't an image!");
	  }
	  return null;
	}

}