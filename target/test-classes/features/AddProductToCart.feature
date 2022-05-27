@addProduct
Feature: add a product to the cart

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario:
    Given user at the HomePage
    When select a product to cart
    And add to cart
    Then the cart is update

