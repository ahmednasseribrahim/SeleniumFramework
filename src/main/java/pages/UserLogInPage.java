package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogInPage extends PageBase {

	public UserLogInPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "Email")
	WebElement emailtxtBox;

	@FindBy(id ="Password")
	WebElement passtxtBox;

	@FindBy(css = "button.button-1.login-button")
	WebElement loginButton;
	
	@FindBy(linkText = "Log out")
	public WebElement logOutlink;
	
	@FindBy(linkText = "My account")
	WebElement MyAccLink ;
	public void userLogin(String email, String password) {

		fillTextElementBox(emailtxtBox, email);
		fillTextElementBox(passtxtBox, password);
		clickbutton(loginButton);
	}
	
	public void userLogOut()
	{
		clickbutton(logOutlink);
	}
	
	public void OpenmyAccount()
	{
		clickbutton(MyAccLink);
	}
	
}
