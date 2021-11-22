Feature: Checking for COD Availability for given pincode


Scenario: Checking for COD Availability
Given user is on home page
When user clicks on all gifts
When user selects auto rickshaw pen stand
When user enters <pincode>
Then availability text appears
And test closes