@Regression
Feature: Regression Feature

	@Regression @Sanity
  Scenario: Validate Search Functionality
	Given user should be on courssera homepage
	When user search for "Web Development" course
	Then user should see all courses.
	
	@Regression
	Scenario: Validate Language Filters
	Given user should be on courssera homepage
	When user search for "Web Development" course
	And user clicks on show more link
	And user select language English.
	Then user verifies English filter displayed at Top
	
	@Regression
	Scenario: Validate Level Filters
	Given user should be on courssera homepage
	When user search for "Web Development" course
	And user select level as Beginner 
	Then user verifies Beginner filter displayed at Top	
	
	@Regression @Sanity
	Scenario: Validate Course Details
	Given user should be on courssera homepage
	When user search for "Web Development" course
	And  user sees all available courses
	And user clicks on the course
	Then user should get the coursedetails.
	
	
	@Regression @Sanity
	Scenario: Validate Form Registration
	Given user should navigate to form page
	When user fills the form with "<fname>","<lname>","<email>","<phone>","<InstName>","<needs>","<status>"
	And user submits the form
	Then user should capture correct "<status>" message
	
	 Examples: 
      | fname | lname | email              | phone      | InstName | needs | status  |
      | 		  | test  | test@cognizant.com | 9876545321 | test     | test  | invalid |
			|	test1 | 			| test1							 | 7987898765	| test1		 | test1 | invalid |
			|	test1 | test1	| test@cognizant.com | 						| test1		 | test1 | invalid |
			|	test1 | test1	| test@cognizant.com | 7656789213	| 				 | test1 | invalid |
			
			