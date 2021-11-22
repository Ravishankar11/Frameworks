Feature: search for item and buy


Scenario: searching for gift using keyword
Given user is on home page
When user clicks on search and sends the <keyword>
When user adds more quantities
Then user adds to cart
And test closes