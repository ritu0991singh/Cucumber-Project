Feature: Alchemy job activities


  @Test
  Scenario: Create new User
    Given User login to alchemy job portal
    And navigates to user menu option
    And create a new User
    And verifies if the user is created
   

 @Test
  Scenario: Search For Jobs
    Given User login to alchemy job portal
    And navigates to Job menu option
    And User changes the Job Type
    And Filter job type to show only Full Time jobs
   And Find the title of the job listing
   
   @Test
  Scenario: Post a Job using parameterization
    Given User login to alchemy job portal
    And navigates to post a job option
    And post a job with title "job title" location "india" and description "job description"
    
    @Test
  Scenario Outline: Post a Job using example table
    Given User login to alchemy job portal
    And navigates to post a job option
    And post a job with title "<Title>" location "<Location>" and description "<Desciption>"
   
   Examples:
  |Title|Location|Desciption|
  |AAFirst Job title|Bangalore|Description for first job|
  |AASecond job title|Bangalore|Description for second job|