package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObj ;
	ContactUsPage contactObj;
	
	String fullName = "Ahmed Nasser"
			, email = "an@test.com"
			, enquiry = "It's For Test!";
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Contact Us Test Script")
	@Link(url = "http://google.com")
	public void ContactTest()
	{
		homeObj = new HomePage(driver);
		homeObj.OpenContactUsPage();
		contactObj = new ContactUsPage(driver);
		contactObj.ContactUs(fullName, email, enquiry);
		Assert.assertEquals(contactObj.successMsg.getText()
				, "Your enquiry has been successfully sent to the store owner.");
	}
}
