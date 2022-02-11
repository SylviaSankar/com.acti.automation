package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverScript {
	
	public static WebDriver driver;
	Properties prop;
	
	public DriverScript()
	{
		try{
		File src = new File("./acconfig/config.properties");
		FileInputStream fis = new FileInputStream(src);
	    prop = new Properties();
		prop.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Properties file not found check please..."+e.getMessage());
	}
	}
	
	@Test
	public void initApplication()
	{
		 String broWser = prop.getProperty("browser");
		 
		 if(broWser.equalsIgnoreCase("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver","./acbrowsers/chromedriver.exe");
			driver= new ChromeDriver();
		 }
		 
		 else if(broWser.equalsIgnoreCase("firefox"))
		 {
			System.setProperty("webdriver.gecko.driver","./acbrowsers/geckodriver.exe");
			driver= new FirefoxDriver();
		 }
		 
		 else if(broWser.equalsIgnoreCase("edge"))
		 {
			System.setProperty("webdriver.edge.driver","./acbrowsers/edgedriver.exe");
			driver= new EdgeDriver();
		 }
		 
		 else
		 {
			 System.out.println("the browser not supported please check the config file");
		 }
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 
		 String url = prop.getProperty("qaurl");
		 driver.get(url);
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
}
