package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
public LoginPage() {
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//input[@name='username']")
	WebElement username_textbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_textbox;
	
@FindBy(xpath="//input[@name='login']")
WebElement login_button;

public void username(String text)
{
	//username_textbox.sendKeys(text);
	send(username_textbox, text);
}
public void password(String text)
{
	//password_textbox.sendKeys(text);
	send(password_textbox, text);
}
	public void login()
	{
		click(login_button);
	}
}
