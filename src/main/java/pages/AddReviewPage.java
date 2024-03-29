package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingCheck;
	
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement reviewSuccessMsg;
	
	public void writeReview(String title , String revTxt) {
		fillTextElementBox(reviewTitle, title);
		fillTextElementBox(reviewTxt, revTxt);
		clickbutton(ratingCheck);
		clickbutton(submitReviewBtn);
		
	}

}
