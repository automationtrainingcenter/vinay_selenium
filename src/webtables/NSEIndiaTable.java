package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class NSEIndiaTable extends BrowserHelper {
	public static void main(String[] args) {
		String companyCode = "MARUTI";
		launchBrowser("chrome",
				"https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		sleep(3000);
		// locate table body
		WebElement table = driver.findElement(By.xpath("//table[@id = 'preOpenNiftyTab']/tbody"));
		// locate all the rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 2; i < rows.size(); i++) {
			//locate all the cells in evrey row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if(cells.get(0).getText().equals(companyCode)){
				System.out.println("price is "+cells.get(3).getText());
				break;
			}
		}
		
		
		closeBrowser();
	}

}
