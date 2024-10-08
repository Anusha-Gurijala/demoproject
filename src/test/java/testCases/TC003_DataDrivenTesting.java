package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DataDrivenTesting extends BaseClass{

	@Test(dataProvider="Logindata", dataProviderClass=DataProviders.class,groups="dataDriven")
	public  void verify_DDT(String Email,String Pwd,String Expcondition)
	{
      try {
		logger.info("****TC003 EXCETUCTION DDT***********");
		HomePage hp=new HomePage(driver);
		logger.info("****CLICKED ONMYACCOUNT***********");
		hp.clickmyaccount();
		logger.info("****clicked on mylogin***********");
		hp.clickLogin();
		LoginPage Lp=new LoginPage(driver);
		
		logger.info("****email entered***********");
		Lp.SetEmail(Email);
		logger.info("****password entered***********");
		Lp.SetPswd(Pwd);
		logger.info("****login button clicked***********");
		Lp.loginbtn();
		logger.info("****verifying my account heading***********");
		MyAccountPage Ap=new MyAccountPage(driver);
		Boolean value=Ap.Myaccountheading();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
		if(Expcondition.equalsIgnoreCase("Valid"))
		{
			if(value==true)
			{
			logger.info("****valid***********");
			Thread.sleep(2000);
			Ap.Logout();
			Assert.assertTrue(true);
			}
			else
			{
				Thread.sleep(5000);
			Assert.assertTrue(false);
			}
		}
		if(Expcondition.equalsIgnoreCase("Invalid"))
		{
			if(value==true)
			{
			logger.info("****Invalid***********");
			Thread.sleep(5000);
			Ap.Logout();
			Assert.assertTrue(false);
		    }
			else
			{
				Thread.sleep(5000);
				Assert.assertTrue(true);
			}
	     }

		} 
      catch(Exception e)
      {
    	  Assert.fail();
      }
      logger.info("****completed TC003 exectution completed***********");
	
	} }
		
	
	
	
	
	
	
	
	
	
	
	
	
