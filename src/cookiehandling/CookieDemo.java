package cookiehandling;

import java.util.Set;

import org.openqa.selenium.Cookie;

import basics.BrowserHelper;

public class CookieDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.amazon.in");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("the number of cookies "+cookies.size());
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName()+"\t"+cookie.getValue());
		}
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		driver.close();
	}

}
