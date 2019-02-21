package extentreports;

import org.openqa.selenium.By;

import basics.BrowserHelper;

public class LogReports extends BrowserHelper{
	
	//launch browser
	public static void testLaunchBrowser() {
		launchBrowserWithListner("chrome", "http://srssprojects.in");
	}
	
	//login test
	public static void testLogin() {
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
	}
	
	//logout and close test
	public static void testLogout() {
		driver.findElement(By.xpath("//a[@href='home.aspx']")).click();
		closeBrowser();
	}
	
	public static void main(String[] args) {
		
		testLaunchBrowser();
		testLogin();
		sleep(4000);
		testLogout();
		
	}

}
