@clearCart

Feature: Clear all the element in the cart

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario:
    Given homePage active
    When user click on cart_icon
    And delete items inside it
    Then the items a no more visible
