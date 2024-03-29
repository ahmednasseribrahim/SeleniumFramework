package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddToShoppingCartTest extends TestBase{
	HomePage homeObj;
	ProductDetailsPage detailsObj;
	CartPage cartObj;
	
	String productName = ""; 
	
	@Test
	public void AddToCartTest() {
		homeObj = new HomePage(driver);
		homeObj.autoSuggestSearch("mac");
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.addToCart();
		detailsObj.OpenShoppingCart();
		cartObj = new CartPage(driver);
		Assert.assertTrue(cartObj.pageTitle.getText().equalsIgnoreCase("Shopping cart"));
		Assert.assertTrue(cartObj.productName.getText().contains("MacBook"));
		cartObj.changeQuantityOfProductInCart("3");
		cartObj.updateCart();
		Assert.assertEquals(cartObj.totalPrice.getText(), "$5,400.00");
		cartObj.removeProductFromCart();
		Assert.assertTrue(cartObj.emptyCartMsg.getText().contains("empty"));
		
	}
}
