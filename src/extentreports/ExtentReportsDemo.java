package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import basics.BrowserHelper;

public class ExtentReportsDemo extends BrowserHelper{
	
	ExtentReports report;
	ExtentTest test;
	
	public void launch() {
		test = report.startTest("launch testcase");
		//launch any browser
		test.log(LogStatus.INFO, "browser launched successfully");
		//navigate to url
		test.log(LogStatus.INFO, "navigated to url");
		//maximize the browser
		test.log(LogStatus.INFO, "maximized the browser");
		test.log(LogStatus.PASS, "launch test passed");
		report.endTest(test);
		
	}
	
	public void login() {
		test = report.startTest("login");
		//enter username
		test.log(LogStatus.INFO, "username entered");
		//enter password
		test.log(LogStatus.INFO, "password entered");
		//click on login button
		test.log(LogStatus.INFO, "clicked on login button");
		test.log(LogStatus.PASS, "login test passed");
		report.endTest(test);
	}
	
	public void addToCart() {
		test = report.startTest("add to cart");
		//search for a specific product
		test.log(LogStatus.INFO, "searched for a product");
		//select a product from the results
		test.log(LogStatus.INFO, "selected a product from the search results");
		//click on add to cart button
		test.log(LogStatus.INFO, "clicked on add to cart");
		test.log(LogStatus.FAIL, "add to cart test failed");
		test.log(LogStatus.INFO, "add to cart failed screenshot "+test.addScreenCapture(getFilePath("screenshots", "alert09_Feb_19-11_02_51.png")));
		report.endTest(test);
	}
	
	public void logoutAndClose() {
		test = report.startTest("logout and close");
		//move the mouse to account symbol
		test.log(LogStatus.INFO, "mouse moved to account symbol");
		//click on logout link
		test.log(LogStatus.INFO, "clicked on logout link");
		//close the browser
		test.log(LogStatus.INFO, "closed the browser");
		test.log(LogStatus.PASS, "logout test passed");
		report.endTest(test);
	}

	
	public static void main(String[] args) {
		ExtentReportsDemo obj = new ExtentReportsDemo();
		obj.report = new ExtentReports(getFilePath("reports", "report1.html"));
		System.out.println("execution started......");
		obj.launch();
		obj.login();
		obj.addToCart();
		obj.logoutAndClose();
		
		obj.report.flush();
		obj.report.close();
		System.out.println("execution ended");
		
	}
}
