Feature: Automation test Practice website

  Scenario: Verify Search button

    Given Navigate to website
    When  user enters summer "dress"
    Then User should be navigated to summer dress page


  Scenario: Verify element added to cart

    Given Navigate to website
    When I Click on an item
    Then I verify its in cart


  Scenario: Navigate to t shirt section from Women

    Given Navigate to website
    When I Click on t shirt of women section
    Then I verify am navigated to t shirt page


  Scenario: Verify navigate to shopping website

    Given Navigate to website
    When I click on filter icons
    Then I verify I am navigated to filtered website

