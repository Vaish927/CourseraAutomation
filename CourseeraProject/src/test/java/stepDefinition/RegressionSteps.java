package stepDefinition;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.CourseDetailsPage;
import pageObjects.CoursesPage;
import pageObjects.HomePage;

public class RegressionSteps extends BaseClass{
	

	@When("user clicks on Show more link")
	public void user_clicks_on_show_more_link() {
	    cp=new CoursesPage(driver);
	    cp.clickShowMore();
	    
	}

	@When("user select language English.")
	public void user_select_language_english() {
		cp=new CoursesPage(driver);
		cp.selectLanguage();
	   
	}

	@Then("user verifies English filter displayed at Top")
	public void user_verifies_english_filter_displayed_at_top() {
		String str=cp.checkLevelFilter();
		boolean flag=str.contains("English");
		System.out.println(flag);
		Assert.assertEquals(flag,true);
	}

	@When("user select level as Beginner")
	public void user_select_level_as_Beginner() {
		cp=new CoursesPage(driver);
		cp.selectLevel();
		
	}

	@Then("user verifies Beginner filter displayed at Top")
	public void user_verifies_filter_displayed_at_top() {
		String str=cp.checkLevelFilter();
		boolean flag=str.contains("Beginner");
		System.out.println(flag);
		Assert.assertEquals(flag,true);
	   
	}

	
	@When("user sees all available courses")
	public void user_sees_all_available_courses() {
		cp=new CoursesPage(driver);
	    boolean flag=cp.checkResults();
	    Assert.assertEquals(flag, false);
	    
	}

	@When("user clicks on the course")
	public void user_clicks_on_the_course() {
		cp.clickCourse();


	}

	@Then("user should get the coursedetails.")
	public void user_should_get_the_coursedetails() {
		
	    cdp=new CourseDetailsPage(driver);
	    cdp.switchToWindow(1);
	    cdp.getHeading();
	    
	}

	@Given("user should navigate to form page")
	public void user_should_navigate_to_form_page() {
	    hp=new HomePage(driver);
	    hp.clickNav3();
	}

}
