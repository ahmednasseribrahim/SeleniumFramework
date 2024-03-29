package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver)
	{
		super(driver);

	}
	
	@FindBy (id = "gender-male")
	WebElement genderRdBtn;

	@FindBy(id ="FirstName")
	WebElement fntxtBox;
	
	@FindBy (id = "LastName")
	WebElement lntxtBox;
	
	@FindBy (id = "Email")
	WebElement emailtxtBox;
	
	@FindBy (id = "Password")
	WebElement passtxtBox;
	
	@FindBy (id = "ConfirmPassword")
	WebElement cptxtBox;
	
	@FindBy (id = "register-button")
	WebElement regBtn;
	
	@FindBy (css = "div.result")
	public WebElement successMsg;
	
	@FindBy(linkText = "Log in")
	public WebElement loginlink;
	
	
	public void userRegistration(String firstName, String lastName, String email, String passWord) 
	{
		clickbutton(genderRdBtn);
		fillTextElementBox(fntxtBox, firstName);
		fillTextElementBox(lntxtBox, lastName);
		fillTextElementBox(emailtxtBox, email);
		fillTextElementBox(passtxtBox, passWord);
		fillTextElementBox(cptxtBox, passWord);
		clickbutton(regBtn);
	}
	
	public void OpenLogInPage() {
		clickbutton(loginlink);
	}
	
}
