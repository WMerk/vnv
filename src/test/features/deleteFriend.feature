Feature: Delete Friend
  As a logged in user
  I want to accept a friend

  Scenario: Delete friend successful
    Given a registerd user named "delete friend" with email "delete@friend.de" and password "test"
    And logged in to delete a friend with the email "delete@friend.de" and the password "test"
    When I want to delete "test" and click on the button
    Then friend is deleted and the message "success" appears