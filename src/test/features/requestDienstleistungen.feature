Feature: request Dienstleistung
  As a logged in user
  I want to create an offer for a service

  Scenario: create request Dienstleitung successful
    Given a registerd user named "request Dienstleistungen" with email "request@Dienstleistungen.de" and password "test"
    And request login with the email "request@Dienstleistungen.de" and the password "test"
    And the request Link "Neues Gesuch" is clicked
    And the request flavior "Dienstleistung" is selected
    And the request with offername "RequestDienstleistungstest" and the category "Haustiere" and the endtime "01.01.9999" and the description "little description" is created
    When the create request Button is clicked
    Then the request mainpage with the message "Ihr Gesuch wurde erfolgreich erstellt." in the element with id "successfulCreateRequest" is shown


  Scenario: create Dienstleistung failed
    Given request login with the email "request@Dienstleistungen.de" and the password "test"
    And the request Link "Neues Gesuch" is clicked
    And the request flavior "Dienstleistung" is selected
    And the request with offername "" and the category "Haustiere" and the endtime "01.01.9999" and the description "little description" is created
    When the create request Button is clicked
    Then the form is still shown and an warning to fill out the requestname is shown
    Then cleanup request Dienstleistungen