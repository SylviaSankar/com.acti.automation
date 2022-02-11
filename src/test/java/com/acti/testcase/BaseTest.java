package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.utils.ExcelLib;

public class BaseTest extends DriverScript {

	LoginPage lp;
	EnterTimePage ep;
	
	@BeforeMethod
	public void setup()
	{
		initApplication();
		lp = new LoginPage();
		ep = new EnterTimePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitBrowser();
	}
	
	@DataProvider(name="actidata")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./actestdata/actidata.xlsx");
		int rows = excel.getRowCount(0);
		
	Object[][] data = new Object[rows][2];
	
	for(int i=0;i<rows;i++)
	{
		data[i][0]=excel.getCellData(0,i,0);
		data[i][1]= excel.getCellData(0,i,1);
	}
	return data;
	}
}
