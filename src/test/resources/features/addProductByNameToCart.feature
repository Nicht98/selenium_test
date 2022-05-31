@addProductByName
Feature: add a product to the cart

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario Outline:
    Given user at the Home
    When select a product
    And add "<product>" to cart
    Then then the "<product>" is add to cart
    Examples:
      |product|
      |Chaise|
      |Ampoule|
