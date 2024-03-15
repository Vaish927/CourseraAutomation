//This File  runs as JUNIT Test
package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {".\\src\\test\\resources\\FeatureFiles\\f002_Main.feature"},
				//features={"@target/rerun.txt"},
				glue = "stepDefinition", 
				plugin = 	{ "pretty",
							"html:reports/myreport.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"rerun:target/rerun.txt"}, 
				dryRun = false, 
				monochrome = true, 
				publish = true)
				//tags="@Sanity")


public class TestRun{

}
