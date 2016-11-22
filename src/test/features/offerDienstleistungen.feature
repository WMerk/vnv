Feature: offer Dienstleistung
  As a logged in user
  I want to create an offer for a service

  Scenario:
    Given a registerd user with named "offer Dienstleistungen" with email "offer@Dienstleistungen.de" and password "test"
    And offer login with the email "offer@Dienstleistungen.de" and the password "test"
    And the Button to create an offer is clicked
    And the flavior "Dienstleistungen" is selected
    And the offer with offername "Dienstleistungstest" and the category "Sonstige" and the starttime "" and the endtime "" and the description "little description" is created
    When the create offer Button is clicked
    Then the mainpage with the message "<string>" in the element with id "" is shown
    