package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import stepdefinition.ServiceHook;

public class BaseDriver extends BaseRunnerConfig {

	
	public static WebDriver driver;
	
	public static WebDriver openBrowser() {
		 System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
		 ChromeOptions options = new ChromeOptions();
		    options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-popup-blocking");
			
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			return driver;
	}
}
