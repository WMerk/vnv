Feature: Search friend
  As a logged in user
  I want to search for a friend

  Scenario: search friend successful
    Given a registerd user named "search friend" with email "search@friend.de" and password "test"
    And login to search a friend with the email "search@friend.de" and the password "test"
    And I am on the add friends page
    When I type "test" in the searchfield
    Then I find my friend "test user"

  Scenario: search friend failed
    Given login to search a friend with the email "search@friend.de" and the password "test"
    And I am on the add friends page
    When I type "not_a_Friend" in the searchfield
    Then I find no entry in list



