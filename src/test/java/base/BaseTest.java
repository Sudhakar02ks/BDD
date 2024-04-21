package base;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReport;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream path;
	public static Properties prop;
	public static FileInputStream path1;
	public static Properties prop1;
	public static ExtentReports report;
	public static ExtentTest Test;
	
	@AfterTest
	public void closereports() {
		if(report!=null) {
			report.flush();
	}
	}
	
	@BeforeTest
	public void file() throws IOException
	{
		 path= new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		prop=new Properties();
		prop.load(path);	
		path1= new FileInputStream("src\\test\\resources\\Properties\\locators.properties");
		prop1=new Properties();
		prop1.load(path1);	
		report=	ExtentReport.getreports();
	}
	@BeforeMethod
	public void launchBrowser(ITestContext context)
	{
		//Test=report.createTest("Loginvalidation");
		Test=report.createTest(context.getCurrentXmlTest().getClasses().get(0).getName());
		
	String browserName=	prop.getProperty("browser");
if(browserName .equalsIgnoreCase("chrome")) {
	driver = new ChromeDriver();
	Test.info("Chrome started");
}else if (browserName.equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
}

		
		driver.get(prop.getProperty("url"));
		Test.info("Application started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitwait"))));
	}

@AfterMethod
public void quitBrowser()
{
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}
}
