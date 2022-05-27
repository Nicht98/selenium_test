@navWishlist
Feature: Navigate to whishlist

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario:
    Given user at HomePage
    When click on whilist button
    Then whislist is displayed