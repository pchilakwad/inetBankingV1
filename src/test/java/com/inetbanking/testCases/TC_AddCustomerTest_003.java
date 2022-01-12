package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing customer details ....");
		addcust.custName("Prakash");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Bangalore");
		addcust.custstate("Karnataka");
		addcust.custpinno("5600045");
		addcust.custtelephoneno("9823652352");
		
		String email = randomestring ()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abdhdfl");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Validation started ....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully !!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase Passed ....");
			
		}
		else
		{
			logger.info("Testcase faild ....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	

}

