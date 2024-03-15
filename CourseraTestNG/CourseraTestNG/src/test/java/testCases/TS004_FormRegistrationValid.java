package testCases;

import org.testng.annotations.Test;

import pageObjects.Form;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TS004_FormRegistrationValid extends BaseClass {
	public Form f;
	
	@Test(priority=1)
	public void clickEnterprise() {
		hp=new HomePage(driver);
		hp.clickNav2();
		takeScreenshot("EnterPrisePage");
	}
	
	@Test(priority=2)
	public void navigateToFormPage() {
		hp.clickSolutions();
		takeScreenshot("Solutions Option");
		hp.clickForCampus();
		takeScreenshot("ForCampusPage");
		
	   
	}
	
	@Test(priority=3)
	public void fillForm() {
		f=new Form(driver);
		f.scrolltoForm();
		takeScreenshot("form");
		f.setFirstName(randomString());
		f.setLastName(randomString());
		f.setEmail(randomString()+"@cognizant.com");
		f.setPhone(randomNumber());
		f.setInstType();
		f.setInstName(randomString());
		takeScreenshot("Valid FormData1");
		f.setJobRole();
		f.setDepartment();
		f.setDescription();
		f.setNeeds(randomString());
		f.setLearners();
		f.setCountry();
		f.setState();
		f.clickChkBox();
		takeScreenshot("Valid FormData2");
		f.clickSubmit();
		String s=f.getMsg();
		System.out.print("\n*********************Message after submiting Valid data*********************\n"+s);		
	}
	
	
	

}
