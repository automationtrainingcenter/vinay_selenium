package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class JavaScriptExecutorDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.facebook.com");
		//create JavascriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//locate first name field and fill it
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("vinayak");
		sleep(3000);
		String fnValue = (String)js.executeScript("return arguments[0].value", firstname);
		System.out.println("first name is "+fnValue);
		
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys("selenium");
		sleep(3000);
		String lnValue = (String) js.executeScript("return arguments[0].value", lastname);
		System.out.println("last name value is "+lnValue);
		
		closeBrowser();
	}
}
