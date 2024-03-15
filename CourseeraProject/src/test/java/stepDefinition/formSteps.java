package stepDefinition;

import java.util.HashMap;
import java.util.List;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.Form;
import pageObjects.HomePage;
import utilities.ExcelUtils;

public class formSteps extends BaseClass{
	List<HashMap<String, String>> datamap; 
	HomePage hp;
	public Form f=new Form(driver);
	@Given("user should be on For Enterprise page")
	public void user_should_be_on_for_enterprise_page() {
		
		hp=new HomePage(driver);
		hp.clickNav2();
		takeScreenshot("EnterPrisePage");
	   
	}

	@When("user clicks on solution dropdown")
	public void user_clicks_on_solution_dropdown() {
		
		hp.clickSolutions();
		takeScreenshot("Solutions Option");
	}

	@When("user click on For Campus option")
	public void user_click_on_for_campus_option() {
		hp.clickForCampus();
		takeScreenshot("ForCampusPage");
	   
	}

	@Given("user should scroll down to the form")
	public void user_should_scroll_down_to_the_form() {
		hp=new HomePage(driver);
		hp.clickNav3();
		f.scrolltoForm();
		takeScreenshot("form");
	   
	}

	//data is taken from feature file
	@When("user fills the form with {string},{string},{string},{string},{string},{string},{string}")
	public void user_fills_the_form(String fname,String lname,String email,String phone,String iname,String needs,String status) {
		logger.info(status+" Form Registration");
		f.setFirstName(fname);
		f.setLastName(lname);
		f.setEmail(email);
		f.setPhone(phone);
		f.setInstType();
		f.setInstName(iname);
		takeScreenshot(status+"FormData1");
		f.setJobRole();
		f.setDepartment();
		f.setDescription();
		f.setNeeds(needs);
		f.setLearners();
		f.setCountry();
		f.setState();
		f.clickChkBox();
		takeScreenshot(status+"FormData2");
		
	}
	
	
	//data is taken from excel file
	@When("user fills the form with excel data {string}")
	public void user_fills_the_form_with_excel_data(String rows) {
		 datamap=ExcelUtils.data(System.getProperty("user.dir")+"\\testData\\data.xlsx", "Sheet1");
		 int index=Integer.parseInt(rows)-1;
		 datamap.get(index).get("username");
		 f.setFirstName(datamap.get(index).get("fname"));
			f.setLastName(datamap.get(index).get("lname"));
			f.setEmail(datamap.get(index).get("email"));
			f.setPhone("9898989898");
			f.setInstType();
			f.setInstName(datamap.get(index).get("iname"));
			f.setJobRole();
			f.setDepartment();
			f.setDescription();
			f.setNeeds(datamap.get(index).get("needs"));
			f.setLearners();
			f.setCountry();
			f.setState();
			f.clickChkBox();
			
		 
	}

	@When("user submits the form")
	public void user_submits_the_form() {
		f.clickSubmit();  
	}

	@Then("user should capture correct {string} message")
	public void user_should_capture_correct_message(String str) {
		 
		logger.info("Capturing Message");
		System.out.print("\n*********************Message after submiting "+str+" data*********************\n");
		String s=f.getMsg();
		takeScreenshot(str+"Message");
		System.out.print(s);
		
	    
	}
	
	@Then("user should capture {string} message after form submission")
	public void user_should_capture_message_after_form_submission(String rows) {
		int index=Integer.parseInt(rows)-1;
		String str=datamap.get(index).get("status");
		logger.info("Capturing Message");
		System.out.print("\n*********************Message after submiting "+str+" data*********************\n");
		String s=f.getMsg();
		takeScreenshot(str+"Message");
		System.out.print(s);
		
	    
	}
	
	
	
	
	

}
