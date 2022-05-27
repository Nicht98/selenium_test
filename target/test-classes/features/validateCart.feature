Feature: Validate cart

  Scenario:
    Given User is on cart page
    When User click on button 'validate my cart'
    Then User should see payment page
