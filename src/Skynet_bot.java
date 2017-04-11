import java.awt.AWTException;
import java.io.IOException;

public class Skynet_bot {
	
	public static void main(String[] args) throws IOException, AWTException {
		
		
		Window window = new  Window();
        window.interception();
		
        Bot bot = new Bot();
        bot.prtSc();
        
    	window.loadImage();
    	window.drawIcon();
    	
    	
        
	}

}
