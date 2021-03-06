package basics;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import extentreports.Listener;



public class BrowserHelper {
	protected static WebDriver driver;
	protected static EventFiringWebDriver edriver;

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	public static String getTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}

	public static void launchBrowser(String brName, String url) {
		brName = brName.toLowerCase();
		if (brName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (brName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}

		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void launchBrowserWithListner(String brName, String url) {
		brName = brName.toLowerCase();
		if (brName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (brName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("browser name must be either chrome or firefox");
		}
		//create EventFiringWebDriver class object
		edriver = new EventFiringWebDriver(driver);
		// create Listener class object
		Listener listener = new Listener();
		// register the listener class object with EventFiringWebDriver
		edriver.register(listener);
		driver  = edriver;
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
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
