package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basics.BrowserHelper;

public class DragElement extends BrowserHelper{

	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/draggable/");
		sleep(2000);
		//switch to frame which contains drag element
		driver.switchTo().frame(0);
		
		//locate drag element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		//create Actions class object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(dragEle).moveByOffset(350, 150).release().build().perform();
		actions.dragAndDropBy(dragEle, 350, 150).build().perform();
		sleep(3000);
		driver.close();
	}
		
}
