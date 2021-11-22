Feature: Buy DC Merchandise using Actions


Scenario: Buying DC Merchandise
Given user is on home page
When user moves to official merchandise
When user clicks on Official DC Merchandise
When user selects Superman shaker bottle
When user clicks on add to cart
When user clicks on checkout
Then payment page appears
And test closes