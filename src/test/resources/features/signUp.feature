Feature:
  Scenario Outline:
    Given I am on the registration page
    When I fill in email field with "<email>" "<password>" "<confPass>"
    And I click on the button Inscription
    Then The homepage is displayed
    Examples:
      | email                             | password   | confPass|
      | sehajpreet2.nicholi3@orperfect.com | hqqps2J$   | hqqps2J$|
