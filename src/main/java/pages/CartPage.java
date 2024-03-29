package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CartPage extends HomePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "div.page-title")
	public WebElement pageTitle;
	@FindBy(css = "a.product-name")
	public WebElement productName;
	@FindBy(css = "span.product-subtotal")
	public WebElement totalPrice;
	
	//Update Shopping Cart 
	@FindBy(id = "updatecart")
	WebElement updateCartBtn;
	public void updateCart() {
		clickbutton(updateCartBtn);
	}
	
	//Continue Shopping 
	@FindBy(name = "continueshopping")
	WebElement conShoppingBtn;
	public void continueShopping() {
		clickbutton(conShoppingBtn);
	}
	
	//Open Estimate Shipping POPUP
	@FindBy(id = "open-estimate-shipping-popup")
	WebElement estimateShippingBtn;
	@FindBy(css = "button.mfp-close")
	WebElement closeEstimateShippingPopUp;
	public void openEstimateShippingPopUp() {
		clickbutton(estimateShippingBtn);
		clickbutton(closeEstimateShippingPopUp);
	}
	
	//Change Quantity Of Product In Cart 
	@FindBy(css = "input.qty-input")
	public WebElement quantityTxtBox;
	public void changeQuantityOfProductInCart(String quantity) {
		clearTextElementBox(quantityTxtBox);
		fillTextElementBox(quantityTxtBox, quantity);
	}
	
	//Remove Product From Shopping Cart
	@FindBy(css = "button.remove-btn")
	WebElement removeFromCartBtn;
	public void removeProductFromCart() {
		clickbutton(removeFromCartBtn);
	}
	
	//CheckOut For Product In Cart
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceCheckBtn;
	public void CheckOutForProductInCart() {
		clickbutton(termsOfServiceCheckBtn);
		clickbutton(checkOutBtn);
	}
	
	//Change Gift Wrapping Drop Down List
	@FindBy (id = "checkout_attribute_1")
	WebElement giftWrappingDDL;
	public void changeGiftWrappingDDL() {
		select = new Select(giftWrappingDDL);
		select.selectByValue("2");
	}
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCartMsg;
	

}
