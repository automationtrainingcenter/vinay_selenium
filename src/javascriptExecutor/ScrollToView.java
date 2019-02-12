package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class ScrollToView extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.amazon.in");
		//create JavascriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//locate the element we want to scroll into view
		WebElement giftASmileLink = driver.findElement(By.xpath("//a[contains(text(),'Gift a Smile')]"));
		
		//brink above link to view
		js.executeScript("arguments[0].scrollIntoView()", giftASmileLink);
		sleep(3000);
		closeBrowser();
	}
}
