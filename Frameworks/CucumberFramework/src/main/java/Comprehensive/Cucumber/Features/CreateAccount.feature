Feature: Registering a new user


Scenario: creating an account
Given user is on home page
When user clicks on signin
When user clicks on create account
Then user enters all details
And user clicks on create account button
And test closes