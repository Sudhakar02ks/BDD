package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotel;
import utils.UtilsKit;

public class SearchHotelViaHybridKeywordFrame extends BaseTest {
	
@Test(dataProvider="getdata")
public void findHotel(HashMap<String, String>testdata) {
	LoginPage lp =new LoginPage();
	lp.username(testdata.get("username"));
	lp.password(testdata.get("password"));
	lp.login();
	lp.verifyTitle(testdata.get("Expected Title1"));
	
	SearchHotel SH=new SearchHotel();
SH.welcometitle(testdata.get("Welcome Title"));
SH.Location(testdata.get("Location"));
SH.hotelName(testdata.get("Hotels"));
SH.roomType(testdata.get("Room Type"));
SH.noOfRooms(testdata.get("Number of Rooms"));
SH.checkin(testdata.get("Check In Date"));
SH.checkout(testdata.get("Check Out Date"));
SH.adultno(testdata.get("Adults per Room"));
SH.search();
}
@DataProvider()
public Object[][] getdata()
{
	Object[][] data=new Object[1][1];
	data[0][0]=UtilsKit.getdatafromExcel("TC-102");
	return data;
	
}

}
