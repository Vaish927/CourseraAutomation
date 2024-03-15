Hackathon Idea:Identify Courses

This Project aims  to automate identifying courses based on categories selected such as language and level.

Detailed Desciption:
1. Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses
2. Look for Language Learning; Extract all the languages and different levels with its total count & display them
3. In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid 

Automation Scope
	The automation script should cover the following key aspects:
		1.Handling different browser windows, search option
		2.Navigating back to home page
		3.Filling form (in different objects in web page)
		4.Capture warning message
		5.Scrolling down in web page
		6.Page Object Model

IDE Used
	✅ Eclipse IDE for Enterprise Java and Web Developers 2023

Technology Stack:
		1.Selenium
		2.TestNG 
		3.Cucumber
		4.Apache POI
		5.ExtenReports
		6.Selenium Grid
		5.Jenkins

Pre-requisites
		1.	TestNG (can be installed from Eclipse Marketplace)
		2.	Cucumber (can be installed from Eclipse Marketplace)



Steps to reproduce
		1.	In the project directory, To run as a Cucumber, a testRunner named package is present and TestRun class is  present .
		2.	Right-click the file and Run As -> Junit Test. The sequence of the test pages will execute accordingly or directly run by feature 		file by right click and run as a cucumber.
		3.	In the project directory, To run as a Testng a xml files named TestNG.xml is present.
		4.	Right-click the file and Run As -> TestNG Suite. The sequence of the test pages will execute accordingly.
		5.	From there, after the execution, you can view the Extent Report from TestngReport -> Test-report-2024.02.29.html-> Right click view 		as system editor
		6.	For cucumber Extentreport, after the execution, you can view the report from Test-output-> SparkReport  -> Report->				CucumberExtentReport->Right click view as system editor

OutPut:
*******************Printing First Course Details*******************

Course Name:- IBM Full Stack Software Developer Professional Certificate
Course Ratings:- 4.5
Course Duration:- 4 months at 10 hours a week

*******************Printing Second Course Details*******************

Course Name:- Meta Front-End Developer Professional Certificate
Course Ratings:- 4.7
Course Duration:- 7 months at 6 hours a week

*********************All available languages*********************

Total Count Of Languages:-24
English
Spanish
Arabic
French
Chinese
Portuguese
German
Indonesian
Hindi
Italian
Swedish
Dutch
Greek
Polish
Thai
Turkish
Ukrainian
Russian
Kazakh
Hungarian
Japanese
Korean
Chinese
Hebrew
*********************All available levels*********************

Total Count Of Levels:-4
Beginner
Intermediate
Advanced
Mixed

*********************Message after submiting valid data*********************
Thank you for your interest in Coursera for Campus

*********************Message after submiting invalid data*********************
Must be valid email.
example@yourdomain.com 
