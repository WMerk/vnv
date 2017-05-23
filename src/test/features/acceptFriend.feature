Feature: Accept Friend
  As a logged in user
  I want to accept a friend

  Scenario: Accept friend successful
    Given a registerd user named "accept friend" with email "accept@friend.de" and password "test"
    And logged in to accept a friend with the email "accept@friend.de" and the password "test"
    When I want to accept "test" and click on the button
    Then friend is accepted and the message "success" appears