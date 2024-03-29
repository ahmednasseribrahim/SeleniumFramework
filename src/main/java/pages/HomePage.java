package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{
	//Constructor 
	public HomePage(WebDriver driver) 
	{
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
	}
	
	//Open Registration Page
	@FindBy(linkText = "Register")
	WebElement registerlink;
	
	public void OpenRegistrationPage() {
		clickbutton(registerlink);
	}
	
	//Open LogIn Page
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	public void OpenLogInPage() {
		clickbutton(loginlink);
	}
	
	//User LogOut 
	@FindBy(css = "a.ico-logout")
	public WebElement logOutLink;
	public void userLogOut()
	{
		clickbutton(logOutLink);
	}
	
	//Default Search 
	@FindBy(id ="small-searchterms")
	WebElement searchTxtBox;
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	public void searchForProduct(String productName) {
		fillTextElementBox(searchTxtBox, productName);
		clickbutton(searchBtn);
	}
	
	//Auto Suggestion Search
	@FindBy(id = "ui-id-1")
	public List<WebElement> autoSuggestlist;
	public void autoSuggestSearch(String partialProductName) {
		fillTextElementBox(searchTxtBox, partialProductName);
		clickbutton(autoSuggestlist.get(0));
	}
	
	//Open Contact Us
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	public void OpenContactUsPage() {
		ScrolltoFooter();
		clickbutton(contactUsLink);
	}
	
	//Change Currency
	@FindBy(id = "customerCurrency")
	WebElement currencyDDL;
	public void selectCurrency() {
		select = new Select(currencyDDL);
		select.selectByVisibleText("Euro");
	}
	
	//HoverMenu
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computersMenu;
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebooksLink;
	public void selectNotebooks() {
		action.moveToElement(computersMenu)
		.moveToElement(notebooksLink)
		.click()
		.build()
		.perform();
	}
	

}
