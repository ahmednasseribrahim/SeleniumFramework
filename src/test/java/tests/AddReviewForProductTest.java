package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class AddReviewForProductTest extends TestBase{
	
	HomePage homeObj;
	ProductDetailsPage detailsObj;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	AddReviewPage AddrevObj;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();
	
	@Test(priority = 1,enabled = true)
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
	}
	@Test(priority = 2)
	public void UserCanSearchForHisProduct()
	{
		homeObj = new HomePage(driver);
		homeObj.autoSuggestSearch("mac");
	}
	
	@Test(priority = 3)
	public void UserCanAddReviewTest() {
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().contains("MacBook"));
		detailsObj.openAddReviewPage();
		AddrevObj = new AddReviewPage(driver);
		AddrevObj.writeReview("My Review", "Very Useful Product");
		Assert.assertTrue(AddrevObj.reviewSuccessMsg.getText()
				.contains("Product review is successfully added."));
		
	}
	@Test(priority = 4, enabled = true)
	public void userLogOut()
	{
		loginObj.userLogOut();
	}

}
