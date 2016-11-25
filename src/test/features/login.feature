Feature: Login
  As a guest user
  I want to login with my mailaddress and password

  Scenario: Login successful
    Given a registerd user named "login user" with email "login@mail.de" and password "test"
    And the email is "login@mail.de" and the password "test"
    When the login button is clicked
    Then the main page is shown
    Then the logged in user is deleted from database again

  Scenario: Login failed
    Given the email is "login@mail.de" and the password "falsePassword"
    When the login button is clicked
    Then an login error with the message "Falsche E-Mail-Adresse oder Passwort." is shown

  Scenario: Login failed
    Given the email is "false@Email" and the password "test"
    When the login button is clicked
    Then an login error with the message "Falsche E-Mail-Adresse oder Passwort." is shown