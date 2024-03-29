Feature: User Registration
	The User Can register to our E-commerce WebApplication to Buy his needs
	@Register
	Scenario Outline: User Can Register Successfully
	Given The User is in the Home Page
	When He Clicks The Register Link
	And He enters "<firstname>" ,  "<lastname>" , "<email>" , "<password>"
	Then The Successfully Registration Page Displayed
	Examples:
	| firstname | lastname | email | password |
	| mohamed | ebrahim | test@test.com | 1234567 | 