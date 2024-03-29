package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObj;
	UserLogInPage loginObj;
	MyAccountPage myAccObj;
	UserRegistrationPage regObj;
	
	public String firstName = "Ahmed";
	public String lastName = "Nasser";
	public String email="testmail1@gmail.com";
	public String password ="123456";
	String newPassword ="012345678";
	@Test(priority = 1,enabled = false)
	public void userCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();;
		
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(firstName, lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void UserCanLoginSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenLogInPage();
		
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, password);
	}
	
	@Test(priority = 3)
	public void LoggedInUserCanChangePassword()
	{
		myAccObj = new MyAccountPage(driver);
		loginObj.OpenmyAccount();
		myAccObj.OpenChangePasswordPage();
		myAccObj.ChangePassword(password, newPassword);
		Assert.assertTrue(myAccObj.notifiBar.isDisplayed());
		System.out.println(myAccObj.notifiBar.getText());
		myAccObj.closeNotify.click();
		driver.navigate().refresh();
		
	}
	@Test(priority = 4,enabled = false)
	public void RegistereduserLogOut()
	{
		Assert.assertTrue(myAccObj.logoutLink.isEnabled());
		System.out.println(myAccObj.logoutLink.getText());
		myAccObj.userLogOut();
	}
	@Test(priority = 5,enabled = true)
	public void UserCanLoginWithNewPassword()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenLogInPage();
		
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, newPassword);
	}
}
