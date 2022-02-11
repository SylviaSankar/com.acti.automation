package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
* Name: LoginPage Script
* Author: Sylvia J
* Verified and Approved: Shanthosh
* Date Last Modified: 2/1/2022
 */

public class LoginPage extends DriverScript {
	
	
	// ***************************************************PageElements*****************************************//
	@FindBy(id= "username") WebElement tbusername;
	@FindBy(name= "pwd") WebElement tbpassword;
	@FindBy(xpath= "//div[text()= 'Login ']") WebElement btnlogin;
	@FindBy(xpath = "//div[@class='atLogoImg']")WebElement actiLogo;
	@FindBy(xpath="//nobr[normalize-space()='actiTIME 2020 Online']") WebElement actiTIME;
	@FindBy(id ="headerContainer") WebElement headcon;
	
	// ****************************************************PageInitialization************************************//

		// PageFactory is a class in selenium which is use to initialize current page class elements.

		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
			

		// ****************************************************Page Actions************************************//

		public boolean verifyActiLogo()
		{
			return actiLogo.isDisplayed();
		}
		
		public boolean VerifyActiOnline()
		{
			return actiTIME.isDisplayed();
		}
		
		public boolean VerifyHeaderCon()
		{
			return headcon.isDisplayed();
		}

		public String getLoginPageTitle() {
			return driver.getTitle();
		}

		public void enterUsername(String username) {
			tbusername.sendKeys(username);
		}

		public void enterPassword(String password)

		{
			tbpassword.sendKeys(password);
		}

		public void clickLoginButton() {
			btnlogin.click();
			
		}
		
		

	}


