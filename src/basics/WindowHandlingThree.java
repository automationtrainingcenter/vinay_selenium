package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingThree {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///D:/SSTS/sharath/seleniumconcepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//focus is in main window locate open windows button and click on it
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		//get all the window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		String[] windowsIds = new String[windowHandles.size()];
 		//iterate over windowHanldes set
		for(String handle : windowHandles) {
			driver.switchTo().window(handle);
			String title = driver.getTitle();
			if(title.contains("Facebook")) {
				windowsIds[1]= handle;
			}else if(title.contains("YouTube")) {
				windowsIds[2] = handle;
			}else if(title.contains("Google")) {
				windowsIds[3] = handle;
			}else if(title.contains("Frames Demo")) {
				windowsIds[0] = handle;
			}
		}
		
		
		
		//automate facebook window
		driver.switchTo().window(windowsIds[1]);
		Thread.sleep(2000);
		//now focus is in facebook window
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("surya@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("pass")).submit();
		Thread.sleep(3000);
		
		
		//now switch focus to youtube
		driver.switchTo().window(windowsIds[2]);
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium");
		Thread.sleep(4000);
		
		//now switch focus to google
		driver.switchTo().window(windowsIds[3]);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium webdriver"+Keys.ENTER);
		Thread.sleep(4000);
		
		//now switch to main window
		driver.switchTo().window(windowsIds[0]);
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
