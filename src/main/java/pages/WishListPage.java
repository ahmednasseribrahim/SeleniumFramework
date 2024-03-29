package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends HomePage{

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataMsg;
	
	//Remove Product From WishList
	@FindBy(css = "button.remove-btn")
	WebElement removeFromListBtn;
	public void removeProductFromWishList()
	{
		clickbutton(removeFromListBtn);
	}
	
	//Change Quantity Of Product in WishList
	@FindBy(css = "input.qty-input")
	WebElement quantityTxt;
	public void ChangeQuantityOftheProduct(String qunTxt)
	{
		clearTextElementBox(quantityTxt);
		fillTextElementBox(quantityTxt, qunTxt);
	}
	
	//Update Wish List
	@FindBy(id = "updatecart")
	WebElement updateWishlistBtn;
	public void updateWishList()
	{
		clickbutton(updateWishlistBtn);
	}

}
