package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends HomePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productSearchSequence;
	
	@FindBy(id = "price-value-4")
	public WebElement priceValue;
	
	//Open Email To Friend Page
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailAFriendBtn;
	public void openEmailaFriendPage() {
		clickbutton(emailAFriendBtn);
	}
	
	//Open Write ReviewPage
	@FindBy(linkText = "Add your review")
	WebElement reviewLink;
	public void openAddReviewPage() {
		clickbutton(reviewLink);
	}
	
	//Add To WishList
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "p.content")
	public WebElement wishListnotificationMsg;
	
	public void addToWishList() {
		clickbutton(addToWishListBtn);
	}
	//Open Wish List Page
	@FindBy(linkText = "wishlist")
	public WebElement wishListLink;
	public void OpenWishListPage()
	{
		clickbutton(wishListLink);
	}
	
	//Add to Compare List
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	public void addToCompareList() {
		clickbutton(addToCompareBtn);
	}
	@FindBy(css = "div.bar-notification.success")
	public WebElement compareListnotificationMsg;
	//Open Compare List
	@FindBy(linkText = "product comparison")
	WebElement compareListLink;
	public void openCompareListPage()
	{
		clickbutton(compareListLink);
	}
	
	//Add To Cart
	@FindBy(id = "add-to-cart-button-4")
	WebElement addtocartBtn;
	public void addToCart() {
		clickbutton(addtocartBtn);
	}
	//Open Shopping Cart
	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartLink;
	public void OpenShoppingCart() {
		clickbutton(shoppingCartLink);
	}
}
