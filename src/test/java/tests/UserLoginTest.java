package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLogInPage;

public class UserLoginTest extends TestBase {
	
	
	HomePage homeObj;
	UserLogInPage loginObj;
	
	@Test
	public void UserCanLoginSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenLogInPage();
		
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin("testmail1@gmail.com", "123456");
	}
	@Test(dependsOnMethods = {"UserCanLoginSuccessfully"},enabled = false)
	public void RegistereduserLogOut()
	{
		loginObj.userLogOut();
	}

}
