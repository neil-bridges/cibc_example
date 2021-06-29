Feature: selenium Demo Page

Scenario: User enters message into field
Given Message gets entered
When Show message button entered	
Then Message gets shown

Scenario: User fills in two Input fields
Given User enters value for all the required fields
When Clicks on the Get total button		
Then Total Message gets shown

#Scenario: User Edits the details of an already added Customer
#Given Edit Customer Page is displayed		
#When Search for the Customer 
#And  Edit the Details	
#Then Customer's details gets updated
#
#Scenario: User Creates a new account for an already added Customer
#Given New Account Page is displayed		
#When Provide the Details	
#Then Customer's account details gets updated



