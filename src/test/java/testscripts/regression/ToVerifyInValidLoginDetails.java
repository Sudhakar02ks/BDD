package testscripts.regression;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyInValidLoginDetails extends BaseTest {
	@Test
	public void invalidUsernameValidPassword()
	{

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sudha99");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sudhakar02@");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		
	}
	@Test
	public void validUsernameInvalidPassword()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sudha999");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sudhakar02");
		driver.findElement(By.xpath("//input[@id='login']")).click();

	}
	@Test
	public void inValidUsernameInvalidPassword()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sudha99");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sudhakar02");
		driver.findElement(By.xpath("//input[@id='login']")).click();
	
	}
}
