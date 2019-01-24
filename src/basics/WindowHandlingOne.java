package basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingOne {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		//locate the button which will open new window and click on it
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		// index 0 of list contains parent window, index 1 contains 1st child window, index 2 contains 2nd child window and so on
		//now focus is in main window switch the focus to child window
		driver.switchTo().window(windowHandles.get(1));
		System.out.println("current url of the page is "+driver.getCurrentUrl());
		driver.findElement(By.id("search-courses")).sendKeys("java");
		Thread.sleep(3000);
		//switch the focus back to main window
		driver.switchTo().window(windowHandles.get(0));
		driver.findElement(By.id("name")).sendKeys("surya");
		Thread.sleep(3000);
		driver.quit();
	}

}
