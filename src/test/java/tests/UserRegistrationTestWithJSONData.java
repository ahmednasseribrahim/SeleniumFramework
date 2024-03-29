package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJSONData extends TestBase {
	
	
	HomePage homeObj;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	JsonDataReader reader;
	
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		reader = new JsonDataReader();
		reader.jsonReader();
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(reader.firstname, reader.lastname, reader.email, reader.password);
		Assert.assertTrue(regObj.successMsg.getText().contains("Your registration completed"));
		regObj.OpenLogInPage();
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(reader.email, reader.password);
		Assert.assertEquals(homeObj.logOutLink.getText(),"Log out");
		homeObj.userLogOut();
		
	}
	
	
}
