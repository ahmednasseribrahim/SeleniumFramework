package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddProductToCompareListTest extends TestBase{
	HomePage homeObj;
	ProductDetailsPage detailsObj;
	CompareListPage compareObj;
	String product1 = "Apple MacBook Pro 13-inch";
	String product2 = "Asus N551JK-XO076H Laptop";

	@Test(priority = 1)
	public void UserCanSearchForProduct()
	{
		homeObj= new HomePage(driver);
		homeObj.autoSuggestSearch("mac");
	}

	@Test(priority = 2)
	public void UserCanAddProductToCompareList() {
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().contains("MacBook"));
		detailsObj.addToCompareList();
		Assert.assertTrue(detailsObj.compareListnotificationMsg.getText().
				contains("The product has been added to your"));
		detailsObj.openCompareListPage();
	}
	@Test(priority = 3)
	public void UserCanCheckCompareList() {
		compareObj = new CompareListPage(driver);
		Assert.assertTrue(compareObj.comparePagetitle.isDisplayed());
		Assert.assertTrue(compareObj.productOneNameLink.getText().contains("MacBook"));
		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.compareListEmptyMsg.getText()
				.contains("You have no items to compare"));
	}

}
