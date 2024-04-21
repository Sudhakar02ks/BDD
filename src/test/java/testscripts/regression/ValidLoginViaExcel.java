package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilsKit;

public class ValidLoginViaExcel extends BaseTest {
	@Test(dataProvider="getdata")
	public void Login(HashMap <String,String> data) 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get("password"));
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals(driver.getTitle(), data.get("Expected Title"));
	}
	@DataProvider
	public Object [][] getdata(){
		Object[][]data=new Object[1][1];
		data[0][0]=UtilsKit.getdatafromExcel("TC-100");
		return data;
}
}
