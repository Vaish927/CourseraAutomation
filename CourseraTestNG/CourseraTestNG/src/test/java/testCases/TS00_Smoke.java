package testCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TS00_Smoke extends BaseClass {
	
	@Test(priority=0)
	public void  launchBrowser() {
		String s=driver.toString();
		boolean flag=false;
		if(s!="")
			flag=true;
			
		Assert.assertEquals(flag, true);
	}

	@Test(priority=1)
	public void navigateURL() {
		driver.get(p.getProperty("baseUrl"));
	}
	
	@Test(priority=2)
	public void verifypPageLoad() {
		hp=new HomePage(driver);
		boolean flag=hp.pageLoaded();
		Assert.assertEquals(flag, true);
		
		
	}
	@Test(priority=3)
	public void verifyCourseraHomepage() {
		//hp=new HomePage(driver);
		hp.clickNav1();
	    String s=driver.getTitle();
	    Assert.assertEquals(s, p.getProperty("HomeTitle"));	
	}
	
	
	@Test(priority=4)
	public void isSearchBoxDisplayed() {
		//hp=new HomePage(driver);
		boolean flag=hp.searchBoxDisplay();
		Assert.assertEquals(flag, true);
		
	}
	
	
	
	@Test(priority=5)
	
	public void verifySearch() {
		//=new HomePage(driver);
		String s=p.getProperty("Course1");
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
		
		//cp=new CoursesPage(driver);
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
	
	
	@Test(priority=10)
	public void verifyIndividualLink() {
		hp.clickNav1();
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("HomeTitle"));	
		
		
	}
	
	@Test(priority=11)
	public void verifyBuisenessLink() {
		hp.clickNav2();
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("BuisenessTitle"));	
		
	}
	@Test(priority=12)
	public void verifyUniversitiesLink() {
		hp.clickNav3();
		String s=driver.getTitle();
	    Assert.assertEquals(s, p.getProperty("UniversityTitle"));
		
	}
	
	@Test(priority=13)
	public void verifySolutionOptions() {
		hp.clickSolutions();
		boolean flag=hp.solutionDisplay();
		hp.clickSolutions();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=14)
	public void verifySolutionsLink() {
		//hp=new HomePage(driver);
		hp.clickNav2();
		hp.clickSolutions();
		
	}
	
	
	@Test(priority=15,dependsOnMethods={"verifySolutionsLink"})
	public void verifyForCampusLink() {
		 hp.clickForCampus();
		 String s=driver.getTitle();
		 Assert.assertEquals(s, p.getProperty("UniversityTitle"));
		
	}
}
