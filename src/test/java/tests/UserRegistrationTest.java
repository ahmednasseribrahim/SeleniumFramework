package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObj;
	UserRegistrationPage regObj;
	public String firstName = "Ahmed";
	public String lastName = "Nasser";
	public String email="testmail1@gmail.com";
	public String password ="123456";
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();;
		
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(firstName, lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().contains("Your registration completed"));
		
	}
	
	
}
