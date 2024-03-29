package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class CheckOutPage extends HomePage{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement checkOutAsAGuestBtn;
	public void checkOutAsAGuest()
	{
		clickbutton(checkOutAsAGuestBtn);
	}
	
	@FindBy(id = "ShipToSameAddress")
	public WebElement shipToSameAddressCheckBox;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	public WebElement firstNameTxt;
	public void enterFirstName(String fName) {
		fillTextElementBox(firstNameTxt, fName);
	}
	
	@FindBy(id = "BillingNewAddress_LastName")
	public WebElement lastNameTxt;
	public void enterLastName(String lName) {
		fillTextElementBox(lastNameTxt, lName);
	}
	
	@FindBy(id = "BillingNewAddress_Email")
	public WebElement emailTxt;
	public void enterEmail(String email) {
		fillTextElementBox(emailTxt, email);
	}
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	public void selectCountry() {
		select = new Select(countryList);
		select.selectByVisibleText("Egypt");
	}
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	public void addCity(String cityName) {
		fillTextElementBox(cityTxt, cityName);
	}
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement firstAddressTxt;
	public void addFirstAddress(String firstaddressName) {
		fillTextElementBox(firstAddressTxt, firstaddressName);
	}
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipPostalTxt;
	public void addZipPostalCode(String postalCode) {
		fillTextElementBox(zipPostalTxt, postalCode);
	}
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;
	public void addPhoneNumber(String phoneNumber) {
		fillTextElementBox(phoneNumberTxt, phoneNumber);
	}
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement infoContinueBtn;
	public void clickUserInfoContinue() {
		clickbutton(infoContinueBtn);
	}
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingOptionRdBtn;
	public void selectShippingOption()
	{
		clickbutton(shippingOptionRdBtn);
	}
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement shippingMethodContinueBtn;
	public void clickConfirmShippingOption() {
		clickbutton(shippingMethodContinueBtn);
	}
	
	@FindBy(id = "paymentmethod_0")
	WebElement paymentRdBtn;
	public void selectPaymentMethod() {
		clickbutton(paymentRdBtn);
	}
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;
	public void clickConfirmPaymentMethod() {
		clickbutton(paymentMethodContinueBtn);
	}
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;
	public void clickConfirmPaymentInfo() {
		clickbutton(paymentInfoContinueBtn);
	}
	
	@FindBy(css = "span.value-summary")
	public WebElement valueSummary;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;
	public void clickConfirmOrder() {
		clickbutton(confirmOrderBtn);
	}
	
	@FindBy(css = "div.title")
	public WebElement orderSuccessMsg;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	public void showOrderDetails() {
		clickbutton(orderDetailsLink);
	}
	
	@FindBy(css = "button.button-1.order-completed-continue-button")
	WebElement completeOrderContinueBtn;
	public void clickCompletedOrderButton() {
		clickbutton(completeOrderContinueBtn);
	}
	

}
