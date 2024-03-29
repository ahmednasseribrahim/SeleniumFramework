package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends HomePage{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Print")
	WebElement printLink;
	public void selectPrintOrderButton()
	{
		clickbutton(printLink);
	}
	@FindBy(linkText = "PDF Invoice")
	WebElement pdfInvoiceLink;
	public void selectPdFInvoiceButton(){
		clickbutton(pdfInvoiceLink);
	}

}
