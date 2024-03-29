package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchForProductTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	HomePage homeObj;
	SearchPage searchPageObj;
	ProductDetailsPage detailsObj;
	
	
	@Test
	public void proudctSearchTest() {
		homeObj = new HomePage(driver);
		homeObj.searchForProduct(productName);
		searchPageObj = new SearchPage(driver);
		Assert.assertTrue(searchPageObj.productLink.getText().equalsIgnoreCase(productName));
		searchPageObj.OpenProudctDetails();
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productSearchSequence.getText().equalsIgnoreCase(productName));
	}
}
