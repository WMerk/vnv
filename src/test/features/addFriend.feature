Feature: Add friend
  As a logged in user
  I want to add a friend

  Scenario: Add friend successful
    Given a registerd user named "add friend" with email "add@friend.de" and password "test"
    And logged in to add a friend with the email "add@friend.de" and the password "test"
    When I want to add "test" and click on the button
    Then the buttontext changes to "Anfrage versendet"