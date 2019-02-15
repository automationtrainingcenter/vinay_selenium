package waittypes;



import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FluentWaitDemo {
	
//	static Function<WebDriver, WebElement> func = new Function<WebDriver, WebElement>() {
//
//		@Override
//		public WebElement apply(WebDriver t) {
//			return t.findElement(By.id("email"));
//		}
//	};
	
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(ElementNotVisibleException.class);
		WebElement ele = wait.until((WebDriver t)->t.findElement(By.name("reg_email_confirmation__")));
		ele.sendKeys("surya");
		
		Thread.sleep(3000);
		
		driver.close();
		
		

	}

}
