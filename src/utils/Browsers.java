package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	public static WebDriver driver;
	@SuppressWarnings("unused")
	public static void setUp(){
		if(Util.driverType =="firefox")
		{
			System.setProperty("webdriver.gecko.driver",Util.FirefoxDriveLocation);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Util.driverWaitTime, TimeUnit.SECONDS);
			driver.get(Util.baseUrl);
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver",Util.ChromeDriveLocation);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Util.driverWaitTime, TimeUnit.SECONDS);
			driver.get(Util.baseUrl);
		}
	}
	public WebDriver getDriver() {
	    return driver;
	}
	public void setDriver(WebDriver driver) {
		Browsers.driver = driver;}
}
