package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelDataReader;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithExcelDataAndDDT extends TestBase {
	
	
	HomePage homeObj;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	
	@DataProvider(name = "UserExcelData")
	public Object[][] userExcelData() throws IOException{
		ExcelDataReader dataReader = new ExcelDataReader();
		return dataReader.GetExcelUserData();
	}
	@Test(priority = 1,dataProvider = "UserExcelData")
	public void userCanRegisterSuccessfully(String firstName, String lastName, String email,String password)
	{
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(firstName, lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().contains("Your registration completed"));
		regObj.OpenLogInPage();
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, password);
		Assert.assertTrue(homeObj.logOutLink.getText().contains("Log out"));
		homeObj.userLogOut();
	}
	
	
	
}
