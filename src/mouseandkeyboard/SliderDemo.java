package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basics.BrowserHelper;

public class SliderDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/slider/");
		
		//switch to frame
		driver.switchTo().frame(0);
		//locate slider head
		WebElement sliderHead = driver.findElement(By.cssSelector("#slider>span"));
		
		//Create Actions class object
		Actions  actions = new Actions(driver);
		//move the slide head
		actions.clickAndHold(sliderHead).moveByOffset(350, 0).release().build().perform();
		sleep(3000);
		actions.dragAndDropBy(sliderHead, -150, 0).build().perform();
		sleep(3000);
		closeBrowser();
		
	}

}
