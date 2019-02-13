package waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		//implicit wait : will wait for every element in the to load for certain amount of time
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//		
//		//page load timeout : will wait until the page loads completely
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		
//		//setScriptTimeout() : will wait until javascript code loads completely
//		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
		//explicit wait
		//create WebDriverWait class object
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("surya");
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
