package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BasePage{
public SearchHotel() {
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//td[@class='welcome_menu']")
	WebElement Welcometitle;
	@FindBy(xpath="//select[@name='location']")
		WebElement DPlocation;
	@FindBy(xpath="//select[@name='hotels']")
	WebElement DPHotelName;
	@FindBy(xpath="//select[@name='room_type']")
	WebElement DproomType;
	@FindBy(xpath="//select[@name='room_nos']")
WebElement DpnoOfRooms;
	@FindBy(xpath="//input[@id='datepick_in']")
	WebElement checkin;
	@FindBy(xpath="//input[@id='datepick_out']")
WebElement checkout;
	@FindBy(xpath="//select[@id='adult_room']")
	WebElement DPadultno;
	@FindBy(xpath="//input[@id='Submit']")
	WebElement search;
	
	public void welcometitle(String titlename)
	{
		titleName(Welcometitle, titlename);
	}
	public void Location(String Location) {
		dropDown(DPlocation, Location);
		
	}
	public void hotelName(String Name) {
		dropDown(DPHotelName, Name);
	}
	public void roomType(String room) {
		dropDown(DproomType, room);
	}
	public void noOfRooms(String num) {
		dropDown(DpnoOfRooms, num);
	}
	public void checkin(String in) {
		clear(checkin);
		send(checkin, in);
	}
	public void checkout(String out) {
		clear(checkout);
		send(checkout, out);
	}public void search() {
	click(search);
	}
	public void adultno(String adult) {
		dropDown(DPadultno, adult);
	}
}
