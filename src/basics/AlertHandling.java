package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * To handle Alerts Selenium provides Alert class
 * This class contains
 * accept() which will click on OK button of alert
 * dismiss() which will click on Cancel button of alert
 * sendKeys() which will send some data to the alert text box if it contains any
 * getText() which will get the text of alert
 */

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		//locate button which displays an alert
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		//switch the driver focus to alert using switchTo()
		Alert alert = driver.switchTo().alert();
		//get the text of alert and print on the console
		System.out.println("alert text is :"+alert.getText());
		//accept the alert
		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("name")).sendKeys("surya");
		//locate confirm button which will open one more alert and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		//switch the driver focus to alert
		alert = driver.switchTo().alert();
		//get the text of the alert
		System.out.println("alert text is "+alert.getText());
		// dismiss the alert
		alert.dismiss();
		Thread.sleep(2000);
		driver.close();
	}

}
