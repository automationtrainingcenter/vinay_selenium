package screenshots;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.annotation.Generated;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import basics.BrowserHelper;

/*
 * Selenium provides TaksScreenShot interface which contains getScreenshotAs(File obj)
 * 
 */

public class AlertScreenshotDemo extends BrowserHelper{
	
	
	public static void main(String[] args) throws Exception {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		driver.findElement(By.id("alertbtn")).click();
		// To capture alert screenshot we have to use Robot class of Java
		Robot r = new Robot();
		//createScreenCapture()
		BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(bi, "png", new File(".//screenshots//alert"+getTime()+".png"));
		sleep(3000);
		driver.switchTo().alert().accept();
		closeBrowser();
		
	}

}
