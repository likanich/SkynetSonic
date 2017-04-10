import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class Bot {
	
	private Robot robot;
	
	public Bot() throws AWTException{
		robot = new Robot();
	}
	
	
	public void prtSc(){  //do printScreen to Clipboard

		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_PRINTSCREEN);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
		
	}
	
	public void goForward () { //Sonic go forward
		
		robot.keyPress(KeyEvent.VK_D);
		
	}
	
	public void stopForward () { //Sonic stop go forward
		
		robot.keyRelease(KeyEvent.VK_D);
	}
	
	public void jump () {  //Sonic jump
		
		robot.keyPress(KeyEvent.VK_K);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_K);
		
	}
	
	public void goBackward () { //Sonic go backward
		
		robot.keyPress(KeyEvent.VK_A);
		
	}
	
	public void stopBackward () { //Sonic stop go backward
		
		robot.keyRelease(KeyEvent.VK_A);
	}


}
