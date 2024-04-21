package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class BasePage extends BaseTest{

	public void verifyTitle(String expTitile)
	{
		Assert.assertEquals(driver.getTitle(), expTitile);
	}
	public void send(WebElement element ,String Text) {
		element.sendKeys(Text);
	}
	public void dropDown(WebElement element,String options) {
		new Select(element).selectByVisibleText(options);
	}
	public void click(WebElement element) {
		element.click();
	}
	public void clear(WebElement element) {
		element.clear();
	}
	public void titleName(WebElement element ,String title) {
		Assert.assertEquals(element.getText(), title);
	}
	
	public static String ScreenShot() {
		String SSfolderpath=System.getProperty("user.dir")+"\\screenshots";
		File SSfolder=new File(SSfolderpath);
		SSfolder.mkdir();
		
		File img3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		Date d = new Date();
		String pattren = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat date = new SimpleDateFormat(pattren);
		String dates = date.format(d);
		System.out.println(dates);
		dates = dates.replace(":", "-");

		System.out.println(dates);
		String SSpath=SSfolderpath+"\\" + dates + ".png";
		try {
			FileUtils.copyFile(img3,
					new File(SSpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SSpath;
		
	}
}
