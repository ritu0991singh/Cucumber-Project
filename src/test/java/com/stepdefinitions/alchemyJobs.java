package com.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utilities.BaseClass;
import Utilities.BrowserSettings;
import Utilities.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class alchemyJobs extends BaseClass{
	
	BrowserSettings bs= new BrowserSettings();
	Utility utility = new Utility();
	
	  String firstName=getProperty("FirstName")+utility.generateRamdomNumber();
	
	   @Given("^User login to alchemy job portal$")
	    public void User_login_to_alchemy_job_portal() throws Throwable {
		 
		  bs.setup("chrome");
		  driver.get(getProperty("URL_alchemyJobs"));
		  Thread.sleep(10000);
		  init();
		wait.until(ExpectedConditions.visibilityOf(loginpage.userName_alchemy));
		loginpage.userName_alchemy.sendKeys(getProperty("username_alchemyJob"));
		loginpage.password_alchemy.sendKeys(getProperty("password_alchemyJob"));
		loginpage.loginButton_alchemy.click();
		
	    }
	   
	   @And("^navigates to user menu option$")
	   public void navigates_to_user_menu_option() {
		   wait.until(ExpectedConditions.visibilityOf(homepage.users));	
		   homepage.users.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.add_users));	
		   homepage.add_users.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.input_username));	
			
	   }
	   
	   @And("^create a new User$")
	   public void create_new_user() throws InterruptedException {
		 
		   System.out.println("First Name is" +firstName);
		   String email= firstName+"@abc.com";
		   System.out.println("Email is" +email);
		   String password=firstName+"strongPassword" ;
			homepage.input_username.sendKeys(firstName);
			homepage.input_email.sendKeys(email);
			homepage.button_showPwd.click();
			homepage.input_Pwd.clear();
			homepage.input_Pwd.sendKeys(password);
			homepage.checkbox_sendUserNotification.click();
			utility.selectdropdownValueText(homepage.drpdown_role, "Contributor");
			  Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(homepage.input_createNewUser));	 
			homepage.input_createNewUser.click();
	   }
	   
	   @And("^verifies if the user is created$")
	   public void validate_User_created() throws InterruptedException {
		   wait.until(ExpectedConditions.visibilityOf(homepage.input_searchUser));	  
		   homepage.input_searchUser.sendKeys(firstName);
		   homepage.searchSubmit.click();
		   Thread.sleep(4000);
		   Assert.assertTrue("User created is not present in list", homepage.userCreatedFromList.getText().equalsIgnoreCase(firstName));	
		   bs.teardown();
	   }
	   
	   @And("^navigates to Job menu option$")
	   public void navigates_to_Job_menu_option() {
		   wait.until(ExpectedConditions.visibilityOf(homepage.jobListing));	
		   homepage.jobListing.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.input_searchJobPost));	
		   homepage.input_searchJobPost.click();
			
	   }
	   
	   @And("^User changes the Job Type$")
	   public void user_changes_jobType() throws InterruptedException {
		   wait.until(ExpectedConditions.visibilityOf(homepage.input_searchJobPost));	
		   homepage.input_searchJobPost.sendKeys(getProperty("searchJob"));
		   homepage.searchSubmit.click();
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.searchResult_job));	
		   homepage.searchResult_job.click();
		   try {
			   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='Close dialog']"))));	
			   driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		   } catch(Exception e) {
			  System.out.println("pop up not displayed"); 
		   }
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.radiobtn_Freelance));	
		   homepage.radiobtn_Freelance.click();
	     wait.until(ExpectedConditions.elementToBeClickable(homepage.button_update));	
	     homepage.button_update.click();
	     Thread.sleep(5000);
	     wait.until(ExpectedConditions.elementToBeClickable( homepage.backbutton));	
	     homepage.backbutton.click();
	     Thread.sleep(5000);
	     
	     homepage.input_searchJobPost.sendKeys(getProperty("searchJob"));
		   homepage.searchSubmit.click();
		    wait.until(ExpectedConditions.elementToBeClickable( homepage.jobTypeValueFromList));	
	    String JobTypeValue= homepage.jobTypeValueFromList.getText();
	    Assert.assertTrue("Job Type is not updated to Freelance and is" +JobTypeValue, JobTypeValue.equalsIgnoreCase("Freelance"));
	     
	   }
	   
	
	  @And("^Filter job type to show only Full Time jobs$") public void
	  filter_job_type_to_show_only_Full_Time_jobs() throws Throwable {
		  Thread.sleep(5000);
		  homepage.alchemyJoblink.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Jobs']")));
		  driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("job_type_temporary")));
		  driver.findElement(By.id("job_type_freelance")).click();
		  driver.findElement(By.id("job_type_internship")).click();
		  driver.findElement(By.id("job_type_part-time")).click();
		  driver.findElement(By.id("job_type_temporary")).click();
		  driver.findElement(By.xpath("//input[@value='Search Jobs']")).submit();
	  
	 }
	 
	   
	  
	   @And("^Find the title of the job listing$")
	   public void find_the_title_of_the_job_listing() throws Throwable {
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@class='ab-item'])[7]"))));
		   driver.findElement(By.xpath("(//a[@class='ab-item'])[7]")).click();
		   navigates_to_Job_menu_option();
		List<WebElement>	jobPostings = driver.findElements(By.xpath("//a[@class='tips job_title']"));

			for (WebElement job : jobPostings) {
					System.out.println(job.getText());
				}
		
			homepage.searchResult_Viewjob.click();
			  wait.until(ExpectedConditions.elementToBeClickable( homepage.applyForJob));	
			  homepage.applyForJob.click();
			String message = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/header/div/h1")).getText();
			System.out.println("The tile of the job is: " +message);



		}

	   @And("^navigates to post a job option$")
	   public void navigationToPostaJob() {
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.alchemyJoblink));	
		   homepage.alchemyJoblink.click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Post a Job']")));  
		   driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
	   }
	   
	   @And ("^post a job with title \"(.*)\" location \"(.*)\" and description \"(.*)\"$")
	   public void JobDetails(String title, String location, String description) throws InterruptedException {
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.input_jobTitle));	
		   homepage.input_jobTitle.sendKeys(title);
		   homepage.input_jobLocation.sendKeys(location);
		   utility.switchToFrame(homepage.frame_jobDesc);
		   homepage.input_jobDesc.sendKeys(description);
		   driver.switchTo().defaultContent();
		   Thread.sleep(4000);
		   jse.executeScript("arguments[0].scrollIntoView(true);", homepage.input_preview);
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.input_preview));	
		   homepage.input_preview.click();
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.submitJob));	
		   homepage.submitJob.click();
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.jobDashboardLink));	
		   homepage.jobDashboardLink.click();
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.jobDescriptionValidation));	
		   String jobtitle= homepage.jobDescriptionValidation.getText();
		   Assert.assertTrue("The job title is not of the job posted and is" +jobtitle, jobtitle.equalsIgnoreCase(description));
		   bs.teardown();
	   }
	   
	 
}
