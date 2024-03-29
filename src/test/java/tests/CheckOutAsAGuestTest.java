package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CheckOutAsAGuestTest extends TestBase{
	HomePage homeObj;
	SearchPage searchObj;
	ProductDetailsPage detailsObj;
	CartPage cartObj;
	CheckOutPage checkOutObj;
	OrderDetailsPage orderObj;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void GuestCanSearchForProduct() {
		homeObj = new HomePage(driver);
		homeObj.searchForProduct(productName);
		searchObj = new SearchPage(driver);
		Assert.assertTrue(searchObj.productLink.getText().contains(productName));
		searchObj.OpenProudctDetails();
	}
	@Test(priority = 2)
	public void GuestCanAddProductToCart() {
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().equalsIgnoreCase(productName));
		detailsObj.addToCart();
		detailsObj.OpenShoppingCart();
		cartObj = new CartPage(driver);
		cartObj.changeQuantityOfProductInCart("2");
		cartObj.updateCart();
		Assert.assertEquals(cartObj.totalPrice.getText(), "$3,600.00");
		cartObj.CheckOutForProductInCart();
	}
	@Test(priority = 3)
	public void GuestCanCheckOutForProduct() {
		checkOutObj = new CheckOutPage(driver);
		checkOutObj.checkOutAsAGuest();
		checkOutObj.enterFirstName("ahmed");
		checkOutObj.enterLastName("mohamed");
		checkOutObj.enterEmail("am@test.com");
		checkOutObj.selectCountry();
		checkOutObj.addCity("cairo");
		checkOutObj.addFirstAddress("cairo");
		checkOutObj.addZipPostalCode("11511");
		checkOutObj.addPhoneNumber("01124567893");
		checkOutObj.clickUserInfoContinue();
		checkOutObj.selectShippingOption();
		checkOutObj.clickConfirmShippingOption();
		checkOutObj.selectPaymentMethod();
		checkOutObj.clickConfirmPaymentMethod();
		checkOutObj.clickConfirmPaymentInfo();
		Assert.assertEquals(checkOutObj.valueSummary.getText(), "$3,600.00");
		checkOutObj.clickConfirmOrder();
		Assert.assertTrue(checkOutObj.orderSuccessMsg.isDisplayed());
		checkOutObj.showOrderDetails();
		
		//checkOutObj.clickCompletedOrderButton();
	}
	@Test(priority = 4)
	public void GuestCanDownloadAndShowOrderDetails() throws InterruptedException {
		orderObj = new OrderDetailsPage(driver);
		orderObj.selectPdFInvoiceButton();
		orderObj.selectPrintOrderButton();
		Thread.sleep(2000);
	}

}
