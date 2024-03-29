package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductToFriendPage extends HomePage {

	public EmailProductToFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	@FindBy(id = "YourEmailAddress")
	WebElement yourEmailTxt;
	@FindBy(id = "PersonalMessage")
	WebElement msgTxt;
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendMsgBtn;
	@FindBy(css = "div.result")
	public WebElement msgSentSuccess;
	
	public void sendEmailtoFriend(String femail , String yremail , String message) {
		fillTextElementBox(friendEmailTxt, femail);
		clearTextElementBox(yourEmailTxt);
		fillTextElementBox(yourEmailTxt, yremail);
		fillTextElementBox(msgTxt, message);
		clickbutton(sendMsgBtn);
		
	}

}
