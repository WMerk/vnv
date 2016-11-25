Feature: offer Verschenken
  As a logged in user
  I want to create an offer to comp something to someone

  Scenario:
    Given a registerd user named "offer Verschenken" with email "offer@Verschenken.de" and password "test"
    And offer login with the email "offer@Verschenken.de" and the password "test"
    And the Link "Neues Angebot" is clicked
    And the flavior "Verschenken" is selected
    And the offer with offername "Verschenkentest" and the category "Haustiere" and the endtime "01.01.9999" and the description "little description" is created
    When the create offer Button is clicked
    Then the mainpage with the message "Ihr Angebot wurde erfolgreich erstellt." in the element with id "successfulCreateOffer" is shown


  Scenario:
    Given offer login with the email "offer@Verschenken.de" and the password "test"
    And the Link "Neues Angebot" is clicked
    And the flavior "Verschenken" is selected
    And the offer with offername "" and the category "Haustiere" and the endtime "01.01.9999" and the description "little description" is created
    When the create offer Button is clicked
    Then the offer form is still shown and an warning to fill out the offername is shown
    Then cleanup offer Dienstleistungen