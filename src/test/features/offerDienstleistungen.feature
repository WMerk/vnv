Feature: offer Dienstleistung
  As a logged in user
  I want to create an offer for a service

  Scenario:
    Given a registerd user with named "offer Dienstleistungen" with email "offer@Dienstleistungen.de" and password "test"
    And offer login with the email "offer@Dienstleistungen.de" and the password "test"
    And the Link "Neues Angebot" is clicked
    And the flavior "Dienstleistung" is selected
    And the offer with offername "Dienstleistungstest" and the category "Haustiere" and the endtime "01.01.9999" and the description "little description" is created
    When the create offer Button is clicked
    Then the mainpage with the message "Ihr Angebot wurde erfolgreich erstellt." in the element with id "successfulCreateOffer" is shown
    Then cleanup offer Dienstleistungen