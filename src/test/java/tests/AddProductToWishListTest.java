package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{

	HomePage homeObj;
	ProductDetailsPage detailsObj;
	WishListPage wlObj;


	@Test(priority = 1)
	public void UserCanSearchForProduct()
	{
		homeObj= new HomePage(driver);
		homeObj.autoSuggestSearch("mac");
	}
	@Test(priority = 2)
	public void UserCanAddThisProductToWishList()
	{
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().contains("MacBook"));
		detailsObj.addToWishList();
		Assert.assertTrue(detailsObj.wishListnotificationMsg.getText().
				contains("The product has been added to your "));
		detailsObj.OpenWishListPage(); 
		wlObj = new WishListPage(driver);
		Assert.assertTrue(wlObj.productName.getText().contains("MacBook"));
		wlObj.ChangeQuantityOftheProduct("3");
		wlObj.updateWishList();
		wlObj.removeProductFromWishList();
		Assert.assertTrue(wlObj.noDataMsg.getText().contains("empty"));
	}
}
