Feature: Register
  as a guest user
  I want to register an user account

  Scenario: Successfully registered
    Given the username is "vorname nachname" and the email is "registeruser@mail.de" and the password "test"
    When the register button is clicked
    Then the register page is shown and the cssSelector is "alert-success" and the message is "Willkommen! Die Registrierung war erfolgreich."

  Scenario: Register failed
    Given the username is "" and the email is "email@email.de" and the password "1"
    When the register button is clicked
    Then the register page is shown

  Scenario: Email is already stored in Database
    Given the username is "vorname nachname" and the email is "registeruser@mail.de" and the password "test"
    When the register button is clicked
    Then an Registrationerror with the message "Es existiert bereits ein Account mit dieser Mailadresse." is shown

  Scenario: Cleanup
    Then login and delete the registered user with the email "registeruser@mail.de" and the password "test" from database again