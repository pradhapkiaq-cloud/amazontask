Feature: User validates the product ratings

Scenario: user successfully validates the product ratings

Given User launch the Application
When user search the smart watch
And user cliks the watch
And user convert the ratings into numeric
Then  the watch rating above 4.0 print name and ratings
