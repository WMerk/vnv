Feature: Edit Profile
  As a logged in user
  I want to edit my user profile

  Scenario: Edit profile successful
    Given a registerd user named "edit profile" with email "edit@profile.de" and password "test"
    And login to edit profile with the email "edit@profile.de" and the password "test"
    And navigated to profile settings
    And Vorname changed to "vorname"
    When save profile button is clicked
    Then the success message "Das Profil wurde erfolreich aktualisiert." in the field with id "successUpdateUser" is shown
#    And the prename is changed to "vorname"
