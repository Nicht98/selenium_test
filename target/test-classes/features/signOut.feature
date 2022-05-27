@signOut
Feature: LogOut from the website
  Background:
    Given User is on the login page
    When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
    Then Homepage is opened

  Scenario:
      Given user is logIn
      When user click on SignOut button
      Then The user is disconnect