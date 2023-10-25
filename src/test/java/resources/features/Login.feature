@FirstRelease
Feature: Login to SauceDemo
  As a registered user
  I want to log in to my account
  So that I can access the application's features

  @Positive
  Scenario Outline: Successful login
    Given I am on the SauceDemo login page
    When I enter my valid username <username> and password <password>
    And I click the login button
    Then I should be redirected to the Products page

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |
      | performance_glitch_user | secret_sauce  |

  @Negative
  Scenario Outline: Unsuccessful login with incorrect credentials
    Given I am on the SauceDemo login page
    When I enter an invalid username <username> and password <password>
    And I click the login button
    Then I should see an error message Epic sadface: Username and password do not match any user in this service
    Examples:
      | username                | password             |
      | failed_user             | failed_secret_sauce  |
      | failed_glitch_user      | failed_password      |

  @Negative
  Scenario: Unsuccessful login with empty fields
    Given I am on the SauceDemo login page
    When I leave the username and password fields empty
    And I click the login button
    Then I should see an error message Epic sadface: Username is required
