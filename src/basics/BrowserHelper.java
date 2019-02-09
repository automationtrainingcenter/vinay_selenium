package basics;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
	protected static WebDriver driver;
	
	public static String getTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}
	
	public static void launchBrowser(String brName, String url) {
		brName = brName.toLowerCase();
		if(brName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(brName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	public static void closeBrowser() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
