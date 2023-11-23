Feature: Testing

  Scenario Outline: Test Login with Boundary Passwords
    Given User is on the login page
    When User enters "<username>" and password "<password>"
    And User clicks the login button
    Then User should see "<result>"

    Examples:
      | username | password | result|
    | problem_user | secret_sauc | Epic sadface: Username and password do not match any user in this service |
    | problem_user | secret_saucee | Epic sadface: Username and password do not match any user in this service |
    | problem_user | secret_sauce | inventory.html |