Feature: Edit Status
  As a logged in user
  I want to edit a status of an offer or request

  Scenario: Edit status successful
    Given a registerd user named "edit status" with email "edit@status.de" and password "test"
    And login to edit status with the email "edit@status.de" and the password "test"
    And navigated to offers
    And status changed to "verliehen"
    When save status button is clicked
    Then a successful edited status message "Status wurde erfolreich geändert." appears