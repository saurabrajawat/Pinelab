package stepdefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.inject.Inject;
import com.jayway.restassured.response.Response;

import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.APIHelper;
import helper.Browser;
import helper.Helper;
import pom.IMDbPage;
import utils.BaseDriver;
import utils.BaseRunnerConfig;
import utils.GlobalConfigManager;



@CucumberOptions(features = {"src/test/resources/features/assignment.feature"}, glue = {"stepdefinition"},
        monochrome = true, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport1.json",
				"rerun:target/cucumber-reports/rerun.txt" })


public class AssignmentRunner extends BaseRunnerConfig{

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
	
}
