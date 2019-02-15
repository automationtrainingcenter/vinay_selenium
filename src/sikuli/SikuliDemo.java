package sikuli;

import java.io.File;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import basics.BrowserHelper;

public class SikuliDemo extends BrowserHelper{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		driver.findElement(By.xpath("//div[text()='Choose file']")).click();
		sleep(2000);
		//Create Screen class Object
		Screen screen  = new Screen();
		// create Pattern class objects
		Pattern fileName = new Pattern(getFilePath("images", "fileName.PNG"));
		Pattern openButton = new Pattern(getFilePath("images", "OpenButton.PNG"));
		
		screen.find(fileName);
		screen.type(fileName, "D:\\selenium\\web services testing.docx");
		sleep(2000);
		screen.find(openButton);
		screen.click(openButton);
		sleep(3000);
		driver.close();
	}

}
