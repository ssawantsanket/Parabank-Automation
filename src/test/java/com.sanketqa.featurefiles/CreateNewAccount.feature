Feature: Open New Account

Background:
	Given  user navigating to login page
	When  user should enter username and password
	And click on login button
	
Scenario: Open New Account
	
	* CLick on Open new Account
	* Select Savings account from dropdown
	* Select exiating account from dropdown	
	* Click on create new account button
	Then Account should be created and Account no should be displayed
	* Close the browser