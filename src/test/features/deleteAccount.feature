Feature: Delete Account
  As a logged in user
  I want to delete my account in vnv

  Scenario: Delete account successful
    Given a registerd user named "delete user" with email "deleteuser@mail.de" and password "test"
    And login with the email "deleteuser@mail.de" and the password "test"
    And the settings are selected
    And the delete account settings is selected
    When the delete Account button is clicked
    And the confirmation with the password "test" is done
    Then the mainpage with the message "Schade, dass du uns verlässt! Dein Account wurde gelöscht." is shown

  Scenario: Delete account failed
    Given a registerd user named "delete user" with email "deleteuser@mail.de" and password "test"
    And login with the email "deleteuser@mail.de" and the password "test"
    And the settings are selected
    And the delete account settings is selected
    When the delete Account button is clicked
    And the confirmation with the password "false password" is done
    Then an error message "Das eingegebene Passwort ist nicht korrekt." is shown



