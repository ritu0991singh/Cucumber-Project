package com.PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utilities.BrowserSettings;

public class Login extends BrowserSettings {
	WebDriver driver;
	public Login(WebDriver ldriver){
		this.driver= ldriver;
 }   
	
	//suite CRM page
	@FindBy(id="user_name") public WebElement userName;
	@FindBy(id="username_password") public WebElement password;
	@FindBy(id="bigbutton") public WebElement loginButton;
	

	// Alchemy Page details
	@FindBy(xpath="//input[@id='user_login']") public WebElement userName_alchemy;
	@FindBy(id="user_pass") public WebElement password_alchemy;
	@FindBy(id="wp-submit") public WebElement loginButton_alchemy;

	// Orange HRM Page
	@FindBy(xpath="//input[@id='txtUsername']") public WebElement userName_HRM;
	@FindBy(id="txtPassword") public WebElement password_HRM;
	@FindBy(id="btnLogin") public WebElement loginButton_HRM;
}
