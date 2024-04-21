package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class DataDrivenMethodLogin extends BaseTest{
	
@Test(dataProvider="getdata")
public void inValidLogin(String user , String pass) 
{
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
	driver.findElement(By.xpath("//input[@id='login']")).click();
}

@DataProvider
public Object [][] getdata(){
	Object[][]data=new Object[4][2];
	data[0][0]="Sudhakar99";
	data[0][1]="Sudhakar02@";
	
	data[1][0]="Sudhakar999";
	data[1][1]="Sudhakar02";
	
	data[2][0]="Sudhakar99";
	data[2][1]="Sudhakar02";
	
	data[3][0]="Sudha999";
	data[3][1]="Sudhakar02@";
	return data;
	
}
}
