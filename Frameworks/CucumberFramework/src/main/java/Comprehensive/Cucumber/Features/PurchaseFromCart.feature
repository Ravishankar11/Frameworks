Feature: Purchasing from cart


Scenario: purchasing gifts which were added to cart
Given user is on home page
When user clicks on top50 gifts
When user sorts by best selling
When user clicks on mug and adds to cart
When user navigates to cart
When clicks on checkout
Then payment page appears
And test closes