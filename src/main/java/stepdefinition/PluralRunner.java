package stepdefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.jayway.restassured.response.Response;

import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.APIHelper;
import helper.Browser;
import helper.Element;
import pom.OrderDetailPage;
import pom.PluralPage;
import utils.BaseRunnerConfig;
import utils.GlobalConfigManager;



@CucumberOptions(features = {"src/test/resources/features/"}, tags = {"@TC-01"}, glue = {"stepdefinition"},
        monochrome = true, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport1.json",
				"rerun:target/cucumber-reports/rerun.txt" })


public class PluralRunner extends BaseRunnerConfig{

	@Inject
	private GlobalConfigManager configManager;
	private helper.Config testConfig;

	public static String Host = null;
    static Map<String, String> parameters = null;
    static Map<String, String> headers = null;
    static List<String> movieTitles;
    static WebDriver driver;
	
	@Given("^I want to set API host \"([^\"]*)\"$")
    public void i_want_to_set_api_host(String host) throws Throwable {
	   testConfig = configManager.testConfig;
       Host = host;
       testConfig.logComment("host successfully set :"+Host);
    }
	
	@Then("^I want to set API parameter with host$")
	public void i_want_to_set_API_parameter_with_host(DataTable dataTable) throws Throwable {
		testConfig = configManager.testConfig;
		List<Map<String, String>> listOfMap = dataTable.asMaps(String.class, String.class);
		parameters = new HashMap<>();
		for(int i = 0 ; i < listOfMap.size(); i ++) {
			parameters.put(listOfMap.get(i).get("parameter"), listOfMap.get(i).get("value"));
			testConfig.logComment("Parameters Set :" +listOfMap.get(i).get("parameter")+ "=" +listOfMap.get(i).get("value"));
		}
	   
	}

	@Then("^Filter titles from response for all movie$")
	public void filter_titles_from_response_for_all_movie() throws Throwable {
		testConfig = configManager.testConfig;
	   Response resp = APIHelper.executeGet(Host, headers, parameters);
	   movieTitles = resp.jsonPath().getList("Search.Title");
	   System.out.println(movieTitles);
	
	}

	
	@Then("^Navigate to \"([^\"]*)\" page$")
    public void navigate_to_page(String url) throws Throwable {
		testConfig = configManager.testConfig;
		Browser.navigateToURL(testConfig, url);
		
	}
	
    @Then("^Click on play with plural for 3rd prodcut$")
    public void click_on_play_with_plural_for_3rd_prodcut() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.clickThroughJS(testConfig, PluralPage.playWithPlural(testConfig), "click on play with plural button");
    }
	
    @Then("^Enter merchant data with below details$")
    public void enter_merchant_data_with_below_details(DataTable dataTable ) throws Throwable {
    	testConfig = configManager.testConfig;
    	Map<String, String> merchantData = dataTable.asMaps(String.class, String.class).get(0);
    	Element.enterData(testConfig, OrderDetailPage.merchantId(testConfig), merchantData.get("merchantId"), "Merchant ID");
    	Element.enterData(testConfig, OrderDetailPage.merchantAccessCode(testConfig), merchantData.get("merchantAccessCode"), "Merchant Access Code");
    	Element.enterData(testConfig, OrderDetailPage.merchantReturnUrl(testConfig), merchantData.get("merchantReturnUrl"), "Merchant Return Url");
    }
    
    @Then("^Click on payment info bar$")
    public void click_on_payment_info_bar() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.click(testConfig, OrderDetailPage.paymentInfoUrl(testConfig), "Payment Info Bar");
    }
    
    @And("^Enter amount info with below details$")
    public void enter_amount_info_with_below_details(DataTable dataTable) throws Throwable {
    	testConfig = configManager.testConfig;
    	Map<String, String> paymentData = dataTable.asMaps(String.class, String.class).get(0);
    	Element.enterData(testConfig, OrderDetailPage.amount(testConfig), paymentData.get("amount"), "Amount");
    	Element.enterData(testConfig, OrderDetailPage.currencyCode(testConfig), paymentData.get("currencyCode"), "Currency code");
    	Element.enterData(testConfig, OrderDetailPage.orderDescription(testConfig), paymentData.get("orderDescription"), "Order description");
    }

    @Then("^Click on customer info bar$")
    public void click_on_customer_info_bar() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.click(testConfig, OrderDetailPage.customerInfoBar(testConfig), "Customer Info Bar");
    }
    
    @And("^Enter customer info with below details$")
    public void enter_customer_info_with_below_details(DataTable dataTable) throws Throwable {
    	testConfig = configManager.testConfig;
    	Map<String, String> customerData = dataTable.asMaps(String.class, String.class).get(0);
    	Element.enterData(testConfig, OrderDetailPage.emailId(testConfig), customerData.get("email"), "Email ID");
    	Element.enterData(testConfig, OrderDetailPage.mobileNumber(testConfig), customerData.get("mobileNumber"), "Mobile Number");
    }
    
    @Then("^Click on billing address info bar$")
    public void click_on_billing_address_info_bar() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.click(testConfig, OrderDetailPage.billingAddressBar(testConfig), "Billing Address Info Bar");
    }
    
    @And("^Enter billing address info with below details$")
    public void enter_billing_address_info_with_below_details(DataTable dataTable) throws Throwable {
    	testConfig = configManager.testConfig;
    	Map<String, String> billingData = dataTable.asMaps(String.class, String.class).get(0);
    	Element.enterData(testConfig, OrderDetailPage.firstName(testConfig), billingData.get("firstName"), "firstName");
    	Element.enterData(testConfig, OrderDetailPage.lastName(testConfig), billingData.get("lastName"), "lastName");
    	Element.enterData(testConfig, OrderDetailPage.address1(testConfig), billingData.get("address1"), "address1");
    	Element.enterData(testConfig, OrderDetailPage.address2(testConfig), billingData.get("address2"), "address2");
    	Element.enterData(testConfig, OrderDetailPage.address3(testConfig), billingData.get("address3"), "address3");
    	Element.enterData(testConfig, OrderDetailPage.pincode(testConfig), billingData.get("pincode"), "pincode");
    	Element.enterData(testConfig, OrderDetailPage.city(testConfig), billingData.get("city"), "city");
    	Element.enterData(testConfig, OrderDetailPage.state(testConfig), billingData.get("state"), "state");
    	Element.enterData(testConfig, OrderDetailPage.country(testConfig), billingData.get("country"), "country");
    }
    
    
    @Then("^Click on product info bar$")
    public void click_on_product_info_bar() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.click(testConfig, OrderDetailPage.productInfoBar(testConfig), "Product Info Bar");
    }
    
    @And("^Enter product info with below details$")
    public void enter_product_info_with_below_details(DataTable dataTable) throws Throwable {
    	testConfig = configManager.testConfig;
    	Map<String, String> productData = dataTable.asMaps(String.class, String.class).get(0);
    	Element.enterData(testConfig, OrderDetailPage.productCode(testConfig), productData.get("productCode"), "productCode");
    	Element.enterData(testConfig, OrderDetailPage.productAmount(testConfig), productData.get("productAmount"), "productAmount");
    }
    
    @And("^Click on submit button$")
    public void click_on_submit_button() throws Throwable {
    	testConfig = configManager.testConfig;
    	Element.click(testConfig, OrderDetailPage.submitButton(testConfig), "Click on submit button");
    	Browser.wait(testConfig, 120);
    }
}
