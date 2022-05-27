Feature: decrement number of item in the cart

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario :
    Given user is on Home
    And select a product2
    When user click on decrement to button
    Then the cart quantity is decrement
