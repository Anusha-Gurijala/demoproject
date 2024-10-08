package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=".//h2[text()='My Account']")
	WebElement MyAccount;
	@FindBy(xpath=".//a[@class=\"list-group-item\" and text()='Logout']")
	WebElement Logout;
	
	public boolean Myaccountheading()
	{
		boolean exp=MyAccount.isDisplayed();
		return exp;
	}
	
	public void Logout()
	{
		Logout.click();
	}
	

}
