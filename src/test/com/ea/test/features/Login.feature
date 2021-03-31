Feature: LoginFeature
  This feature is responsible for testing all the scenarios for Login of application

  Scenario: Check Login with correct username and password
    Given I ensure application opened
    When I enter UserName and Password
      | UserName | Password |
      | Admin    | admin123 |
    And I click login button
#    Then I should see the username with hello
    And I click welcome link
    And I click logout button
    Then I should see Login Page