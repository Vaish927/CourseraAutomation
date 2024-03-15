package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	@BeforeAll
	public static void setup() {
		
		driver=BaseClass.setupDriver();
		driver.get("https://www.coursera.org");
		
	}
	@AfterStep
	public void Screenshot(Scenario scenario) {
		if (!scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", (scenario).getName());
		}
	}
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}
