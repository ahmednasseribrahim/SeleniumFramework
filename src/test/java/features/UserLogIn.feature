Feature: User Login
  The User Can Login With His Registered Account To Buy His Needs
 	@login
  Scenario Outline: User Can LogIn Successfully
    Given The User is in the Home Page To Login
    When He Clicks The LogIn Link
    And Enters His "<email>" , "<password>"
    Then The Successfully LogIn and Home Page Displayed
    Examples: 
      | email  | password | 
			|	test@test.com | 1234567 |