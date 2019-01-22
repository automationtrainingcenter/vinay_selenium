package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * To work with drop down list or list box selenium provides Select Class.
 * This class contains several methods to work with drop down lists
 */

public class DropDownListDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
		//locate dropdown list
		WebElement dayDD = driver.findElement(By.id("day"));
		//create a Select class object
		Select daySelect = new Select(dayDD);
		//getDefaultSelectedOption
		System.out.println("default date is"+daySelect.getFirstSelectedOption().getText());
		//select an option based on index of the option tags
		daySelect.selectByIndex(8);
		Thread.sleep(2000);
		
		//locate month drop down list
		WebElement monthDD = driver.findElement(By.id("month"));
		//create a Select class object
		Select monthSelect = new Select(monthDD);
		//getDefaultSelected option
		System.out.println("defalut month is "+monthSelect.getFirstSelectedOption().getText());
		//select an option based on value of the value attribute of option tag
		monthSelect.selectByValue("7");
		Thread.sleep(2000);
		
		//locate year drop down list
		WebElement yearDD = driver.findElement(By.id("year"));
		//Create Select class object
		Select yearSelect = new Select(yearDD);
		//get default selected option
		System.out.println("default year is "+yearSelect.getFirstSelectedOption().getText());
		//select an option by using visible text (inner text of the option tag)
		yearSelect.selectByVisibleText("1991");
		Thread.sleep(2000);
		
		driver.close();
	}

}
