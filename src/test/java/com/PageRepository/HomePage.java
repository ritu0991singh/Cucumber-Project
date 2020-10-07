package com.PageRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BrowserSettings;

public class HomePage extends BrowserSettings {
	WebDriver driver;
	public HomePage(WebDriver ldriver){
		this.driver= ldriver;
	}
	
	
	@FindBy(xpath="//a[@id='grouptab_0']") public WebElement drpdown_Sales;	
	@FindBy(xpath="//a[text()='Leads']") public WebElement drpdownValueSales_Leads;
	@FindBy(xpath="//a[text()='Activities']") public WebElement drpdown_activities;
	@FindBy(xpath="//a[text()='Meetings']") public WebElement drpdown_meetings;
	@FindBy(xpath="//div[text()='Schedule Meeting']") public WebElement scheduleMeeting;
	@FindBy(xpath="//a[text()='All']") public WebElement drpdown_all;
	@FindBy(xpath="//a[text()='Products']") public WebElement drpdownvalue_product;
	@FindBy(xpath="//div[text()='Create Product']") public WebElement createProduct;
	@FindBy(xpath="//div[text()='View Products']") public WebElement viewProducts;
	
		// WebElements from Create lead form
		
		//*************overview section***************************
		
		@FindBy(xpath="//div[text()='Create Lead']") public WebElement createLeads_Sales;
		@FindBy(xpath="//iframe[@id='ajaxUI-history-iframe']") public WebElement iframe_createLeads;
		@FindBy(xpath="//*[@id='salutation']") public WebElement drpdown_salutation;
		@FindBy(xpath="//input[@id='first_name']") public WebElement input_firstName;
		@FindBy(xpath="//input[@id='last_name']") public WebElement input_lastName;
		@FindBy(xpath="//input[@id='phone_mobile']") public WebElement input_mobileNum;
		@FindBy(xpath="//input[@id='title']") public WebElement input_title;
		@FindBy(xpath="//input[@id='department']") public WebElement input_department;
		@FindBy(xpath="//input[@id='EditView_account_name']") public WebElement input_accName;
		@FindBy(xpath="//input[@id='phone_work']") public WebElement input_officephone;
		@FindBy(xpath="//input[@id='phone_fax']") public WebElement input_fax;
		@FindBy(xpath="//input[@id='website']") public WebElement input_website;
		@FindBy(xpath="//textarea[@id='primary_address_street']") public WebElement textarea_primaryAddress;
		@FindBy(xpath="//input[@id='primary_address_city']") public WebElement input_primaryCity;
		@FindBy(xpath="//input[@id='primary_address_state']") public WebElement input_primaryState;
		@FindBy(xpath="//input[@id='primary_address_postalcode']") public WebElement input_primaryPostalCode;
		@FindBy(xpath="//input[@id='primary_address_country']") public WebElement input_primaryCountry;
		@FindBy(xpath="//input[@id='alt_checkbox']") public WebElement checkbox_copyAddress;
		@FindBy(xpath="//textarea[@id='alt_address_street']") public WebElement textarea_altAddress;
		@FindBy(xpath="//input[@id='alt_address_city']") public WebElement input_altCity;
		@FindBy(xpath="//input[@id='alt_address_state']") public WebElement input_altState;
		@FindBy(xpath="//input[@id='alt_address_postalcode']") public WebElement input_altPostalCode;
		@FindBy(xpath="//input[@id='alt_address_country']") public WebElement input_altCountry;
		@FindBy(xpath="//input[@id='Leads0emailAddress0']") public WebElement input_emailID1;
		@FindBy(xpath="//span[@class='suitepicon suitepicon-action-plus']") public WebElement addemailID;
		@FindBy(xpath="//input[@id='Leads0emailAddress1']") public WebElement input_emailID2;
		@FindBy(xpath="(//input[@id='Leads0emailAddressPrimaryFlag'])[2]") public WebElement radioButton_primary;
		@FindBy(xpath="//textarea[@id='description']") public WebElement textarea_description;
		
		//*************More Information section***************************
		
		@FindBy(xpath="//select[@id='status']") public WebElement drpdown_Status;
		@FindBy(xpath="//textarea[@id='status_description']") public WebElement textarea_StatusDescription;
		@FindBy(xpath="//input[@id='opportunity_amount']") public WebElement input_oppurtunityAmt;
		@FindBy(xpath="(//span[@class='suitepicon suitepicon-action-select'])[1]") public WebElement btn_campaign;
		@FindBy(xpath="//select[@id='lead_source']") public WebElement drpdown_leadSource;
		@FindBy(xpath="//textarea[@id='lead_source_description']") public WebElement textarea_leadSourceDescription;
		@FindBy(xpath="//input[@id='refered_by']") public WebElement input_referredBy;
		
		//*************Other section***************************
		@FindBy(xpath="(//span[@class='suitepicon suitepicon-action-select'])[2]") public WebElement selectUser_assignTo;
		
	
		@FindBy(xpath="(//input[@title='Save'])[2]") public WebElement btn_save;
		@FindBy(xpath="//div[text()='View Leads']") public WebElement view_leads;
		@FindBy(xpath="//span[@class='phone']") public WebElement additionalDetails_phoneNum;
		
		
		// alchemy job portal -Webelements
		
