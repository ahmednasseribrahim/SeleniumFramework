package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	public Alert alert;

	// Create Constructor

	public PageBase(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	//Click Button Method
	protected static void clickbutton(WebElement button)
	{
		button.click();
	}
	//Fill Text Boxes Method
	protected static void fillTextElementBox(WebElement textElement , String elementValue)
	{
		textElement.sendKeys(elementValue);
	}
	//Clear TextBoxes Method
	protected static void clearTextElementBox(WebElement textElement) {
		textElement.clear();
	}
	//Scroll To Footer Of the Page
	public void ScrolltoFooter() {
		jse.executeScript("scrollBy(0,2500)");
	}
}
