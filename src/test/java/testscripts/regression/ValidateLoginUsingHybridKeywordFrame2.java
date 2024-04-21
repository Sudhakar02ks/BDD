package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilsKit;

public class ValidateLoginUsingHybridKeywordFrame2 extends BaseTest {

	@Test(dataProvider="getTestData")
	public void login(HashMap<String, String>data)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		app.openBrowser();
		app.launchBrowser();
		app.send("username_textbox",data.get("username"));
		app.send("password_textbox", data.get("password"));
		app.click("login_button");
		app.validateTitle(data.get("Expected Title"));
		
	}
	@DataProvider
	public Object[][] getTestData()  
	{
	Object[][] testcase=	new Object[1][1];
	testcase[0][0]=UtilsKit.getdatafromExcel("TC-100");
		return testcase;
		
	}
	
}
