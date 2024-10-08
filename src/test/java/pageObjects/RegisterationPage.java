package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends BasePage {
	
	public RegisterationPage(WebDriver driver)
	{
		super(driver);
	}
//elements
	@FindBy(xpath=".//*[@name=\"firstname\"]")
	WebElement FirstName;
	@FindBy(id="input-lastname")
	WebElement Lastname;
	@FindBy(name="email")
	WebElement Email;
	@FindBy(id="input-telephone")
	WebElement Telephone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement Re_password;
    @FindBy(xpath=".//*[@type=\"checkbox\"]")
    WebElement checkbox;
    @FindBy(xpath=".//*[@type=\"submit\"]")
    WebElement clickContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
//methods
	public void SetFirstName(String fname)
	{FirstName.sendKeys(fname);	}
	public void SetLastName(String lname)
	{Lastname.sendKeys(lname);}
	public void SetEmail(String eml)
	{Email.sendKeys(eml);	}
    public void SetTelephone(String tel)
    {Telephone.sendKeys(tel);}
    public void setpassword(String pwd)
    {password.sendKeys(pwd);}
    public void Re_password(String pwd)
    {Re_password.sendKeys(pwd);}
    public void Setcheckbox()
    {checkbox.click();}
    public void clickcontinue()
    {clickContinue.click();}
    
   public String confirmation()
   {
	   try {
		   return(msgConfirmation.getText());
	   }
	   catch(Exception e)
	   {
		  return(e.getMessage()) ;
	   }
   }
    
}
    
    
    
    
    
    
    