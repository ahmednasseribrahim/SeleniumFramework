package steps;

import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;


public class UserRegistrationSteps extends TestBase {
	
	HomePage homeObj;
	UserRegistrationPage rejObj;

	@Given("The User is in the Home Page")
	public void the_user_is_in_the_home_page() {
	   homeObj = new HomePage(driver);
	   homeObj.OpenRegistrationPage();
	}

	@When("He Clicks The Register Link")
	public void he_clicks_the_register_link() {
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("He enters {string} ,  {string} , {string} , {string}")
	public void he_enters(String firstname, String lastname, String email, String password) {
		rejObj = new UserRegistrationPage(driver);
		rejObj.userRegistration(firstname , lastname , email , password);
	}

	@Then("The Successfully Registration Page Displayed")
	public void the_successfully_registration_page_displayed() {
		Assert.assertTrue(rejObj.successMsg.getText().contains("Your registration completed"));
	}
}
