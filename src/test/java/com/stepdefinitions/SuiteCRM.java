package com.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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

public class SuiteCRM extends BaseClass{
	
	BrowserSettings bs= new BrowserSettings();
	Utility utility = new Utility();
	
	  String firstName=getProperty("FirstName")+utility.generateRamdomNumber();
	String meetingSubject=firstName+"Subject of meeting";
	   @Given("^User login to suite CRM portal$")
	    public void User_login_to_suiteCRM_portal() throws Throwable {
		 
		  bs.setup("chrome");
		  driver.get(getProperty("URL_CRM"));
		  Thread.sleep(5000);
		  init();
		wait.until(ExpectedConditions.visibilityOf(loginpage.userName));
		loginpage.userName.sendKeys(getProperty("username_CRM"));
		loginpage.password.sendKeys(getProperty("password_CRM"));
		loginpage.loginButton.click();
		
	    }
	   
	   @And("^User counts the dashlets in homepage$")
	   public void countDashlets() throws InterruptedException {
		   wait.until(ExpectedConditions.visibilityOf(homepage.drpdown_Sales));	
		   List<WebElement> dashletCount=driver.findElements(By.xpath("//td[@class='dashlet-title']"));
		   System.out.println("Number of dashlets present in homepage is: "+dashletCount.size());
			  for(WebElement dashlet:dashletCount) {
				  System.out.println("Title of dashlet is: "+dashlet.getText());
				 	}
			  bs.teardown();
			
	   }
	   
