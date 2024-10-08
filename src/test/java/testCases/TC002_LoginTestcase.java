package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTestcase extends BaseClass
{
	@Test(groups="sanity")
	public void Login(){
		logger.info("****TC002 EXCETUCTION STARTED***********");
		HomePage hp=new HomePage(driver);
		LoginPage Lp=new LoginPage(driver);
		MyAccountPage Ap=new MyAccountPage(driver);
		logger.info("****CLICKED ONMYACCOUNT***********");
		hp.clickmyaccount();
		logger.info("****clicked on mylogin***********");
		hp.clickLogin();
		logger.info("****email entered***********");
		Lp.SetEmail(p.getProperty("Email"));
		logger.info("****password entered***********");
		Lp.SetPswd(p.getProperty("password"));
		logger.info("****login button clicked***********");
		Lp.loginbtn();
		logger.info("****verifying my account heading***********");
		boolean value=Ap.Myaccountheading();
		Assert.assertEquals(value, true);
		
	}
	

}
