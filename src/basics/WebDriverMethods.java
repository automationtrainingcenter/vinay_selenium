package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
	
	public static void main(String[] args) {
		//set System property to the driver executable file
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		
		//create an object of the browser class
		WebDriver driver = new ChromeDriver();
		
		//navigate to a url using get() 
		driver.get("http:\\www.facebook.com");
		
		// getTitle() which returns a string value which is title of the current web page
		String title = driver.getTitle();
		System.out.println(title);
		
		// getCurrentUrl() which returns a string value which is url of the current web page
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		// getPageSource() which returns a string value which is complete source code of the current web page
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.contains("Facebook helps you connect and share with the people in your life."));
		
		// getWindowHandle() which returns a string value which is unique id of the browser window
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);
		
		// getWindowHandles() which return a set of String values which are unique ids of the windows
		// opened by the webdriver instance
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		/* findElement(By arg) which accepts a By class argument and returns a WebElement interface 
		 * reference. It is used to locate an element in the web page using locating techniques provided 
		 * in By class. If an element located with the information we provided it will return that
		 * element as a WebElement interface reference else it will throw NoSuchElementException
		 */
		
//		By arg = By.id("email");
//		WebElement element = driver.findElement(arg);
		WebElement element = driver.findElement(By.id("email"));
			
		/*
		 * findElements(By arg): which accepts a By class argument and returns List of WebElement type
		 * If elemnets are located using the information we provided it will return the List of those elements
		 * else it will return List of size 0
		 */
		List<WebElement> inputElements = driver.findElements(By.tagName("input"));
		System.out.println("total number of input elements are"+inputElements.size());
		
		// close() which closes the current browser window
		driver.close();
		
		// quit() which closes all the browser windows opened by the driver instance
		driver.quit();
		
	}

}
