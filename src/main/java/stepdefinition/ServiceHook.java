package stepdefinition;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.Config;
import helper.Helper;
import utils.BaseRunnerConfig;
import utils.GlobalConfigManager;

public class ServiceHook  extends BaseRunnerConfig{

	protected static ThreadLocal<Config[]> threadLocalConfig = new ThreadLocal<Config[]>();

	@Inject
	private GlobalConfigManager configManager;
	public static Config testConfig;
	static String projectName;

	static boolean status = true;
	static String executionStartTime = "";
	long startTime = 0l;
    static boolean yamlLoadStatus = true;
    
	@Before
	public void initializeTest(Scenario scenario) {
		testConfig=configManager.testConfig;
		startTime = System.nanoTime();
		testConfig.testScenario=scenario;
		testConfig.scenarioName=scenario.getName();
		testConfig.putRunTimeProperty("beforeHook", "true");

		if(System.getProperty("LogPageInfo") != null && !System.getProperty("LogPageInfo").equals(""))
			testConfig.putRunTimeProperty("LogPageInfo", System.getProperty("LogPageInfo"));
		
		// Check execution suite type
		if(GlobalConfigManager.suiteType(testConfig, scenario)) {
			testConfig.openBrowser();
		}
		testConfig.putRunTimeProperty("beforeHook", "false");
	
		
	}

	@After
	public void endTest(Scenario scenario) {
		try {
			testConfig.logComment(" Scenario status :  " + scenario.isFailed());
			testConfig.logComment(" isFailScenarioStatus flag status :  " + testConfig.isFailScenarioStatus);
			if (scenario.isFailed() || testConfig.isFailScenarioStatus) {
				testConfig.logComment(scenario.getName() + " is Failed");
				// Check execution Suite Type
				if (GlobalConfigManager.suiteType(testConfig, scenario)) {
					scenario.embed(((TakesScreenshot) testConfig.driver).getScreenshotAs(OutputType.BYTES),"image/png");
					testConfig.closeBrowser();
				}
				Helper.failTestScenario(testConfig, scenario.getName() + " is Failed");
			} else {
				testConfig.logComment(scenario.getName() + " is pass");
				//scenario.embed(((TakesScreenshot) testConfig.driver).getScreenshotAs(OutputType.BYTES), "image/png");
				testConfig.closeBrowser();
			}
		} catch (Exception e) {
			testConfig.closeBrowser();
			testConfig.logFailureException(e);
		}
	}
}
