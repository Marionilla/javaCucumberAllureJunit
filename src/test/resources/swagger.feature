
Feature: Testing Petstore API

  Scenario: Retrieving user information
    Given the user has access to the Petstore API
    When the user sends a GET request to retrieve information about the user with identifier "mmm"
    Then the server should return status code 200
    And the response should contain the username "mmm"