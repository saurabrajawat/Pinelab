package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Browser;
import helper.Config;

public class OrderDetailPage {

	
	public static WebElement merchantId(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='merchant_id']");
		element = Browser.waitForVisibility(testConfig, by, "Merchant ID");
		}catch (Exception e) {
			testConfig.logException("Merchant ID not visible", e, true);
		}
		return element;
	}
	
			
	public static WebElement merchantAccessCode(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='merchant_access_code']");
		element = Browser.waitForVisibility(testConfig, by, "Merchant Access Code");
		}catch (Exception e) {
			testConfig.logException("Merchant Access Code not visible", e, true);
		}
		return element;
	}

			
	public static WebElement merchantReturnUrl(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='merchant_return_url']");
		element = Browser.waitForVisibility(testConfig, by, "Merchant Return Url");
		}catch (Exception e) {
			testConfig.logException("Merchant Return Url not visible", e, true);
		}
		return element;
	}
	
	public static WebElement paymentInfoUrl(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//label[.='Payment Info']");
		element = Browser.waitForVisibility(testConfig, by, "Payment URL");
		}catch (Exception e) {
			testConfig.logException("Payment Url not visible", e, true);
		}
		return element;
	}
	
	public static WebElement amount(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@id='amount']");
		element = Browser.waitForVisibility(testConfig, by, "Payment Amount");
		}catch (Exception e) {
			testConfig.logException("Payment Amount box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement currencyCode(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='currency_code']");
		element = Browser.waitForVisibility(testConfig, by, "Currecny code");
		}catch (Exception e) {
			testConfig.logException("CUrrency code not visible", e, true);
		}
		return element;
	}
	
	public static WebElement orderDescription(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='order_desc']");
		element = Browser.waitForVisibility(testConfig, by, "order description");
		}catch (Exception e) {
			testConfig.logException("Order description box not visible", e, true);
		}
		return element;
	}
	
	
	public static WebElement customerInfoBar(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//label[.='Customer Info:']");
		element = Browser.waitForVisibility(testConfig, by, "customer info bar ");
		}catch (Exception e) {
			testConfig.logException("customer info bar box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement emailId(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='email_id']");
		element = Browser.waitForVisibility(testConfig, by, "Email ID");
		}catch (Exception e) {
			testConfig.logException("Email ID box not visible", e, true);
		}
		return element;
	}
	
	
	public static WebElement mobileNumber(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='mobile_number']");
		element = Browser.waitForVisibility(testConfig, by, "Mobile number ");
		}catch (Exception e) {
			testConfig.logException("Mobile number box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement billingAddressBar(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//label[.='Billing Address:']");
		element = Browser.waitForVisibility(testConfig, by, "Billing Address info bar ");
		}catch (Exception e) {
			testConfig.logException("Billing Address info bar box not visible", e, true);
		}
		return element;
	}
	
	
	public static WebElement firstName(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_first_name']");
		element = Browser.waitForVisibility(testConfig, by, "First Name ");
		}catch (Exception e) {
			testConfig.logException("First Name box not visible", e, true);
		}
		return element;
	}

	
	public static WebElement lastName(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_last_name']");
		element = Browser.waitForVisibility(testConfig, by, "Last Name ");
		}catch (Exception e) {
			testConfig.logException("Last Name box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement address1(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='billing_address1']");
		element = Browser.waitForVisibility(testConfig, by, "Address1");
		}catch (Exception e) {
			testConfig.logException("Address1 box not visible", e, true);
		}
		return element;
	}

	public static WebElement address2(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='billing_address2']");
		element = Browser.waitForVisibility(testConfig, by, "Address 2");
		}catch (Exception e) {
			testConfig.logException("Address2 box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement address3(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath(".//input[@name='billing_address3']");
		element = Browser.waitForVisibility(testConfig, by, "Address 3 ");
		}catch (Exception e) {
			testConfig.logException("Address3 box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement pincode(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_pincode']");
		element = Browser.waitForVisibility(testConfig, by, "pincode ");
		}catch (Exception e) {
			testConfig.logException("Pincode box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement city(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_city']");
		element = Browser.waitForVisibility(testConfig, by, "Billing city");
		}catch (Exception e) {
			testConfig.logException("Billing City box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement state(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_state']");
		element = Browser.waitForVisibility(testConfig, by, "Billing state ");
		}catch (Exception e) {
			testConfig.logException("Billing state box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement country(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='billing_country']");
		element = Browser.waitForVisibility(testConfig, by, " Billing Country ");
		}catch (Exception e) {
			testConfig.logException("Billing Country box not visible", e, true);
		}
		return element;
	}

	public static WebElement productInfoBar(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//label[.='Product Info:']");
		element = Browser.waitForVisibility(testConfig, by, "Product info bar ");
		}catch (Exception e) {
			testConfig.logException("Product info bar box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement productCode(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='product_code']");
		element = Browser.waitForVisibility(testConfig, by, "Product Code");
		}catch (Exception e) {
			testConfig.logException("Product code box not visible", e, true);
		}
		return element;
	}
	
	public static WebElement productAmount(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//input[@name='product_amount']");
		element = Browser.waitForVisibility(testConfig, by, "Product Amount");
		}catch (Exception e) {
			testConfig.logException("Product Amount box not visible", e, true);
		}
		return element;
	}

	public static WebElement submitButton(Config testConfig) {
		WebElement element = null;
		try{
		By by = By.xpath("//button[@id='submitBtn']");
		element = Browser.waitForVisibility(testConfig, by, "Submit button");
		}catch (Exception e) {
			testConfig.logException("Submit button not visible", e, true);
		}
		return element;
	}
}
