Feature: Orange HRM activities


  @TestOrange
  Scenario: Create a job vacancy
    Given User login to orange HRM job portal
    And navigates to vacancies menu option
    And User creates a new vacancy
    
    @TestOrange
  Scenario: Add a candidate for recruitment
    Given User login to orange HRM job portal
    And Adds a candidate for recruitment
    Then Verify candidate details are added
    
    @TestOrange
  Scenario Outline: Add multiple employees
    Given User login to orange HRM job portal
    And User add employee details with "<FirstName>" and "<LastName>"
   # And navigates to add employee <"FirstName"> and <"LastName">
    Then Verify employee details "<FirstName>" are added
   
   Examples:
	|FirstName|LastName|
	|AA1Test123|Automation|
	|AA1Test2123|Automation|
	
	@TestOrange
   Scenario Outline: Create multiple vacancies
    Given User login to orange HRM job portal
    And navigates to vacancies menu option
    And user creates new vacancy "<vacancyName>"
    Then Verify vacancy details are added for "<vacancyName>"
     
      Examples:
  |vacancyName|
  |AB First vacancy 1|
  |ABC Second vacancy |
    
   
