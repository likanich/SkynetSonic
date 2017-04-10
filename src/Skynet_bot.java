import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class Skynet_bot {
	
	public static interface User32 extends StdCallLibrary
    {
         final User32 instance = (User32) Native.loadLibrary ("user32", User32.class, 
                          W32APIOptions.UNICODE_OPTIONS);
         HWND FindWindow(String className, String windowName);
         HWND SetFocus(HWND hWnd);
         boolean SetForegroundWindow(HWND hWnd);
         boolean SetWindowText(HWND hwnd, String newText);
    }

	public static void main(String[] args) throws IOException {
		
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
        
        try {
            Robot robot = new Robot();

            // Robot start writting
            for(int i = 0; i < 5; i++){
             
            	/*robot.delay(2000);
            	robot.keyPress(KeyEvent.VK_D);
            	robot.delay(3000);
            	
            	robot.keyPress(KeyEvent.VK_K);
            	robot.delay(100);
            	robot.keyRelease(KeyEvent.VK_K);
            	*/
            }
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_PRINTSCREEN);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_PRINTSCREEN);

        } catch (AWTException e) {

            e.printStackTrace();

        }
        
        
        Window w1 = new  Window();
    	w1.loadImage();
    	w1.drawIcon();
        
	}

}
