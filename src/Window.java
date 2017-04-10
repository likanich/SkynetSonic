import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class Window extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 300;
	private int height = 300;

	private BufferedImage img = null;

	public static interface User32 extends StdCallLibrary //interface for win32 
	{
	     final User32 instance = (User32) Native.loadLibrary ("user32", User32.class, 
	                      W32APIOptions.UNICODE_OPTIONS);
	     HWND FindWindow(String className, String windowName);
	     HWND SetFocus(HWND hWnd);
	     boolean SetForegroundWindow(HWND hWnd);
	     boolean SetWindowText(HWND hwnd, String newText);
	}

	public Window() {
	    setSize(width, height);
	    setTitle("File Monitor");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setVisible(true);
	
	}
	
	public void interception () { //inerception window with Sonic
		HWND hwnd = User32.instance.FindWindow("gens", null);
	    if(hwnd == null) {
	        hwnd = User32.instance.FindWindow(null, "gens");
	    }
	    if(hwnd == null) {
	        System.out.println("Окно не найдено");
	        return;
	    }
	    System.out.println("Нашли окно: "+hwnd);
	    User32.instance.SetForegroundWindow(hwnd);
	}
	
	public void loadImage() throws IOException {// load image from clipboard
	
		img = getImageFromClipboard();
	}
	
	public void drawIcon() { // show image on new window
	    Graphics g = getGraphics();
	    g.drawImage(img, 0, 0, width, height, null);
	}
	
	public static BufferedImage getImageFromClipboard(){ //get image from clipboard
		Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)){
		    try{
		    	return (BufferedImage) transferable.getTransferData(DataFlavor.imageFlavor);
		    }
		    catch (UnsupportedFlavorException e){
		      // handle this as desired
		      e.printStackTrace();
		    }
		    catch (IOException e){
		      // handle this as desired
		      e.printStackTrace();
		    }
		}
		else{
		    System.err.println("getImageFromClipboard: That wasn't an image!");
		}
		return null;
	}

}