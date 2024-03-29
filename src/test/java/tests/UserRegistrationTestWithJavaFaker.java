package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {
	
	
	HomePage homeObj;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();;
		
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(firstName, lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().contains("Your registration completed"));
		regObj.OpenLogInPage();
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, password);
		Assert.assertEquals(homeObj.logOutLink.getText(),"Log out");
		homeObj.userLogOut();
	}
	
	
}
