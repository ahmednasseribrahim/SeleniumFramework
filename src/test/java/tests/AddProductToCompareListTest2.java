package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddProductToCompareListTest2 extends TestBase{
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
		detailsObj = new ProductDetailsPage(driver);
		
		Assert.assertTrue(detailsObj.productSearchSequence.getText().contains(product1));
		detailsObj.addToCompareList();
		Assert.assertTrue(detailsObj.compareListnotificationMsg.getText().
				contains("The product has been added to your"));
		
		homeObj.autoSuggestSearch("Asus");
		Assert.assertTrue(detailsObj.productSearchSequence.getText().contains(product2));
		detailsObj.addToCompareList();
		Assert.assertTrue(detailsObj.compareListnotificationMsg.getText().
				contains("The product has been added to your"));
		
		detailsObj.openCompareListPage();
		compareObj = new CompareListPage(driver);
		Assert.assertTrue(compareObj.comparePagetitle.isDisplayed());
		Assert.assertTrue(compareObj.productOneNameLink.getText().contains("MacBook"));
		Assert.assertTrue(compareObj.productTwoNameLink.getText().contains("Asus"));
		compareObj.CompareProducts();
		
		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.compareListEmptyMsg.getText()
				.contains("You have no items to compare"));
	}


}
