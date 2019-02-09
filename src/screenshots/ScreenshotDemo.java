package screenshots;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.annotation.Generated;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basics.BrowserHelper;

/*
 * Selenium provides TaksScreenShot interface which contains getScreenshotAs(File obj)
 * 
 */

public class ScreenshotDemo extends BrowserHelper{
	
	
	public static void main(String[] args) throws Exception {
		launchBrowser("chrome", "http://www.amazon.in");
		// To capture screenshot convert WebDriver object to TakeScreenshot interface object
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File desImg = new File(".//screenshots//image"+getTime()+".png");
//		BufferedImage bi;
//		try {
//			bi = ImageIO.read(srcImg);
//			ImageIO.write(bi, "png", desImg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		FileUtils.copyFile(srcImg, desImg);
		sleep(3000);
		closeBrowser();
		
	}

}