		@FindBy(xpath="//div[text()='Users']") public WebElement users;
		@FindBy(xpath="//div[text()='Job Listings']") public WebElement jobListing;
		@FindBy(xpath="//a[@class='page-title-action' and text()='Add New']") public WebElement add_users;
		@FindBy(xpath="(//a[@class='ab-item'])[8]") public WebElement alchemyJoblink;
		
		//alchemy job portal - users page
		@FindBy(xpath="//input[@id='user_login']") public WebElement input_username;
		@FindBy(xpath="//input[@id='email']") public WebElement input_email;
		@FindBy(xpath="//button[text()='Show password']") public WebElement button_showPwd;
		@FindBy(xpath="//input[@id='pass1']") public WebElement input_Pwd;
		@FindBy(xpath="//input[@id='send_user_notification']") public WebElement checkbox_sendUserNotification;
		@FindBy(xpath="//select[@id='role']") public WebElement drpdown_role;
		@FindBy(xpath="//input[@id='createusersub']") public WebElement input_createNewUser;
		@FindBy(xpath="//input[@id='user-search-input']") public WebElement input_searchUser;
		@FindBy(xpath="//input[@id='search-submit']") public WebElement searchSubmit;
		@FindBy(xpath="//td[@class='username column-username has-row-actions column-primary']") public WebElement userCreatedFromList;
	
		// Job listing page
		@FindBy(xpath="//input[@id='post-search-input']") public WebElement input_searchJobPost;
		@FindBy(xpath="//a[@class='tips job_title']") public WebElement searchResult_job;
		@FindBy(xpath="//input[@id='in-job_listing_type-5']") public WebElement radiobtn_Freelance;
		@FindBy(xpath="//button[text()='Update']") public WebElement button_update;
		@FindBy(xpath="(//span[contains(@class, 'job-type')])[1]") public WebElement jobTypeValueFromList;
		@FindBy(xpath="//a[@class='components-button edit-post-fullscreen-mode-close has-icon']") public WebElement backbutton;
		@FindBy(xpath="//a[@class='button button-icon tips icon-view']") public WebElement searchResult_Viewjob;
		@FindBy(xpath="//input[@class='application_button button']") public WebElement applyForJob;
		
		// post a Job page
		@FindBy(xpath="//input[@id='job_title']") public WebElement input_jobTitle;
		@FindBy(xpath="//input[@id='job_location']") public WebElement input_jobLocation;
		@FindBy(xpath="//body[@id='tinymce']") public WebElement input_jobDesc;
		@FindBy(xpath="//iframe[@id='job_description_ifr']") public WebElement frame_jobDesc;
		@FindBy(xpath="//input[@name='submit_job']") public WebElement input_preview;
		@FindBy(xpath="//input[@id='job_preview_submit_button']") public WebElement submitJob;
		@FindBy(xpath="//a[text()='click here']") public WebElement jobDashboardLink;
		@FindBy(xpath="//div[@class='job_description']/p") public WebElement jobDescriptionValidation;
		
		// Orange HRM Elements
		@FindBy(xpath="//b[text()='Recruitment']") public WebElement recruitmentTab;
		@FindBy(xpath="//a[text()='Vacancies']") public WebElement vacancies;
		@FindBy(xpath="//input[@id='btnAdd']") public WebElement btn_add;
		@FindBy(xpath="//select[@id='addJobVacancy_jobTitle']") public WebElement drpdown_vacancyTitle;
		@FindBy(xpath="//input[@id='addJobVacancy_name']") public WebElement input_vacancyName;
		@FindBy(xpath="//input[@id='addJobVacancy_hiringManager']") public WebElement input_hiringManager;
		@FindBy(xpath="//input[@id='btnSave']") public WebElement btn_saveHRM;
		@FindBy(xpath="//h1[text()='Edit Job Vacancy']") public WebElement header_editJobVacancy;
		@FindBy(xpath="//input[@id='addCandidate_firstName']") public WebElement input_firstNameHRM;
		@FindBy(xpath="//input[@id='addCandidate_lastName']") public WebElement input_lastname;
		@FindBy(xpath="//input[@id='addCandidate_email']") public WebElement input_emailHRM;
		@FindBy(xpath="//input[@type='file']") public WebElement addFile;
		
		@FindBy(xpath="//b[text()='PIM']") public WebElement PIMTab;
		@FindBy(xpath="//a[text()='Add Employee']") public WebElement addemployee;
		@FindBy(xpath="//input[@id='firstName']") public WebElement input_firstNamePIM;
		@FindBy(xpath="//input[@id='lastName']") public WebElement input_lastnamePIM;
		@FindBy(xpath="//input[@type='checkbox']") public WebElement creditLoginDetails;
		@FindBy(xpath="//input[@id='user_name']") public WebElement input_usernamePIM;
		@FindBy(xpath="//a[text()='Employee List']") public WebElement employeeList;
	
		
}
