package vinay_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignmentVinay {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/V/selenium/workspace/Sunshine_selenium/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//switch to frame one
		driver.switchTo().frame("fone");
		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("vinay");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).clear();
		
		//Come out of frame one
		driver.switchTo().defaultContent();
		
		//switch to frame two
		
		driver.switchTo().frame("ftwo");
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(2000);
		//come out of frame two
		driver.switchTo().defaultContent();
		
		//switch to frame three
		
		driver.switchTo().frame("fthree");
		driver.findElement(By.id("click")).click();
		Thread.sleep(2000);
		
		//child frame of framethree
		driver.switchTo().frame("http://www.guru99.com/");
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("click")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.close();
	}

}
