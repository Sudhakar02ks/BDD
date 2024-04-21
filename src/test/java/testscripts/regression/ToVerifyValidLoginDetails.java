package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;

public class ToVerifyValidLoginDetails extends BaseTest {
	
	@Test
	public void validLogin()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sudha999");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sudhakar02@");
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
}
	

