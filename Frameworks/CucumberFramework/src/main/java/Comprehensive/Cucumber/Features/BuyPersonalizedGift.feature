Feature: Buying Customizable gifts


Scenario: Buying Personalized gifts
Given user is on home page
When user clicks on personalized gifts
When user selects customizable bottle
When user changes bottle color
When user enters <customname>
When user adds to cart
Then user checks for current url
And test closes