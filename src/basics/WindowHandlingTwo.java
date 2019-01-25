package basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingTwo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///D:/SSTS/sharath/seleniumconcepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//focus is in main window locate open windows button and click on it
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);
		//get all the window handles
		List<String> windowsIds = new ArrayList<>(driver.getWindowHandles());
		
		System.out.println(windowsIds.size());
		
		for(int i =0; i<windowsIds.size(); i++) {
			driver.switchTo().window(windowsIds.get(i));
			System.out.println(driver.getTitle());
		}
		
		//automate facebook window
		driver.switchTo().window(windowsIds.get(1));
		Thread.sleep(2000);
		//now focus is in facebook window
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("surya@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("pass")).submit();
		Thread.sleep(3000);
		
		
		//now switch focus to youtube
		driver.switchTo().window(windowsIds.get(2));
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium");
		Thread.sleep(4000);
		
		//now switch focus to google
		driver.switchTo().window(windowsIds.get(3));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium webdriver"+Keys.ENTER);
		Thread.sleep(4000);
		
		//now switch to main window
		driver.switchTo().window(windowsIds.get(0));
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
