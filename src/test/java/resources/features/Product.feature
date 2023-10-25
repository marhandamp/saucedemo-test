Feature: Browse and Add Products to Cart
  As a logged-in user
  I want to browse products and add them to my cart
  So that I can make purchases

  Background:
    Given I am on the SauceDemo login page
    When I enter my valid username standard_user and password secret_sauce
    And I click the login button
    Then I should be redirected to the Products page

  @Positive
  Scenario: View product details and add to cart
    When I click on a product
    And I view its details
    And I add it to the cart
    Then the cart icon should display the correct number of items

  @Positive
  Scenario: Remove a product from the cart
    When I click Add to cart button
    Given I have added a product to the cart
    When I go to the cart
    And I remove the product from the cart
    Then the cart should be empty