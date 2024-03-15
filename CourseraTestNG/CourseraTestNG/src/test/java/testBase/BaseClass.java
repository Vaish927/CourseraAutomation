package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.CourseDetailsPage;
import pageObjects.CoursesPage;
import pageObjects.HomePage;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
	public  HomePage hp;
	public  CoursesPage cp;
	public  CourseDetailsPage cdp;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setupDriver(String br) {
		logger=LogManager.getLogger(br);
		FileReader file;
		try {
			file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");	
			p=new Properties();
			p.load(file);
	}
		catch (IOException e) {
		
		}
		//To set the execution environment
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				logger.info("Setting up the remote environment");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				if (p.getProperty("os").equalsIgnoreCase("windows")) {
					   capabilities.setPlatform(Platform.WIN11);
				} else if (p.getProperty("os").equalsIgnoreCase("mac")) {
					    capabilities.setPlatform(Platform.MAC);
				} else {
					    System.out.println("No matching OS..");
				}
					
				//To set the browser
				if(br.equals("Chrome"))
						capabilities.setBrowserName("chrome");
						
				else if(br.equals("Edge"))
						capabilities.setBrowserName("MicrodoftEdge");
				else
						System.out.println("No matching Browser...");
					
				try {
						driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				} catch (MalformedURLException e) {}
						
					
				}
					
				else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
				{
					logger.info("Setting up the local environment");
					switch(br.toLowerCase()) 
					{
					case "chrome":
				        driver=new ChromeDriver();
				        break;
				    case "edge":
				    	driver=new EdgeDriver();
				        break;
				    default:
				        System.out.println("No matching browser");
				        driver=null;
					}
				}
		
			 driver.manage().deleteAllCookies(); 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 driver.manage().window().maximize();
			 driver.get("https://coursera.org"); 
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public String takeScreenshot(String name) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+name +".png";
	File target=new File(targetFilePath);
	try {
		FileUtils.copyFile(src, target);
	} catch (IOException e) {}
	return targetFilePath;	
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
}
