package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
//log4j
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	@BeforeClass(groups= {"snaity","Regression","dataDriven"})
	@Parameters({"os","Browser"})
	public void setup(String os,String Br) throws IOException
	{
		//read files from properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);		
		
		//log4j2
		logger=LogManager.getLogger(this.getClass());
		//browser selection
		if(p.getProperty("execution_var").equalsIgnoreCase("Remote"))
		{
			String HubUrl="http://localhost:4444/wd/hub"; 
			DesiredCapabilities cap=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("Windows"))
				{
					cap.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					cap.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("not a valid OS");
					return;
				}
			//Browser
			if(Br.equalsIgnoreCase("chrome"))
				{
					cap.setBrowserName("chrome");
				}
				else if(Br.equalsIgnoreCase("edge"))
				{
					cap.setBrowserName("MicrosoftEdge");
				}
				else if(Br.equalsIgnoreCase("firefox"))
				{
					cap.setBrowserName("Firefox");
				}
//			URL Aurl=new URL("http://localhost:4444/wd/hub");
			
			 driver=new RemoteWebDriver(new URL(HubUrl),cap);
		}
		if(p.getProperty("execution_var").equalsIgnoreCase("local"))
		{
			switch(Br.toLowerCase())
			{
			case "chrome":driver=new ChromeDriver(); break;
			case "firefox":driver=new FirefoxDriver(); break;
			case "edge":driver=new EdgeDriver(); break;
			default:System.out.print("not a valid browser");return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));   // Page load timeout
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));     // Script execution timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot tc=(TakesScreenshot) driver;
		File SourceFile=tc.getScreenshotAs(OutputType.FILE);
		String TargetFilepath=System.getProperty("user.dir")+"\\Screenshots\\"+ tname +"_"+ timeStamp;
		File TargetFile=new File(TargetFilepath);
		SourceFile.renameTo(TargetFile);
		return TargetFilepath;
		
	}
	public String RandomString()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String RandomNum()
	{
		String generateddnum=RandomStringUtils.randomNumeric(10);
		return generateddnum;
	}
	public String RandomAlphaNumeric()
	{
		String AlphaNum=RandomStringUtils.randomAlphanumeric(10);
		return(AlphaNum+"@");
	}
	@AfterClass(groups= {"snaity","Regression","dataDriven"})
	public void teatdown()
	{
		driver.close();
	}

}
