Feature: Adding itms to wishlist


Scenario: adding gifts to wishlist
Given user is on home page
When user clicks on any gift
When user adds gift to wishlist
When user navigates to homepage
When user clicks on wishlist
Then verifies the items
And test closes