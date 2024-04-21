package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.UtilsKit;

public class LoginusingPOM  extends BaseTest{
	@Test(dataProvider="getTestData")
public void login(HashMap<String, String>data) {
	
		//LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		LoginPage lp =new LoginPage();
		lp.username(data.get("username"));
	lp.password(data.get("password"));
	lp.login();
	lp.verifyTitle(data.get("Expected Title"));
}
	@DataProvider
	public Object[][] getTestData() {
		
		Object[][] data =new Object[1][1];
		data[0][0]=UtilsKit.getdatafromExcel("TC-100");
		
		return data;
		
	}
}
