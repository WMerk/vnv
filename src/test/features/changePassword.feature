Feature: Change Password
  As a logged in user
  I want to change my password


  Scenario: Change Password successful
    Given a registerd user named "change password" with email "change@password.de" and password "test"
    And login to change the password with the email "change@password.de" and the password "test"
    And navigate to password settings
    And the actual password "test" new password "test" and confirm password "test" is entered
    When the change password button is clicked
    Then the message "Das Passwort wurde erfolreich geändert." form element with id "successChangePassword" is shown

  Scenario: Change Password failed
    Given login to change the password with the email "change@password.de" and the password "test"
    And navigate to password settings
    And the actual password "falsePW" new password "test" and confirm password "test" is entered
    When the change password button is clicked
    Then the message "Das eingegebene aktuelle Passwort ist nicht korrekt." form element with id "errorChangePassword" is shown

  Scenario: Cleanup
    Then login and delete the registered user with the email "change@password.de" and the password "test" from database again