Feature: Buying Manchester crest using two nested options and Actions


Scenario: Buying Manchester Crest
Given user is on home page
When user moves to category options
When user moves to person options
When user clicks on sports
When user clicks on manchester crest
Then manchester crest appears and title is checked
And test closes