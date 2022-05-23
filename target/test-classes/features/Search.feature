@search
Feature:
  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi3@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario Outline:
    Given User is on HomePage
    When User enter a "<product>" in search bar
    Then User should see a page display with choosen product results

    Examples:
      |product     |
      |Parfum      |
