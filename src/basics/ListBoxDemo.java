package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn.letskodeit.com/p/practice");

		// locate list box
		WebElement fruitsList = driver.findElement(By.id("multiple-select-example"));
		// Create Select class object
		Select fruitSelect = new Select(fruitsList);
		// get all the options of list box
		List<WebElement> options = fruitSelect.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

		// verify listbox allows multiple selection or not
		if (fruitSelect.isMultiple()) {
			// select an option using index value
			fruitSelect.selectByIndex(2);
			Thread.sleep(2000);
			// select an option using value attribute value
			fruitSelect.selectByValue("apple");
			Thread.sleep(2000);
			// select an option using visible text
			fruitSelect.selectByVisibleText("Orange");
			Thread.sleep(2000);
			
			//get all selected options
			List<WebElement> allSelectedOptions = fruitSelect.getAllSelectedOptions();
			System.out.println("the number of options selected is "+allSelectedOptions.size());
			
			//deselect all the selected options
//			fruitSelect.deselectAll();
//			Thread.sleep(2000);
			//deselect an option using index
			fruitSelect.deselectByIndex(0);
			Thread.sleep(2000);
			//deselect and option using value
			fruitSelect.deselectByValue("peach");
			Thread.sleep(2000);
			//deselect an option using visible text
			fruitSelect.deselectByVisibleText("Orange");
			Thread.sleep(2000);
			
		}
		driver.close();
	}

}
