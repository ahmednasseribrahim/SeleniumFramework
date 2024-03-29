package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class SearchWithAutoSuggestionTest extends TestBase{
	
	String partialProductName ="mac";
	String productName = "Apple MacBook Pro 13-inch";
	HomePage homeObj;
	ProductDetailsPage detailsObj;
	
	@Test
	public void SearchAutoSuggestTest() {
		homeObj = new HomePage(driver);
		homeObj.autoSuggestSearch(partialProductName);
		
		detailsObj = new ProductDetailsPage(driver);
		
		Assert.assertTrue(detailsObj.productSearchSequence.getText().
				equalsIgnoreCase(productName));
		
		
		
	}
	

}
