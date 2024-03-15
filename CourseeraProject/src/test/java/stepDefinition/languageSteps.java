package stepDefinition;

import java.util.List;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.*;
import utilities.ExcelUtils;


public class languageSteps extends BaseClass {
	List<String> arr;
	List<String> arr2;
	
		@Given("user should be on homepage")
		public void user_should_be_on_homepage() {
			hp=new HomePage(driver);
			hp.clickNav1();
		}
		//To Search for Language learning
		@When("User look for {string}")
		public void user_look_for(String string) {
			logger.info("Searching For Language learning");
			hp.submitSearch(string);
			hp.clickSearchIcon();  
		}
		//Get All Languages
		@When("user extract all languages")
		public void user_extract_all_languages() {
			logger.info("Capturing all  Languages ");
			cp=new CoursesPage(driver);
			arr=cp.getAllLanguage();
			//Store data to Excel
			ExcelUtils.writeToExcel("courseDetails", "languages",arr);
			
		}

		//Get All levels
		@When("user extract all levels")
		public void user_extract_all_levels() {	
			logger.info("Capturing all  Levels ");
			arr2 = cp.getAllLevels(); 
			System.out.println("Total Count Of Levels:-"+arr2.size());
			//Store data to Excel
			ExcelUtils.writeToExcel("courseDetails", "levels",arr2);
		}

		@Then("user display langauge and level information")
		public void user_display_langauge_and_level_information() {
			logger.info("Displaying Language and level details");
			System.out.println("\n*********************All available languages*********************\n");
			System.out.println("Total Count Of Languages:-"+arr.size());
			for(String s:arr) {
				System.out.println(s.substring(0, s.indexOf(" ")));
			}
			
			System.out.println("\n*********************All available levels*********************\n");
			System.out.println("Total Count Of Levels:-"+arr2.size());
			for(String s:arr2) {
				System.out.println(s.substring(0, s.indexOf(" ")));
			}
		   
		}
		
		

}
