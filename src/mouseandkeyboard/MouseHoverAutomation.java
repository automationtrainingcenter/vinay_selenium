package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basics.BrowserHelper;

public class MouseHoverAutomation extends BrowserHelper {
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.amazon.in/");
		
		//To automate mouse events selenium provides Actions class
		//Using this Actions class we can perform multiple actions together on multiple elements
		
		//create an object of Actions class
		Actions actions = new Actions(driver);
		
		//move the mouse to shop by category link
		WebElement shopByCat = driver.findElement(By.id("nav-link-shopall"));
		actions.moveToElement(shopByCat).build().perform();
		sleep(2000);
		//move the mouse to mobile and computers
		WebElement mobiles = driver.findElement(By.xpath("//span[contains(text(),'Mobiles, Computers')]"));
		actions.moveToElement(mobiles).build().perform();
		sleep(2000);
		//move the mouse to power banks and click on it
		WebElement powerBanks = driver.findElement(By.xpath("//span[contains(text(),'Power Banks')]"));
		actions.moveToElement(powerBanks).click().build().perform();
		sleep(3000);
		
//		actions.moveToElement(shopByCat).moveToElement(mobiles).moveToElement(powerBanks).click().build().perform();
//		sleep(3000);
		
		closeBrowser();
		
	}

}
