package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productLink;
	
	public void OpenProudctDetails() {
		clickbutton(productLink);
	}
	

}