	   @And("^User navigates to lead page$")
	   public void navigationToleadsPage() {
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.drpdown_Sales));	
		   homepage.drpdown_Sales.click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.drpdownValueSales_Leads));
		   homepage.drpdownValueSales_Leads.click();
		 
	   }
	   
	   @And("^Creates a new lead using first name as \"(.*)\"$")
	   public void createLead(String FirstName) throws InterruptedException {
			
			
			wait.until(ExpectedConditions.elementToBeClickable(homepage.createLeads_Sales));
			homepage.createLeads_Sales.click();
			
			//************ Populating overview section********************//
			
			wait.until(ExpectedConditions.elementToBeClickable(homepage.drpdown_salutation));
			homepage.drpdown_salutation.click();
			utility.selectdropdownValueText(homepage.drpdown_salutation, "Miss");
			System.out.println("First Name generated is: "+firstName);
			
			homepage.input_firstName.sendKeys(FirstName);
			homepage.input_lastName.sendKeys(getProperty("LastName"));
			homepage.input_title.sendKeys(getProperty("title"));
			homepage.input_department.sendKeys(getProperty("department"));
			homepage.input_mobileNum.sendKeys(getProperty("mobileNumber"));
			homepage.input_accName.sendKeys(getProperty("acountName"));
			homepage.input_officephone.sendKeys(getProperty("officePhone"));
			homepage.input_fax.sendKeys(getProperty("fax"));
			homepage.input_website.sendKeys(getProperty("website"));
			homepage.textarea_primaryAddress.sendKeys(getProperty("primaryAddress"));
			homepage.input_primaryCity.sendKeys(getProperty("primaryCity"));	
			homepage.input_primaryState.sendKeys(getProperty("primaryState"));
			homepage.input_primaryPostalCode.sendKeys(getProperty("postalCode"));
			homepage.input_primaryPostalCode.sendKeys(getProperty("country"));
			
			// validating if primary address is copied to secondary address
			homepage.checkbox_copyAddress.click();
			ArrayList<WebElement> altAddress = new ArrayList<WebElement>();
			altAddress.add(homepage.textarea_altAddress);
			altAddress.add(homepage.input_altState);
			altAddress.add(homepage.input_altPostalCode);
			altAddress.add(homepage.input_altCity);
			altAddress.add(homepage.input_altCountry);
				
			jse.executeScript("arguments[0].scrollIntoView(true);", homepage.btn_save);
			wait.until(ExpectedConditions.elementToBeClickable(homepage.btn_save));
			homepage.btn_save.click();
			Thread.sleep(3000);
			try {
					if(homepage.btn_save.isDisplayed()) {
					homepage.btn_save.click();
					} 
				}catch(Exception e) {
					System.out.println("duplicate record creation popup not displayed");
				
			}
			Thread.sleep(5000);
			
		}
	   
	   @And("^User validates if lead created for \"(.*)\"$")
	   public void validateLead(String FirstName) throws InterruptedException {
			
			
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.view_leads));
			homepage.view_leads.click();
			Thread.sleep(4000);
			 List<WebElement> leads=driver.findElements(By.xpath("//span[@class='suitepicon suitepicon-module-leads']/following-sibling::span[1]"));
			  for(WebElement lead:leads) {
				  if(lead.getText().contains(FirstName)) {
					  System.out.println("lead created successfully");
					  break;
				  		} else {
					  System.out.println("still searching for lead. the current lead name is: " +lead.getText());
				  		}
				  
			  		}
			  bs.teardown();
			
		}
	   
	   @And("^User navigates to meeting page$")
	   public void navigationToMeetingsPage() {
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.drpdown_activities));	
		   homepage.drpdown_activities.click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.drpdown_meetings));
		   homepage.drpdown_meetings.click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.scheduleMeeting));
		   homepage.scheduleMeeting.click();
		 
	   }
	   
	   @And("^User will schedule a meeting and invite \"(.*)\" , \"(.*)\" and \"(.*)\"$")
	   public void scheduleMeeting(String FirstUser,String SecondUser, String thirdUser) throws InterruptedException {
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));

			driver.findElement(By.id("name")).click();
			driver.findElement(By.id("name")).sendKeys(meetingSubject);	
			Thread.sleep(5000);
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_first_name")).sendKeys(FirstUser);		
			driver.findElement(By.id("invitees_search")).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_add_1")));
			driver.findElement(By.id("invitees_add_1")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_first_name")).sendKeys(SecondUser);		
			driver.findElement(By.id("invitees_search")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_add_1")));
			Thread.sleep(4000);
			driver.findElement(By.id("invitees_add_1")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("search_first_name")).clear();

			driver.findElement(By.id("search_first_name")).sendKeys(thirdUser);		
			driver.findElement(By.id("invitees_search")).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_add_1")));
			driver.findElement(By.id("invitees_add_1")).click();
			Thread.sleep(4000);
			 jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")));
			driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
		 
	   }
	   
	   @And("^User confirms creation of the meeting$")
	   	public void userValidatesMeeting() throws InterruptedException {

			WebElement scheduleMeetingLink = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-action-name='List']")));
			driver.get(scheduleMeetingLink.getAttribute("href"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='Assign']")));
			String element = String.format("//a[contains(text(),'%s')]", meetingSubject);
			WebElement meetingDetails = driver.findElement(By.xpath(element));
			System.out.println("subject from list is: " +meetingDetails.getText());
			Assert.assertTrue("Assert added meeting is found", meetingDetails.isDisplayed());
			bs.teardown();

		}
	   
	   @And("^User navigates to product page$")
	   public void navigationToProductsPage() {
		   wait.until(ExpectedConditions.elementToBeClickable( homepage.drpdown_all));	
		   homepage.drpdown_all.click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(homepage.drpdownvalue_product));
		   homepage.drpdownvalue_product.click();
		   
		
		  wait.until(ExpectedConditions.elementToBeClickable(homepage.createProduct));
		  homepage.createProduct.click();
		}
	   
	   @And("^Create new Product \"(.*)\", \"(.*)\", \"(.*)\"$")

		public void createNewProduct(String productName, String partNum, String Price) throws Throwable {

		Thread.sleep(10000);
			driver.findElement(By.id("name")).sendKeys(productName);
			driver.findElement(By.id("part_number")).sendKeys(partNum);
			driver.findElement(By.id("price")).sendKeys(Price);
			driver.findElement(By.id("SAVE")).click();
	   }
	   
	   @And("^User validate the product created \"(.*)\"$")

		public void verify_the_product_created(String productName) throws Throwable {


		   wait.until(ExpectedConditions.elementToBeClickable(homepage.viewProducts));
		   homepage.viewProducts.click();
		   
			List<WebElement> products = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[3]/b/a"));

			for (WebElement product : products) {

				if (product.getText().equals(productName)) {

					System.out.println("Product created is found");

					break;

				}

			}

bs.teardown();

		}


	   
	   
}
