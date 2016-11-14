Feature: Login

  Scenario: Login successful
    Given the email is "test@test.de" and the password "test"
    When the login button is clicked
    Then the main page is shown

  Scenario: Login failed
    Given the email is "test@test.de" and the password "falsePassword"
    When the login button is clicked
    Then an login error with the message "Falscher Username oder Passwort." is shown

  Scenario: Login failed
    Given the email is "false@Email" and the password "test"
    When the login button is clicked
    Then an login error with the message "Falscher Username oder Passwort." is shown