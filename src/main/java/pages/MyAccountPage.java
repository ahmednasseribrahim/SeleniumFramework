package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	} 
	@FindBy(linkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(id = "bar-notification")
	public WebElement notifiBar;
	
	@FindBy(className = "close")
	public WebElement closeNotify;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	
	public void OpenChangePasswordPage()
	{
		clickbutton(ChangePasswordLink);
	}
	public void ChangePassword(String oldPass , String newPass)
	{
		fillTextElementBox(oldPasswordTxt, oldPass);
		fillTextElementBox(newPasswordTxt, newPass);
		fillTextElementBox(confirmPasswordTxt, newPass);
		clickbutton(changePasswordBtn);
		
	}
	public void userLogOut()
	{	
		clickbutton(logoutLink);
	}
}
