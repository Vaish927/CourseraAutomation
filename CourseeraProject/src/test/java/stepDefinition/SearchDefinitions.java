package stepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.*;

public class SearchDefinitions extends BaseClass{
	HomePage hp;
	CoursesPage cp;
	CourseDetailsPage cdp;
    
	@Given("user should be on courseera homepage")
	public void user_should_be_on_courseera_homepage() {
		logger.info("Searching For Web Development Course");
		driver.get("https://www.coursera.org");
		takeScreenshot("HomePage");	 
	}
	
	//To Search For WebDevelopment Course
	@When("user search for {string} courses")
	public void user_search_for_courses(String string) {
		hp=new HomePage(driver);
		hp.submitSearch(string);
		takeScreenshot("SearchQuery");
		hp.clickSearchIcon();
	}
	
	//To Select English language
	@When("user select English language")
	public void user_select_english_language() {
		logger.info("Applying Language Filter");
		cp=new CoursesPage(driver);
		cp.selectLanguage();
		takeScreenshot("SelectLanguage");
	   
	}
	
	//To Select Beginner Level
	@When("user select beginners level")
	public void user_select_beginners_level() {
		logger.info("Applying Level Filter");
		cp.selectLevel();
		takeScreenshot("SelectLevel");  
	}

	//Clicking on First Two Courses
	@Then("user should click on top two courses")
	public void user_should_click_on_top_two_courses() {
		cp.selectCourse();
		
	}


}