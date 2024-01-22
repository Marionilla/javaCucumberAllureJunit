Feature: Login, shopping and Checkout

  Scenario: Login, add products to cart and checkout
    Given I am on the saucedemo site
    When I enters correct "problem_user" and "secret_sauce"
    And I clicks the login button
    And I go to the inventory list
    And I go to the cart
    And I proceed to checkout
    And I fill in the first name as "Bogdan"
    And I fill in the last name as "Mykhailov"
    And I fill in the zip code as "21012"
    And I continue
    And I finish
    Then I should see a confirmation page