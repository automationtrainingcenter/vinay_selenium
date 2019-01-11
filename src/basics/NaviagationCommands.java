package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaviagationCommands {

	public static void main(String[] args) throws InterruptedException {
		// set System property to the driver executable file
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		// create an object of the browser class
		WebDriver driver = new ChromeDriver();

		// navigate to a url using to() method of Navigation Interface
//		Navigation navigate = driver.navigate();
//		navigate.to("http://www.facebook.com");
		
		driver.navigate().to("http://www.facebook.com");
		Thread.sleep(4000);
//		navigate back 
		driver.navigate().back();
		Thread.sleep(4000);
//		navigate forward
		driver.navigate().forward();
		Thread.sleep(4000);
//		refresh the page
		driver.navigate().refresh();
		Thread.sleep(4000);
//		close the browser
		driver.close();
		
		

	}

}
