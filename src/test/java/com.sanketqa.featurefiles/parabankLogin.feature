Feature: Login functionality

Background:
	Given  user navigating to login page
	When  user should enter username and password
	And click on login button

Scenario:Login user valid credentials
	
	Then User should login successfully and navigate to home page
	Then Close the browser

Scenario:  View Accounts Overview
	
	And Click on Account Overview button
	Then User should login successfully and navigate to home page
	And user able to see accounts overview
	Then Close the browser
	

