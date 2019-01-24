package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandlingTwo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/sharath/seleniumconcepts/frames/framesDemo.html");
		driver.manage().window().maximize();

		// now focus is in main page
		// switch the focus to frame 1
		driver.switchTo().frame("fone");
		// now focus is in frame 1
		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("anjali");
		Thread.sleep(2000);
		// now focus is in frame 1 switch the focus to main page
		driver.switchTo().defaultContent();
		// now focus is in main page
		// switch the focus to frame 2
		driver.switchTo().frame("ftwo");
		// now focus is in frame 2
		driver.findElement(By.partialLinkText("official")).click();
		Thread.sleep(2000);
		// now focus is in frame 2 switch the focus to main page
		driver.switchTo().defaultContent();
		// now focus is in main page
		// switch the focus to frame 3
		driver.switchTo().frame("fthree");
		//now focus is in frame 3 switch the focus to frame 4
		//locate frame 4 element
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@src='http://www.guru99.com/']"));
		//switch to frame 4
		driver.switchTo().frame(frame4);
		//now focus is in frame 4
		driver.findElement(By.xpath("//input[@placeholder='Search your Favorite Course...']")).sendKeys("selenium");
		Thread.sleep(2000);
		//now focus is in frame 4 and switch the focus to frame 3
		//frame 4 is child frame of frame 3 so we can switch from frame 4 to frame 3 using parentFrame() method
		driver.switchTo().parentFrame();
		//now focus is in frame3
		driver.findElement(By.id("click")).click();
		Thread.sleep(2000);
		//now foucs is in frame 3 switch the focus to main page
		driver.switchTo().defaultContent();
		//now focus is in main page
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);
		driver.quit();
		

	}

}
