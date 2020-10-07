package com.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utilities.BaseClass;
import Utilities.BrowserSettings;
import Utilities.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class OrganceHRM extends BaseClass{
	
	BrowserSettings bs= new BrowserSettings();
	Utility utility = new Utility();
	
	  String Name=getProperty("FirstName")+utility.generateRamdomNumber();
	
	   @Given("^User login to orange HRM job portal$")
	    public void User_login_to_orange_HRM_portal() throws Throwable {
		 
		  bs.setup("chrome");
		  driver.get(getProperty("URL_Organge"));
		  Thread.sleep(10000);
		  init();
		wait.until(ExpectedConditions.visibilityOf(loginpage.userName_HRM));
		loginpage.userName_HRM.sendKeys(getProperty("username_HRM"));
		loginpage.password_HRM.sendKeys(getProperty("password_HRM"));
		loginpage.loginButton_HRM.click();
		
	    }
	   
	   @And("^navigates to vacancies menu option$")
	   public void navigates_to_vacancies_menu_option() {
		   wait.until(ExpectedConditions.visibilityOf(homepage.recruitmentTab));	
		   homepage.recruitmentTab.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.vacancies));	
		   homepage.vacancies.click();
		  
			
	   }
	   
	   @And("^User creates a new vacancy$")
	   public void UserCreateNewVacancy() throws InterruptedException {
		  
		   wait.until(ExpectedConditions.visibilityOf(homepage.btn_add));		
		   homepage.btn_add.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.vacancies));	
		   homepage.vacancies.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.btn_add));	
		   homepage.btn_add.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.drpdown_vacancyTitle));	
		   utility.selectdropdownValueText(homepage.drpdown_vacancyTitle, "Automation Test Engineer");
		   System.out.println("vacancy Name is" +Name);
		   homepage.input_vacancyName.sendKeys(Name);
		   homepage.input_hiringManager.sendKeys("Test");
		   homepage.input_hiringManager.sendKeys(Keys.ENTER);
		   homepage.btn_saveHRM.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.header_editJobVacancy));		
		   Assert.assertTrue("Vacancy was not created successfully: "+homepage.header_editJobVacancy.getText(), homepage.header_editJobVacancy.getText().equalsIgnoreCase("Edit Job Vacancy"));
		   bs.teardown();
	   }
	   
	   @And("^Adds a candidate for recruitment$")
	   public void addCandidate() {
		   wait.until(ExpectedConditions.visibilityOf(homepage.recruitmentTab));	
		   homepage.recruitmentTab.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.btn_add));	
		   homepage.btn_add.click();
		   System.out.println("candidate name is" +Name);
		   String email= Name+"@abc.com";
		   homepage.input_firstNameHRM.sendKeys(Name);
		  homepage.input_lastname.sendKeys("automation");
		  homepage.input_emailHRM.sendKeys(email);
		  homepage.addFile.sendKeys("C:/Users/RituSingh/Documents/cucumber project/cucumber/resume template.docx");
		  wait.until(ExpectedConditions.visibilityOf(homepage.btn_saveHRM));	
		   homepage.btn_saveHRM.click();
		  
			
	   }
	   
	   @And("^Verify candidate details are added$")
	   public void validateCandidateAdded() throws InterruptedException {
		  
		   wait.until(ExpectedConditions.visibilityOf(homepage.recruitmentTab));		
		   homepage.recruitmentTab.click();
		   Thread.sleep(5000);
		   jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td[3])[1]")));
		   String fullName= Name+" automation";
		   System.out.println("full name is" +fullName);
		  List<WebElement> candidateNameFromList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
		  for(WebElement candidate:candidateNameFromList) {
			  if(candidate.getText().equalsIgnoreCase(fullName)) {
				  System.out.println("candidate created successfully");
				  break;
			  		} else {
				  System.out.println("still searching for candidate. the current candidate name is: " +candidate.getText());
			  		}
		  		}
			  bs.teardown();
		  }
		
		 
		  
		  @And("^User add employee details with \"(.*)\" and \"(.*)\"$")
		   public void addEmployeePIM(String FirstName, String LastName) {
			   wait.until(ExpectedConditions.visibilityOf(homepage.PIMTab));	
			   homepage.PIMTab.click();
			   wait.until(ExpectedConditions.visibilityOf(homepage.addemployee));	
			   homepage.addemployee.click();
			   wait.until(ExpectedConditions.visibilityOf(homepage.input_firstNamePIM));
			   homepage.input_firstNamePIM.sendKeys(FirstName);
			   homepage.input_lastnamePIM.sendKeys(LastName);
			   homepage.creditLoginDetails.click();
			   wait.until(ExpectedConditions.visibilityOf(homepage.input_usernamePIM));
			   homepage.input_usernamePIM.sendKeys(Name);
			   homepage.btn_saveHRM.click();
			  
		  		}
		  
	
	   

	@And("^Verify employee details \"(.*)\" are added$")
	public void validateemployeeDetailsAdded(String FirstName) throws InterruptedException {
	  
	   wait.until(ExpectedConditions.visibilityOf(homepage.employeeList));		
	   homepage.employeeList.click();
	   Thread.sleep(5000);
	   jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td[3])[1]")));
	   
	  List<WebElement> candidateNameFromList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
	  for(WebElement candidate:candidateNameFromList) {
		  if(candidate.getText().equalsIgnoreCase(FirstName)) {
			  System.out.println("candidate created successfully");
			  break;
		  		} else {
			  System.out.println("still searching for employee. the current employee name is: " +candidate.getText());
		  		}
	  		}
		  bs.teardown();
	  }
	
	@And ("^user creates new vacancy \"(.*)\"$")
	   public void createNewVacancies(String vacancyName) throws InterruptedException {
		 wait.until(ExpectedConditions.visibilityOf(homepage.btn_add));		
		   homepage.btn_add.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.vacancies));	
		   homepage.vacancies.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.btn_add));	
		   homepage.btn_add.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.drpdown_vacancyTitle));	
		   utility.selectdropdownValueText(homepage.drpdown_vacancyTitle, "Automation Test Engineer");
		 
		   homepage.input_vacancyName.sendKeys(vacancyName);
		   homepage.input_hiringManager.sendKeys("Test");
		   homepage.input_hiringManager.sendKeys(Keys.ENTER);
		   homepage.btn_saveHRM.click();
		   wait.until(ExpectedConditions.visibilityOf(homepage.header_editJobVacancy));		
		   Assert.assertTrue("Vacancy was not created successfully: "+homepage.header_editJobVacancy.getText(), homepage.header_editJobVacancy.getText().equalsIgnoreCase("Edit Job Vacancy"));
		 
	   }
	
	@And("^Verify vacancy details are added for \"(.*)\"$")
	public void validateVacancyDetailsAdded(String vacancyName) throws InterruptedException {
		 wait.until(ExpectedConditions.visibilityOf(homepage.vacancies));	
		   homepage.vacancies.click();
		Thread.sleep(5000);
	   jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td[3])[1]")));
	   
	  List<WebElement> vacancyNameFromList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
	  for(WebElement candidate:vacancyNameFromList) {
		  if(candidate.getText().equalsIgnoreCase(vacancyName)) {
			  System.out.println("vacancy found");
			  break;
		  		} else {
			  System.out.println("still searching for vacancy. the current vacancy name is: " +candidate.getText());
		  		}
		  
	  		}
		  bs.teardown();
	  }

	   
	 
	 
}
