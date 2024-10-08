package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement Email;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(xpath=".//input[@class=\"btn btn-primary\"]")
	WebElement Loginbtn;
	
	public void SetEmail(String Emailid)
	{
		Email.sendKeys(Emailid);
	}
	public void SetPswd(String Pwd)
	{
		password.sendKeys(Pwd);
	}
	public void loginbtn()
	{
		Loginbtn.click();
	}
	

}
