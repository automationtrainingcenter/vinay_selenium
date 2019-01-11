package basics;
/*
 * There are 8 locating techniques in selenium in By class
 * id : it will locate element using id attribute value of the element
 * Note: try ignore the id values with digits, because those ids will change dynamically when we 
 * refresh the page
 * 
 * name : it will locate element using name attribute value of the element
 * 
 * linkText : it will locate an element based on the inner text of the anchor (a) tag
 * Note: inner text means text in between opening and closing tags
 * 
 * partialLinkText : it will locate an element based on the part of the inner text of the anchor (a) tag
 * 
 * cssSelector : we can locate an element using any attribute value
 * syntax : tagname[attribute_name = 'attribute value']
 * 
 * xpath : xml path this is also used to locate an element using any attribute value
 * syntax : //tagname[@attibute_name = 'attribute value']
 * 
 * tagName : which is used to locate element using it's tag name
 * 
 * className : which is used to locate element using class attribute value
 * 
 * Note: if we class name or tag name there is a probability we can locate multiple elements
 * All above techniques are static methods in By class
 * 
 * To locate an element we have to use findElement() of WebDriver interface by passing 
 * a By class argument using any of the above techniques
 * 
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {

	public static void main(String[] args) {
		// set System property to the driver executable file
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		// create an object of the browser class
		WebDriver driver = new ChromeDriver();

		// navigate to a url using get()
		driver.get("http:\\www.facebook.com");
		
		driver.manage().window().maximize();
		
		//id
		WebElement username =driver.findElement(By.id("email"));
		
		// name
		driver.findElement(By.name("firstname"));
		
		// linkText
		driver.findElement(By.linkText("Forgotten account?"));
		
		// partial Link text
		driver.findElement(By.partialLinkText("date of birth?"));
		
		// css selector
		driver.findElement(By.cssSelector("input[value='1']"));
		
		// xpath
		driver.findElement(By.xpath("//button[@name='websubmit']"));
		
		// tagname
		List<WebElement> inputTags = driver.findElements(By.tagName("input"));
		System.out.println(inputTags.size());
		
		// class name
		List<WebElement> textfields = driver.findElements(By.className("inputtext"));
		System.out.println(textfields.size());
		
		driver.close();
	}

}
