package javascriptExecutor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.ClickAction;

import basics.BrowserHelper;

public class MultiScreenshots extends BrowserHelper {
	public static void main(String[] args) {
		launchBrowser("chrome", "http://amazon.in");
		// create JavascriptExecutor reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
		long clientHeight = (long) js.executeScript("return document.documentElement.clientHeight");
		while (scrollHeight >= 0) {
			File srcImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File desImg = new File(".//screenshots//amazon"+getTime()+".png");
			try {
				FileUtils.copyFile(srcImg, desImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", clientHeight);
			sleep(2000);
			scrollHeight -= clientHeight;
		}
		
		closeBrowser();

	}

}
