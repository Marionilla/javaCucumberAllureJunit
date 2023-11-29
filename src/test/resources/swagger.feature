
Feature: Testing API

  Scenario: Creating, updating, and deleting a user


  When the user sends a POST request to create a new user with the name "mmm"
  Then the response should contain the username "mmm"

    When the user sends a PUT request to update the information about the user "mmm" with the new name "mmm_updated"
    Then the response should contain the updated username "mmm_updated"

  When the user sends a DELETE request to delete the user with the name "mmm_updated"
  Then the response should not contain the username "mmm_updated"

