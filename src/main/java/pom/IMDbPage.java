package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Config;
import stepdefinition.ServiceHook;

public class IMDbPage {


	public static WebElement searchBox(Config testConfig, WebDriver driver) {
		WebElement element = null;
		By by = By.xpath(".//input[@name='q']");
		element = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(by));
		testConfig.logComment("Search box Element visible ");
		return element;
	}
	
	public static WebElement searchButton(Config testConfig, WebDriver driver) {
		WebElement element = null;
		By by = By.xpath(".//button[@id='suggestion-search-button']");
		element = driver.findElement(by);
		testConfig.logComment("Search Button Element visible ");
		return element;
	}
	
	
	public static WebElement categorySearch(Config testConfig, WebDriver driver) {
		WebElement element = null;
		By by = By.xpath(".//ul[@class='findFilterList']//li/a[text()='Movie']");
		element = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(by));
		testConfig.logComment("Category search movie Element visible ");
		return element;
	}
	
	public static List<WebElement> getListOfAllMovies(Config testConfig, WebDriver driver) {
		List<WebElement> elements = null;
		By by = By.xpath(".//table[@class='findList']//td[@class='result_text']");
		elements = driver.findElements(by);
		testConfig.logComment( "movie List Element visible ");
		return elements;
	}
}
