package calenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basics.BrowserHelper;

public class CalenderDemo extends BrowserHelper{
	
	public static void selectDate(WebElement calendar, String dte) {
		boolean flag = false;
		//locate all rows
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			List<WebElement> dates = row.findElements(By.tagName("td"));
			for(WebElement date : dates) {
				if(date.getText().equals(dte)) {
					date.findElement(By.tagName("a")).click();
					flag = true;
					break; // dates loop
				}
			}
			if(flag) {
				break; //rows loop
			}
		}
	}
	
	public static void main(String[] args) {
		
		launchBrowser("chrome", "https://www.makemytrip.com/");
		//locate departure date
		driver.findElement(By.id("hp-widget__depart")).click();
		//locate table
		WebElement dcalendar = driver.findElement(By.cssSelector(".dateFilter .ui-datepicker-group-last tbody"));
		selectDate(dcalendar, "6");
		sleep(4000);
		//locate return data
		driver.findElement(By.id("hp-widget__return")).click();
		WebElement rcalendar  = driver.findElement(By.cssSelector(".dateFilterReturn .ui-datepicker-group-first tbody"));
		selectDate(rcalendar, "21");
		sleep(4000);
		closeBrowser();
	}

}
