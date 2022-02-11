package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class EnterTimePage extends DriverScript {
	
	//*************************************PageElements**********************//
		@FindBy(id="logoutLink") WebElement linkLogout;
		@FindBy(xpath="//a[contains(@class,'userProfileLink username')]") WebElement textUserLoggedIn;
	    @FindBy(xpath="//a[@class='content tasks']") WebElement clickTask;
		//*************************************Page Initialization**********************//
		
		public EnterTimePage()
		{
			PageFactory.initElements(driver, this);
		}

		
		//*************************************Page Actions or Methods **********************//
		
		public String verifyUserLoggedIn()
		{
			return textUserLoggedIn.getText();
		}
		
		public void clickTaskMenu()
		{
			clickTask.click();
		}
		
		public void clickLogout()
		{
			linkLogout.click();
		}
	}



