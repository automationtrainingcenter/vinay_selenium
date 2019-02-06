package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class NseIndiaTwo extends BrowserHelper {
	public static void main(String[] args) {
		String companyCode = "TECHM";
		launchBrowser("chrome",
				"https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		// locate table body
		WebElement table = driver.findElement(By.xpath("//table[@id='preOpenNiftyTab']/tbody"));
		// locate all the rows of the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// iterate over every row from second row and locate the columns
		for (int i = 2; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if(cells.get(0).getText().equals(companyCode)) {
				cells.get(0).findElement(By.linkText(companyCode)).click();
				break;
			}
		}
		
		sleep(5000);
		closeBrowser();
	}
}
