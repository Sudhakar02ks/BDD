package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLoginUsingKeywordFrame extends BaseTest {

	@Test
	public void login()
	{
		ApplicationKeywords app=new ApplicationKeywords();
		app.openBrowser();
		app.launchBrowser();
		app.send("username_textbox", "Sudha999");
		app.send("password_textbox", "Sudhakar02@");
		app.click("login_button");
		app.validateTitle("Adactin.com - Search Hotel");
		
	}
	
}
