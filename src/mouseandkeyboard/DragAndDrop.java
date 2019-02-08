package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basics.BrowserHelper;

public class DragAndDrop extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/droppable/");
		
		//switch to frame which contains drag and drop elements
		driver.switchTo().frame(0);
		//locate drag element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		//locate drop element
		WebElement dropEle = driver.findElement(By.id("droppable"));
		//create Actions class object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
		actions.dragAndDrop(dragEle, dropEle).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
