package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.CycleDetectingLockFactory.Policies;

public class BrowserManageCommands {
	public static void main(String[] args) throws InterruptedException {
		// set System property to the driver executable file
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		// create an object of the browser class
		WebDriver driver = new ChromeDriver();

		// navigate to a url using get()
		driver.get("http:\\www.facebook.com");
		
		//create an object of Options interface
//		WebDriver.Options manage = driver.manage();
		
		//create an object of Window interface
//		WebDriver.Window window = manage.window();
		
	
		//call the methods of Window interface
		
		//get the initial size of the browser window
		Dimension size = driver.manage().window().getSize();
		System.out.println("inital size width = "+size.getWidth()+"height = "+size.getHeight());
		
		// get the initial position of the browser window
		Point position = driver.manage().window().getPosition();
		System.out.println("inital poistion x = "+position.getX()+"y = "+position.getY());
		
		//to maxmize the browser window
//		window.maximize();
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//to fullscreen
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		
		// set the size of the browser window
//		Dimension dim = new Dimension(250, 550);
		driver.manage().window().setSize(new Dimension(250, 550));
		Thread.sleep(5000);
		
		// set the position of the window
		driver.manage().window().setPosition(new Point(500, 200));;
		Thread.sleep(5000);
		
		driver.close();
		

	}

}
