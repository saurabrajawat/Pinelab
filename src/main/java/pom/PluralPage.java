package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Browser;
import helper.Config;

public class PluralPage {

	
	public static WebElement searchButton(Config testConfig, WebDriver driver) {
		WebElement element = null;
		By by = By.xpath(".//button[@id='suggestion-search-button']");
		element = driver.findElement(by);
		testConfig.logComment("Search Button Element visible ");
		return element;
	}
	
	
	public static WebElement playWithPlural(Config testConfig) {
		WebElement element = null;
		try{
		//By by = By.xpath("(.//button[@id='plural-btn1'])[3]");
		By by = By.xpath(".//img[@alt='Northern Lights']");
		element = Browser.waitForVisibility(testConfig, by, "Play with plural button");
		}catch (Exception e) {
			testConfig.logException("Play with plural button not visible", e, true);
		}
		return element;
	}
	
	
}
