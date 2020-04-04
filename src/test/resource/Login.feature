Feature: Automation test Practice website login feature


  Scenario: Verify Login button
    Given Navigate to website
    When I enter incorrect username and password
      | chandra.04.08@gmail.com | Password1 |
    Then I verify user is not able to login in