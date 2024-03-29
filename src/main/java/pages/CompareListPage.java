package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends HomePage{

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "div.page-title")
	public WebElement comparePagetitle;
	@FindBy(partialLinkText = "Apple MacBook")
	public WebElement productOneNameLink;
	@FindBy(partialLinkText = "Asus")
	public WebElement productTwoNameLink;
	
	//Clear Compare List
	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;
	@FindBy(css = "div.no-data")
	public WebElement compareListEmptyMsg;
	public void clearCompareList()
	{
		clickbutton(clearListBtn);
	}
	
	//Remove Product From Compare List
	@FindBy(css = "button.button-2.remove-button")
	WebElement removeProductBtn;
	public void removeProductFromCompareList() {
		clickbutton(removeProductBtn);
	}
	
	//Get All Comparison Table
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	@FindBy(tagName = "td")
	List<WebElement> allData;
	public void CompareProducts()
	{
		for(WebElement data : allRows) {
			System.out.println(data.getText()+"  "+"\t");
		}
	}

}
