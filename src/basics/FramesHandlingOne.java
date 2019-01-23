package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandlingOne {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("file:///D:/SSTS/sharath/seleniumconcepts/frames/framesDemo.html");
		Thread.sleep(10000);
		driver.get("https://learn.letskodeit.com/p/practice");
		
		//locate text field in main page
		driver.findElement(By.id("displayed-text")).sendKeys("arun");
		Thread.sleep(2000);
		//now focus is in main page switch the focus to frame
		driver.switchTo().frame("courses-iframe");
		//now focus is in frame
		//locate the text field in frame
		driver.findElement(By.id("search-courses")).sendKeys("Java");
		Thread.sleep(2000);
		//now focus is in frame switch the focus to main page
		driver.switchTo().defaultContent();
		//now focus is in main page
		driver.findElement(By.id("name")).sendKeys("vinayak");
		Thread.sleep(2000);
		driver.close();
	}

}
