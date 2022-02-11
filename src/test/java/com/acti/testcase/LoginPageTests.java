package com.acti.testcase;


import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTests extends BaseTest {
	
	//ctrl+shift+O to remove unused import
	
	
	@Test(enabled = true)
	public void testValidateLoginPageDisplayed() 
	{
		
		String title = lp.getLoginPageTitle();
		Assert.assertTrue(title.contains("Login"));
	    //System.out.println(actual);
	    quitBrowser(); 
	}
	

	@Test(enabled = true)
	public void testValidateActiLogo()
	{
		
		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);
		quitBrowser();

	}
	
	@Test(enabled = true)
	public void testValidateActiTIME()
	{
		
		boolean flags = lp.VerifyActiOnline();
		Assert.assertTrue(flags);
		quitBrowser();

	}
	
	@Test(enabled = true)
	public void testValidateHeaderCon()
	{
		
		boolean flags = lp.VerifyHeaderCon();
		Assert.assertTrue(flags);
		quitBrowser();

	}
	
	
	@Test(dataProvider ="actidata")
	public void testLoginFunction(String username, String password)
	{
		
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();
		String actual = ep.verifyUserLoggedIn();
		System.out.println(actual);
		ep.clickLogout();
	}
	
	
}



