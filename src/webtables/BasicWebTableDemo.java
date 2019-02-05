package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class BasicWebTableDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		//locate table body
		WebElement table = driver.findElement(By.cssSelector("table#product>tbody"));
		//find all the rows inside the table body using tagname tr
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//iterate over the rows and find all the columns
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			//iterate over the cells the get the data of the table
			for(WebElement cell : cells) {
				System.out.print(cell.getText()+"\t");
			}
			System.out.println();
		}
		
		closeBrowser();
	}

}
