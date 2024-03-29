package steps;

import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserLogInPage;
import tests.TestBase;

public class UserLoginSteps extends TestBase{
	HomePage homeObj;
	UserLogInPage loginObj;

	@Given("The User is in the Home Page To Login")
	public void the_user_is_in_the_home_page_to_login() {
	   homeObj = new HomePage(driver);
	   homeObj.OpenLogInPage();
	}
	@When("He Clicks The LogIn Link")
	public void he_clicks_the_log_in_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
	@When("Enters His {string} , {string}")
	public void enters_his(String email, String password) {
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, password);
	}
	@Then("The Successfully LogIn and Home Page Displayed")
	public void the_successfully_log_in_and_home_page_displayed() {
	    homeObj = new HomePage(driver);
	}
}
