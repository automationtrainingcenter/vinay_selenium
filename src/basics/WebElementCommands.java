package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		//locate an element
		WebElement firstName = driver.findElement(By.name("firstname"));
		
		//sendKeys() which will take String value which is data we want to send  to the element
		firstName.sendKeys("surya");
		Thread.sleep(2000);
		
		//clear() which will remove existing data in the text fields
		firstName.clear();
		Thread.sleep(2000);
		
		//click() which will click on any element
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='2']")).click();
		Thread.sleep(2000);
		
		// submit() which will submit a form to the server if that form contains input tag whose type is submit
//		driver.findElement(By.id("pass")).submit();
		
		//getAttribute() which will return a value of the given attribute name as a String
		String attributeValue = firstName.getAttribute("class");
		System.out.println("class attribute value is "+attributeValue);
		
		//getCssValue() which returns value of given Css property as a String
		String cssValue = firstName.getCssValue("border-radius");
		System.out.println("border radius of the first name is "+cssValue);
		
		//getLocation() which returns a point class object which are x and y coordinates of element
		Point location = firstName.getLocation();
		System.out.println("location of first name is x = "+location.getX()+" y = "+location.getY());
		
		//getSize() which returns a Dimension class object which are width and height of the given element
		Dimension size = firstName.getSize();
		System.out.println("size of the first name is width = "+size.getWidth()+" height = "+size.getHeight());
		
		
		//getText() which return the inner text of the given element if any
		String text = driver.findElement(By.id("birthday-help")).getText();
		System.out.println("the inner text of the element is "+text);
		
		//getTagName() which returns the tag name of given element
		String tagName = firstName.getTagName();
		System.out.println("the tagname of first name is "+tagName);
		
		//isDisplayed() returns true if an element is present in the web page
		System.out.println(driver.findElement(By.name("reg_email_confirmation__")).isDisplayed());
		
		//isEnabled() return true if an element is in enable mode
		System.out.println(firstName.isEnabled());
		driver.close();
	}

}
