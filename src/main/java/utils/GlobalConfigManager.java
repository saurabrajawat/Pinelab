package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.runtime.java.guice.ScenarioScoped;
import helper.Config;

@ScenarioScoped
public class GlobalConfigManager {

	protected static ThreadLocal<Config[]> threadLocalConfig = new ThreadLocal<Config[]>();
	String localConfigPath;
	public Config testConfig;
	

	@Inject
	public void loadConfigInlocalThread() {
		localConfigPath = System.getProperty("user.dir") + File.separator + "src/test/resources/Config/config.properties";
		//localConfigPath = "src/test/resources/Config/config.properties";
		testConfig = new Config(localConfigPath);
		threadLocalConfig.set(new Config[] { testConfig });

	}
	
	public static boolean suiteType(Config testConfig , Scenario scenario) {
		boolean status = false;
		List<String> tags = new ArrayList<String>(scenario.getSourceTagNames());
	     for(int i = 0; i < tags.size(); i++) {
	    	if(tags.get(i).contains("Frontend")) {
	    		System.out.println(tags.get(i));
	    		return true;
	    	}
	     }
		return status;
	}
}
