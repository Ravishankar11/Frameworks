Feature: Buy Giftcards


Scenario: Buying Giftcards
Given user is on home page
When user clicks on giftcards
When user adds two giftcards
When user clicks on add to cart
When user clicks on checkout
Then payment page appears
And test closes