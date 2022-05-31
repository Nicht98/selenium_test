Feature: Add a product to whislist

  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario Outline:

    Given user at the homePage
    When User add "<product>" to whislist
    Then the whislist is update
    Examples:
      |product|
      |chaise |
      |ampoule|

