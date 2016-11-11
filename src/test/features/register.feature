Feature: Register

  as a guest user

  I want to register an user account



  Scenario: Successfully registered

    Given the username is "newuser" and the email is "email@email.de" and the password "12345678"

    When the register button is clicked

    Then the register page is shown and the cssSelector is "alert-success" and the message is "Willkommen! Die Registrierung war erfolgreich."



  Scenario: Register failed

    Given the username is "" and the email is "email@email.de" and the password "1"

    When the register button is clicked

    Then the register page is shown


  Scenario: Email is already stored in Database
    Given the username is "newuser" and the email is "test@test.de" and the password "123456"
    When the register button is clicked
    Then an Registrationerror with the message "Es existiert bereits ein Account mit dieser Mailadresse." is shown