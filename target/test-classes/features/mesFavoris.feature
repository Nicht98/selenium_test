@mesFav
  Feature: add a product to whishlist

    Background:
      Given User is on the login page
      When User enters his credentials "sehajpreet2.nicholi@orperfect.com" "hqqps2J$"
      Then Homepage is opened

    Scenario :
      Given user is on Home
      And select a product1
      When user click on add to favoris button
      Then the product is added to whislist
      And whislist is update