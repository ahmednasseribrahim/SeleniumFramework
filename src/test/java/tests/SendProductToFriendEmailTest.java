package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailProductToFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class SendProductToFriendEmailTest extends TestBase{

	HomePage homeObj ;
	ProductDetailsPage detailsObj ;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	EmailProductToFriendPage epObj;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String femail = fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();
	/*
	 * String firstname = "ahmed", lastname = "ebrahim", email = "a2@test.com",
	 * password ="12345678", 
	 */
	String productName = "Apple MacBook Pro 13-inch";

	/*
	 * @Test public void testSendProductToFriend() { homeObj = new HomePage(driver);
	 * homeObj.OpenRegistrationPage();;
	 * 
	 * regObj = new UserRegistrationPage(driver); regObj.userRegistration(firstName,
	 * lastName, email, password); Assert.assertTrue(regObj.successMsg.getText().
	 * contains("Your registration completed")); regObj.OpenLogInPage(); loginObj =
	 * new UserLogInPage(driver); loginObj.userLogin(email, password);
	 * homeObj.autoSuggestSearch("mac"); detailsObj = new
	 * ProductDetailsPage(driver);
	 * Assert.assertTrue(detailsObj.productSearchSequence.getText().equalsIgnoreCase
	 * (productName)); detailsObj.openEmailaFriendPage(); epObj = new
	 * EmailProductToFriendPage(driver); epObj.sendEmailtoFriend(femail, email,
	 * "I Wish You Find It Useful");
	 * Assert.assertTrue(epObj.msgSentSuccess.getText().
	 * contains("Your message has been sent.")); loginObj.userLogOut();
	 * 
	 * 
	 * }
	 */
	@Test(priority = 1,alwaysRun = true)
	public void UserRegister() {
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();
		regObj = new UserRegistrationPage(driver); 
		regObj.userRegistration(firstName,lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().
				contains("Your registration completed")); 
		regObj.OpenLogInPage(); 
		loginObj =new UserLogInPage(driver); 
		loginObj.userLogin(email, password);

	}
	@Test(priority = 2)
	public void UserSearchForProduct() {
		homeObj.autoSuggestSearch("mac");
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().equalsIgnoreCase(productName)); 
	}
	@Test(priority = 3)
	public void SendEmailToFriend() {
		detailsObj.openEmailaFriendPage(); 
		epObj = new EmailProductToFriendPage(driver); 
		epObj.sendEmailtoFriend(femail, email,"I Wish You Find It Useful");
		Assert.assertTrue(epObj.msgSentSuccess.getText().contains("Your message has been sent.")); 

	}
	@Test(priority = 4)
	public void UserLogout() {
		loginObj.userLogOut();
	}

}
