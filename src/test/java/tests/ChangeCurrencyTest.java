package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage homeObj ;
	ProductDetailsPage detailsObj;
	
	@Test
	public void CurrencyTest()
	{
		homeObj = new HomePage(driver);
		homeObj.selectCurrency();
		homeObj.autoSuggestSearch("mac");
		detailsObj = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.priceValue.getText().contains("€"));
		System.out.println(detailsObj.priceValue.getText());
	}

}
