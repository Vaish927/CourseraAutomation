package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CourseDetailsPage;
import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TS006_Reg extends BaseClass {
	
	@Test(priority=3)
	public void verifyCourseraHomepage() {
		hp=new HomePage(driver);
		hp.clickNav1();
	    String s=driver.getTitle();
	    Assert.assertEquals(s, "Coursera | Degrees, Certificates, & Free Online Courses");	
	}
	
	@Test(priority=5)
	@Parameters({"browser"})
	public void verifySearch(String s) {
		hp=new HomePage(driver);
		hp.submitSearch(s);
		hp.clickSearchIcon();	
	}
	
	@Test(priority=6)
	public void verifyResults() {
		cp=new CoursesPage(driver);
	    boolean flag=cp.checkResults();
	    Assert.assertEquals(flag, false);
		
	}
	
	@Test(priority=8)
	public void verifyLanguageOptions() {
		
		cp=new CoursesPage(driver);
		//cp.selectLanguage();
	    boolean flag=cp.getAllLanguage().size()>0; 
	    Assert.assertEquals(flag,true);
		
	}
	@Test(priority=9)
	public void verifyLevelOptions() {
		 cp.selectLevel();
		 boolean flag=cp.checkChkBox();
		 Assert.assertEquals(flag, true);
	}
	
	@Test
	public void verifyLevelFilter() {
		String str=cp.checkLevelFilter();
		boolean flag=str.contains("English");
		System.out.println(flag);
		Assert.assertEquals(flag,true);
	}
	
	@Test
	public void verifyCourse(){
		cp.clickCourse();
		 cdp=new CourseDetailsPage(driver);
		    cdp.switchToWindow(1);
		    cdp.getHeading();


	}
	
	
}
