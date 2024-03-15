package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.CourseDetailsPage;
import testBase.BaseClass;
import utilities.ExcelUtils;

public class TS002_CourseDetails extends BaseClass {
	String courseName;
	String courseRating;
	String courseDuration;
	ExcelUtils eu=new ExcelUtils();
	
	List<String> arr1=new ArrayList<>();
	List<String> arr2=new ArrayList<>();
	
	@Test(priority=1)
	public void gotoFirstCourse() {
		cdp=new CourseDetailsPage(driver);
		cdp.switchToWindow(1);
	}
	
	@Test(priority=2)
	public void captureFirstCourseDetails() {
		courseName=cdp.getCourseName();
		courseRating=cdp.getCourseRatings();
		courseDuration=cdp.getCourseDuration();
		arr1.add(courseName);
		arr1.add(courseRating);
		arr1.add(courseDuration);
		try {
			ExcelUtils.writeToExcel("courseDetails","courses", 1, arr1);
		} catch (IOException e) {}
		takeScreenshot("Course1");
	}
	
	@Test(priority=3)
	public void displayfirstCourse() {
		System.out.println("\n*******************Printing First Course Details*******************\n");
		System.out.println("Course Name:- "+courseName);
		System.out.println("Course Ratings:- "+courseRating);
		System.out.println("Course Duration:- "+courseDuration);	
	}
	
	@Test(priority=4)
	public void gotoSecondCourse() {
		cdp.switchToWindow(2);
	}
	@Test(priority=5)
	public void captureSecondCourseDetails() {
		courseName=cdp.getCourseName();
		courseRating=cdp.getCourseRatings();
		courseDuration=cdp.getCourseDuration();
		arr2.add(courseName);
		arr2.add(courseRating);
		arr2.add(courseDuration);
		takeScreenshot("Course2");
		try {
			ExcelUtils.writeToExcel("courseDetails","courses", 2, arr2);
		} catch (IOException e) {}
			
	}
	
	@Test(priority=6)
	public void displaySecondCourse() {
		System.out.println("\n*******************Printing Second Course Details*******************\n");
		System.out.println("Course Name:- "+courseName);
		System.out.println("Course Ratings:- "+courseRating);
		System.out.println("Course Duration:- "+courseDuration);	
		
		
	
	}


}
