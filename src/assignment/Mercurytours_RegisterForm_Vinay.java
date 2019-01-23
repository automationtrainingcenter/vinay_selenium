package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;



public class Mercurytours_RegisterForm_Vinay{
	// automate the registration form in http://newtours.demoaut.com/
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		registerLink.click();
		
		//WebElements of Register form
		WebElement firstNameEle = driver.findElement(By.name("firstName"));
		WebElement lastNameEle = driver.findElement(By.name("lastName"));
		WebElement phoneEle = driver.findElement(By.name("phone"));
		WebElement emailEle = driver.findElement(By.id("userName"));
		WebElement address1Ele = driver.findElement(By.name("address1"));
		WebElement cityEle = driver.findElement(By.name("city"));
		WebElement stateEle = driver.findElement(By.name("state"));
		WebElement postalCodeEle = driver.findElement(By.name("postalCode"));
		WebElement userNameEle = driver.findElement(By.id("email"));
		WebElement passwordEle = driver.findElement(By.name("password"));
		WebElement confirmPasswordEle = driver.findElement(By.name("confirmPassword"));
		WebElement submitButtonEle = driver.findElement(By.name("register"));
		Thread.sleep(2000);
		//Select method for country dorpdown list
		WebElement countryDropDownEle = driver.findElement(By.name("country"));
		Select countrySelectEle = new Select(countryDropDownEle);
		Thread.sleep(2000);
		firstNameEle.sendKeys("Vinay");
		lastNameEle.sendKeys("Kar");
		phoneEle.sendKeys("1234567890");
		emailEle.sendKeys("aaa@gmail.com");
		address1Ele.sendKeys("1234 chandanagar");
		cityEle.sendKeys("Hyderabad");
		stateEle.sendKeys("Telangana");
		postalCodeEle.sendKeys("500041");
	    userNameEle.sendKeys("vinayakkarabari");
	    passwordEle.sendKeys("Test@123");
	    confirmPasswordEle.sendKeys("Test@123");
	    countrySelectEle.selectByValue("92");
	    Thread.sleep(3000);
	    submitButtonEle.click();
	    
	    Thread.sleep(3000);
	    driver.close();
	    
	}

}
