Feature: Contacting for clarifications


Scenario: Filling the contact form
Given user is on home page
When user moves to footer and clicks contact us
Then user enters all details
And confirmation is verified
And test closes