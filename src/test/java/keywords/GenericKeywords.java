package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseTest;

public class GenericKeywords extends BaseTest{
	
	public void openBrowser()
	{
		String browsername =prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
	}
	public void launchBrowser()
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitwait"))));
	}

	public void send (String locaters ,String Text) 
	{
		getElement( locaters).sendKeys(Text);
	}
	public void click(String locaters) {
		getElement(locaters).click();
	}
	
	public WebElement getElement(String locaters) {
		WebElement e=null;
		e=driver.findElement(getlocaters( locaters));
		return e; 
		}
	public By getlocaters(String locaters)
	{
		By by=null;
		if(locaters.endsWith("_id")) {
			by=By.id(prop1.getProperty(locaters));
		}else if(locaters.endsWith("_name")) {
			by=By.name(prop1.getProperty(locaters));
		}else {
			by=By.xpath(prop1.getProperty(locaters));
		}
		return by;
		
	}
}
