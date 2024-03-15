package stepDefinition;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CoursesPage;
import pageObjects.HomePage;

public class smokeSteps extends BaseClass{
	HomePage hp;
	CoursesPage cp;
	
	//launch the browser
	@Given("user should launch the browser")
	public void user_should_launch_the_browser() {
		
		cp=new CoursesPage(driver);
		String s=driver.toString();
		boolean flag=false;
		if(s!="")
			flag=true;
			
		Assert.assertEquals(flag, true);
	  
	}
	
	//To navigate to url
	@When("user navigates to url")
	public void user_navigates_to_url() {

		driver.get("https://www.coursera.org/");
		 	
	}

	@Then("Web page should load")
	public void web_page_should_load() {
		hp=new HomePage(driver);
		boolean flag=hp.pageLoaded();
		Assert.assertEquals(flag, true);
	}

	@Then("search box should displayed")
	public void search_box_should_displayed() {
		logger.info("Validating Search Box");
		hp=new HomePage(driver);
		boolean flag=hp.searchBoxDisplay();
		Assert.assertEquals(flag, true);
	}

	@Given("user should be on courssera homepage")
	public void user_should_be_on_courssera_homepage() {
		hp=new HomePage(driver);
		hp.clickNav1();
	    String s=driver.getTitle();
	    Assert.assertEquals(s, p.getProperty("HomeTitle"));
	}

	@When("user search for {string} course")
	public void user_search_for_course(String string) {
		hp=new HomePage(driver);
		hp.submitSearch(string);
		hp.clickSearchIcon();
	}

	@Then("user should see all courses.")
	public void user_should_see_all_courses() {
		logger.info("Validating Search Icon");
		cp=new CoursesPage(driver);
	    boolean flag=cp.checkResults();
	    Assert.assertEquals(flag, false);
	}

	@When("user clicks on for individual link")
	public void user_clicks_on_for_individual_link() {
		logger.info("Validating Navigation links");
		hp=new HomePage(driver);
		hp.clickNav1();
	}

	@Then("user should see courseera homepage")
	public void user_should_see_courseera_homepage() {
		hp.clickNav1();
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("HomeTitle"));	
	}

	@When("user clicks on for buiseness link")
	public void user_clicks_on_for_buiseness_link() {
		hp=new HomePage(driver);
		hp.clickNav2();
	}

	@Then("user should see buiseness page.")
	public void user_should_see_buiseness_page() {
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("BuisenessTitle"));
	}

	@When("user clicks on for universities link")
	public void user_clicks_on_for_universities_link() {
		hp=new HomePage(driver);
	    hp.clickNav3();
	}

	@Then("user should see for campus page")
	public void user_should_see_for_campus_page() {
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("UniversityTitle"));
	   
	}
	@Given("user should see all the courses")
	public void user_should_see_all_the_courses() {
		cp=new CoursesPage(driver);
	    boolean flag=cp.checkResults();
	    Assert.assertEquals(flag, false);
	   
	}

	@When("user clicks on show more link")
	public void user_clicks_on_show_more_link() {
		cp=new CoursesPage(driver);
		cp.clickShowMore();
	   
	}
	@Then("user should see all available language options")
	public void user_should_see_all_available_language_options() {
		cp=new CoursesPage(driver);
	    boolean flag=cp.getAllLanguage().size()>0;
	   
	    Assert.assertEquals(flag,true);
	}

	@When("user clicks on Beginner level")
	public void user_clicks_on_beginner_level() {
		cp=new CoursesPage(driver);
	    cp.selectLevel();
	}

	@Then("checkbox should be selected.")
	public void checkbox_should_be_selected() {
		boolean flag=cp.checkChkBox();
		Assert.assertEquals(flag, true);
	    
	}


	@Given("user should see buieness page")
	public void user_should_see_buieness_page() {
		hp=new HomePage(driver);
		hp.clickNav2();
		String s=driver.getTitle();
		Assert.assertEquals(s, p.getProperty("BuisenessTitle"));
	    
	}

	@Then("user should see  solutions options")
	public void user_should_see_solutions_options() {
		hp=new HomePage(driver);
	    boolean flag=hp.solutionDisplay();
	    hp.clickSolutions();
	    Assert.assertEquals(flag, true);
	}

	@Given("user should click on solution dropdown")
	public void user_should_click_on_solution_dropdown() {
		hp=new HomePage(driver);
		hp.clickSolutions();
	}
	
	@When("user clicks on the solution dropdown")
	public void user_clicks_on_the_solution_dropdown() {
		hp.clickSolutions();
	}
	@When("user clicks on For Campus option")
	public void user_clicks_on_for_campus_option() {
	    hp.clickForCampus();
	}
	
	
	



}
