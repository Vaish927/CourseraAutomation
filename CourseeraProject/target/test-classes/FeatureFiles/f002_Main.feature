Feature: MainFeatureFile

  Scenario: Search For Courses
    Given user should be on courseera homepage
    When user search for "Web Development" courses
    And user clicks on show more link
    And user select English language
    And user select beginners level
    Then user should click on top two courses

  Scenario: Capture Course Details
    Given user should be on first course page
    When user capture the first course details
    Then display the first course details
    Given user should be on second course page
    When user capture the second course details
    Then display the second course details

  Scenario: Language Learning
    Given user should be on homepage
    When User look for "Language Learning"
    And user clicks on show more link
    And user extract all languages
    And user extract all levels
    Then user display langauge and level information

  Scenario: Navigate to form
    Given user should be on For Enterprise page
    When user clicks on solution dropdown
    And user click on For Campus option

  Scenario Outline: Fill The Form
    Given user should scroll down to the form
    When user fills the form with excel data "<rowInd>"
    And user submits the form
    Then user should capture "<rowInd>" message after form submission
    
    
    Examples: 
      | rowInd  | 
      | 1				|
      |	2				|
      
      
   # Examples: 
   #   | fname | lname | email              | phone      | InstName | needs | status  |
   #   | test  | test  | test@cognizant.com | 9876545321 | test     | test  | valid   |
   #   | test1 | test1 | test1              | 7987898765 | test1    | test1 | invalid |
