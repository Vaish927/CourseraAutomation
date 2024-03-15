package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtils;

public class TS003_LanguageLearning  extends BaseClass{
	List<String> arr;
	List<String> arr2;
	
	@Test(priority=1)
	public void navigateToHomepage() {
		hp=new HomePage(driver);
		hp.clickNav1();
		hp.submitSearch("language Learning");
		hp.clickSearchIcon();  
	}
	
	@Test(priority=2)
	public void captureAllLanguage() {
		cp=new CoursesPage(driver);
		arr=cp.getAllLanguage();
		arr2 = cp.getAllLevels(); 
		
		//Writing Data to Excel
		ExcelUtils.writeToExcel("courseDetails", "languages",arr);
	}
	
	@Test(priority=3)
	public void getAlllevels() {
		arr2 = cp.getAllLevels(); 
		
		//Writing Data to Excel
		ExcelUtils.writeToExcel("courseDetails", "levels",arr2);
	}
	
	@Test(priority=4)
	public void displayLanguagesLevels() {
		
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
