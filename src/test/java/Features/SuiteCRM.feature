Feature: Suite CRM activities


  @TestCRM
  Scenario: Counting Dashlets
    Given User login to suite CRM portal
    And User counts the dashlets in homepage
    
    
     @TestCRM
  Scenario Outline: Create leads using parameterization
    Given User login to suite CRM portal
    And User navigates to lead page
    And Creates a new lead using first name as "<FirstName>"
    Then User validates if lead created for "<FirstName>"
    
    Examples:
  |FirstName|
  |ADangalore|
  |ADPune|
  
  
   @TestCRM
  Scenario Outline: Schedule a meeting and invite members
    Given User login to suite CRM portal
    And User navigates to meeting page
    Then User will schedule a meeting and invite "<FirstUser>" , "<SecondUser>" and "<thirdUser>"
    And User confirms creation of the meeting
   
Examples:
  |FirstUser|SecondUser|thirdUser|
  |Test|Testing|test1|
  
  @TestCRM
  Scenario Outline: Creating a Product
    Given User login to suite CRM portal
    And User navigates to product page
    And Create new Product "<productName>", "<partNum>", "<Price>"
   Then User validate the product created "<productName>"
   
 Examples: 
 | productName  | partNum | Price|
 | RS post Product1 |     12345 | 11 |
 | RS post Product2|     67890 | 22| 