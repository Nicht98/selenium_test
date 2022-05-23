Feature: Login feature

    Scenario Outline: Login successfully
        Given User is on the login page
        When User enters his credentials "<email>" "<password>"
        Then Homepage is opened

        Examples:
            | email                             | password    |
            | sehajpreet2.nicholi@orperfect.com | hqqps2J$    |