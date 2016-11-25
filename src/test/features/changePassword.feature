Feature: Change Password
  As a logged in user
  I want to change my password


  Scenario: Change Password successful
    Given a registerd user named "change password" with email "change@password.de" and password "test"
    And login to change the password with the email "change@password.de" and the password "test"
    And navigate to password settings
    When the actual password "test" new password "1234" and confirm password "1234" is entered
    And the change password button is clicked
    Then the message "" is shown