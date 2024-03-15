package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CourseDetailsPage;
import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TS001_SearchCourse extends BaseClass{
	public  HomePage hp;
	public  CoursesPage cp;
	public  CourseDetailsPage cdp;
	
	@Test(priority=1)
	@Parameters({"Course"})
	public void SearchCourse(String s) {
		hp=new HomePage(driver);
		hp.clickNav1();
		hp.submitSearch(s);
		hp.clickSearchIcon();
	}
	
	@Test(priority=2)
	public void addFilters() {
		cp=new CoursesPage(driver);
		//cp.selectLanguage();
		takeScreenshot("SelectLanguage");
		cp.selectLevel();
		takeScreenshot("SelectLevel");  
		
	}
	@Test(priority=3)
	public void clickTopTwoCourses() {
		cp.selectCourse();
	}

}
