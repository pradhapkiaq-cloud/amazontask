Feature: Cart Page Validation

Background: 
Given User launch the Application

Scenario Outline: user successfully validates the cart page

When user search the first "<Product>"
And user clicks the first product and add to cart
And user searches the second Product
And user clicks the second product and add to cart
And user clicks the cart button and get the product details





Examples:
|               Product                   |
|        boAt Ultima Vogue 2              |






