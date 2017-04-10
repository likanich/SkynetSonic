import java.awt.AWTException;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException, AWTException {
		
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
        
        Bot bot = new Bot();
        bot.prtSc();
        
        Window w1 = new  Window();
    	w1.loadImage();
    	w1.drawIcon();
        
	}

}
