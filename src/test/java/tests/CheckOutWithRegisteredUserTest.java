package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.UserLogInPage;
import pages.UserRegistrationPage;

public class CheckOutWithRegisteredUserTest extends TestBase{
	HomePage homeObj;
	ProductDetailsPage detailsObj;
	UserRegistrationPage regObj;
	UserLogInPage loginObj;
	CartPage cartObj;
	CheckOutPage checkOutObj;
	Faker fakeData = new Faker();
	String firstName =fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();

	@Test(priority = 1,enabled = true)
	public void UserCanRegisterToBuyy() {
		homeObj = new HomePage(driver);
		homeObj.OpenRegistrationPage();
		regObj = new UserRegistrationPage(driver);
		regObj.userRegistration(firstName, lastName, email, password);
		Assert.assertTrue(regObj.successMsg.getText().contains("registration completed"));
		regObj.OpenLogInPage();
		loginObj = new UserLogInPage(driver);
		loginObj.userLogin(email, password);
	}
	@Test(priority = 2)
	public void UserCanSearchForProductToBuy() {
		homeObj = new HomePage(driver);
		homeObj.autoSuggestSearch("Mac");
	}
	@Test(priority = 3)
	public void UserCanAddProductToCart() {
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.addToCart();
		detailsObj.OpenShoppingCart();
		cartObj = new CartPage(driver);
		Assert.assertTrue(cartObj.productName.getText().contains("MacBook"));
		Assert.assertEquals(cartObj.quantityTxtBox.getAttribute("value"),"2");
		cartObj.CheckOutForProductInCart();
	}
	@Test(priority = 4)
	public void UserCanCheckOutForHisProduct() {
		checkOutObj = new CheckOutPage(driver);
		Assert.assertTrue(checkOutObj.shipToSameAddressCheckBox.isSelected());
		Assert.assertTrue(checkOutObj.firstNameTxt.getAttribute("value").contains(firstName));
		Assert.assertTrue(checkOutObj.lastNameTxt.getAttribute("value").contains(lastName));
		Assert.assertTrue(checkOutObj.emailTxt.getAttribute("value").contains(email));
		checkOutObj.selectCountry();
		checkOutObj.addCity("cairo");
		checkOutObj.addFirstAddress("cairo");
		checkOutObj.addZipPostalCode("11511");
		checkOutObj.addPhoneNumber("01234567891");
		checkOutObj.clickUserInfoContinue();
		checkOutObj.selectShippingOption();
		checkOutObj.clickConfirmShippingOption();
		checkOutObj.selectPaymentMethod();
		checkOutObj.clickConfirmPaymentMethod();
		checkOutObj.clickConfirmPaymentInfo();
		Assert.assertEquals(checkOutObj.valueSummary.getText(), "$3,600.00");
		checkOutObj.clickConfirmOrder();
		Assert.assertTrue(checkOutObj.orderSuccessMsg.isDisplayed());
		checkOutObj.clickCompletedOrderButton();
	}
	@Test(priority = 5)
	public void UserLogOut()
	{
		homeObj = new HomePage(driver);
		homeObj.userLogOut();
	}

}
