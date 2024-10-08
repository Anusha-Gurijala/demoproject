package testCases;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterationPage;
import testBase.BaseClass;

public class TC001_AccountRegistartionTest extends BaseClass{
	
	
	@Test(groups="Regression")
	public void Verify_Account_Registration()
	{
		logger.info("****this TC1 is started*****");
		try {
		HomePage hp=new HomePage(driver);
		RegisterationPage Rp=new RegisterationPage(driver);
		logger.info("****clicked on my Account*****");
		hp.clickmyaccount();
		logger.info("****clicked on Register*****");
		hp.clickRegister();
		logger.info("****entered customer details*****");
		Rp.SetFirstName(RandomString().toUpperCase());
		Rp.SetLastName(RandomString().toUpperCase());
		Rp.SetEmail(RandomString()+"@gmail.com");
		Rp.SetTelephone(RandomNum());
		String password=RandomAlphaNumeric();
	 	Rp.setpassword(password);
		Rp.Re_password(password);
		Rp.Setcheckbox();
		Rp.clickcontinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String confmsg=Rp.confirmation();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("****validated successful customer creation message*****");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	}
	
	


