package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class KeyboardEvents extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.google.com");
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys(Keys.SHIFT+"selenium");
		sleep(3000);
		searchField.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
//		searchField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
//		sleep(3000);
//		searchField.sendKeys(Keys.DELETE);
		sleep(3000);
		closeBrowser();
	}

}
