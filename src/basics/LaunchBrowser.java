package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
// to launch the browser create an object of the browser driver class
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver obj = new ChromeDriver();
		// navigate to a url using get() method
		obj.get("http://www.google.com");
		Thread.sleep(4000);
		// to close a browser we can use close method
		obj.close();
		
		// launch Firefox Browser
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		obj = new FirefoxDriver();
		obj.get("http://facebook.com");
		
		Thread.sleep(4000);
		obj.close();
		
		
	}

}
