$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("changePassword.feature");
formatter.feature({
  "line": 1,
  "name": "Change Password",
  "description": "As a logged in user\r\nI want to change my password",
  "id": "change-password",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Change Password successful",
  "description": "",
  "id": "change-password;change-password-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "a registerd user named \"change password\" with email \"change@password.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "login to change the password with the email \"change@password.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "navigate to password settings",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the actual password \"test\" new password \"test\" and confirm password \"test\" is entered",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the change password button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the message \"Das Passwort wurde erfolreich geändert.\" form element with id \"successChangePassword\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "change password",
      "offset": 24
    },
    {
      "val": "change@password.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 87
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 5703131124,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "change@password.de",
      "offset": 45
    },
    {
      "val": "test",
      "offset": 83
    }
  ],
  "location": "ChangePasswordSteps.loginToChangeThePasswordWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3880709071,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 660961728,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 21
    },
    {
      "val": "test",
      "offset": 41
    },
    {
      "val": "test",
      "offset": 69
    }
  ],
  "location": "ChangePasswordSteps.theActualPasswordNewPasswordAndConfirmPasswordIsEntered(String,String,String)"
});
formatter.result({
  "duration": 250469054,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 67635342,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Das Passwort wurde erfolreich geändert.",
      "offset": 13
    },
    {
      "val": "successChangePassword",
      "offset": 76
    }
  ],
  "location": "ChangePasswordSteps.theMessageFormElementWithIdIsShown(String,String)"
});
formatter.result({
  "duration": 829600061,
  "status": "passed"
});
formatter.after({
  "duration": 799463968,
  "status": "passed"
});
formatter.after({
  "duration": 430712,
  "status": "passed"
});
formatter.after({
  "duration": 239555,
  "status": "passed"
});
formatter.after({
  "duration": 271822,
  "status": "passed"
});
formatter.after({
  "duration": 167201,
  "status": "passed"
});
formatter.after({
  "duration": 250801,
  "status": "passed"
});
formatter.after({
  "duration": 241023,
  "status": "passed"
});
formatter.after({
  "duration": 253244,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Change Password failed",
  "description": "",
  "id": "change-password;change-password-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "login to change the password with the email \"change@password.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "navigate to password settings",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the actual password \"falsePW\" new password \"test\" and confirm password \"test\" is entered",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the change password button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "the message \"Das eingegebene aktuelle Passwort ist nicht korrekt.\" form element with id \"errorChangePassword\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "change@password.de",
      "offset": 45
    },
    {
      "val": "test",
      "offset": 83
    }
  ],
  "location": "ChangePasswordSteps.loginToChangeThePasswordWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3798930172,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 677085775,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "falsePW",
      "offset": 21
    },
    {
      "val": "test",
      "offset": 44
    },
    {
      "val": "test",
      "offset": 72
    }
  ],
  "location": "ChangePasswordSteps.theActualPasswordNewPasswordAndConfirmPasswordIsEntered(String,String,String)"
});
formatter.result({
  "duration": 252069677,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 74148321,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Das eingegebene aktuelle Passwort ist nicht korrekt.",
      "offset": 13
    },
    {
      "val": "errorChangePassword",
      "offset": 89
    }
  ],
  "location": "ChangePasswordSteps.theMessageFormElementWithIdIsShown(String,String)"
});
formatter.result({
  "duration": 430654943,
  "status": "passed"
});
formatter.after({
  "duration": 745405073,
  "status": "passed"
});
formatter.after({
  "duration": 362267,
  "status": "passed"
});
formatter.after({
  "duration": 161822,
  "status": "passed"
});
formatter.after({
  "duration": 186755,
  "status": "passed"
});
formatter.after({
  "duration": 157422,
  "status": "passed"
});
formatter.after({
  "duration": 130534,
  "status": "passed"
});
formatter.after({
  "duration": 175022,
  "status": "passed"
});
formatter.after({
  "duration": 136400,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Cleanup",
  "description": "",
  "id": "change-password;cleanup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "login and delete the registered user with the email \"change@password.de\" and the password \"test\" from database again",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "change@password.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 91
    }
  ],
  "location": "BackgroundSteps.loginAndDeleteTheRegisteredUserWithTheEmailAndThePasswordFromDatabaseAgain(String,String)"
});
formatter.result({
  "duration": 4810247810,
  "status": "passed"
});
formatter.after({
  "duration": 429244,
  "status": "passed"
});
formatter.after({
  "duration": 166712,
  "status": "passed"
});
formatter.after({
  "duration": 136889,
  "status": "passed"
});
formatter.after({
  "duration": 264000,
  "status": "passed"
});
formatter.after({
  "duration": 751421829,
  "status": "passed"
});
formatter.after({
  "duration": 203867,
  "status": "passed"
});
formatter.after({
  "duration": 106578,
  "status": "passed"
});
formatter.after({
  "duration": 121244,
  "status": "passed"
});
formatter.uri("deleteAccount.feature");
formatter.feature({
  "line": 1,
  "name": "Delete Account",
  "description": "As a logged in user\r\nI want to delete my account in vnv",
  "id": "delete-account",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Delete account successful",
  "description": "",
  "id": "delete-account;delete-account-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"delete user\" with email \"deleteuser@mail.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "login with the email \"deleteuser@mail.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the settings are selected",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the delete account settings is selected",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the delete Account button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the confirmation with the password \"test\" is done",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the mainpage with the message \"Schade, dass du uns verlässt! Dein Account wurde gelöscht.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "delete user",
      "offset": 24
    },
    {
      "val": "deleteuser@mail.de",
      "offset": 49
    },
    {
      "val": "test",
      "offset": 83
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4943624539,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "deleteuser@mail.de",
      "offset": 22
    },
    {
      "val": "test",
      "offset": 60
    }
  ],
  "location": "DeleteAccountSteps.loginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3820357196,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 635486214,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 90259656,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 94521790,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 36
    }
  ],
  "location": "DeleteAccountSteps.theConfirmationWithThePasswordIsDone(String)"
});
formatter.result({
  "duration": 245712165,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Schade, dass du uns verlässt! Dein Account wurde gelöscht.",
      "offset": 31
    }
  ],
  "location": "DeleteAccountSteps.theMainpageWithTheMessageIsShown(String)"
});
formatter.result({
  "duration": 444737878,
  "status": "passed"
});
formatter.after({
  "duration": 275733,
  "status": "passed"
});
formatter.after({
  "duration": 203867,
  "status": "passed"
});
formatter.after({
  "duration": 149111,
  "status": "passed"
});
formatter.after({
  "duration": 135422,
  "status": "passed"
});
formatter.after({
  "duration": 166222,
  "status": "passed"
});
formatter.after({
  "duration": 770717298,
  "status": "passed"
});
formatter.after({
  "duration": 277689,
  "status": "passed"
});
formatter.after({
  "duration": 198489,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Delete account failed",
  "description": "",
  "id": "delete-account;delete-account-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "a registerd user named \"delete user\" with email \"deleteuser@mail.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "login with the email \"deleteuser@mail.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the settings are selected",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the delete account settings is selected",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "the delete Account button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the confirmation with the password \"false password\" is done",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "an error message \"Das eingegebene Passwort ist nicht korrekt.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "delete user",
      "offset": 24
    },
    {
      "val": "deleteuser@mail.de",
      "offset": 49
    },
    {
      "val": "test",
      "offset": 83
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4929011649,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "deleteuser@mail.de",
      "offset": 22
    },
    {
      "val": "test",
      "offset": 60
    }
  ],
  "location": "DeleteAccountSteps.loginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3839420933,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 565269538,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 92420056,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 87482278,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false password",
      "offset": 36
    }
  ],
  "location": "DeleteAccountSteps.theConfirmationWithThePasswordIsDone(String)"
});
formatter.result({
  "duration": 257702167,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Das eingegebene Passwort ist nicht korrekt.",
      "offset": 18
    }
  ],
  "location": "DeleteAccountSteps.anErrorMessageIsShown(String)"
});
formatter.result({
  "duration": 502767041,
  "status": "passed"
});
formatter.after({
  "duration": 191155,
  "status": "passed"
});
formatter.after({
  "duration": 109022,
  "status": "passed"
});
formatter.after({
  "duration": 107555,
  "status": "passed"
});
formatter.after({
  "duration": 4838045,
  "status": "passed"
});
formatter.after({
  "duration": 193111,
  "status": "passed"
});
formatter.after({
  "duration": 892507846,
  "status": "passed"
});
formatter.after({
  "duration": 343689,
  "status": "passed"
});
formatter.after({
  "duration": 130044,
  "status": "passed"
});
formatter.uri("editProfile.feature");
formatter.feature({
  "line": 1,
  "name": "Edit Profile",
  "description": "As a logged in user\r\nI want to edit my user profile",
  "id": "edit-profile",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Edit profile successful",
  "description": "",
  "id": "edit-profile;edit-profile-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"edit profile\" with email \"edit@profile.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "login to edit profile with the email \"edit@profile.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "navigated to profile settings",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Vorname changed to \"vorname\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "save profile button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the success message \"Das Profil wurde erfolreich aktualisiert.\" in the field with id \"successUpdateUser\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "edit profile",
      "offset": 24
    },
    {
      "val": "edit@profile.de",
      "offset": 50
    },
    {
      "val": "test",
      "offset": 81
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4915584802,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "edit@profile.de",
      "offset": 38
    },
    {
      "val": "test",
      "offset": 73
    }
  ],
  "location": "EditProfileSteps.loginToEditProfileWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3844446222,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.navigatedToProfileSettings()"
});
formatter.result({
  "duration": 569821584,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vorname",
      "offset": 20
    }
  ],
  "location": "EditProfileSteps.vornameChangedTo(String)"
});
formatter.result({
  "duration": 249087942,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.saveProfileButtonIsClicked()"
});
formatter.result({
  "duration": 67830898,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Das Profil wurde erfolreich aktualisiert.",
      "offset": 21
    },
    {
      "val": "successUpdateUser",
      "offset": 86
    }
  ],
  "location": "EditProfileSteps.theSuccessMessageInTheFieldWithIdIsShown(String,String)"
});
formatter.result({
  "duration": 595272653,
  "status": "passed"
});
formatter.after({
  "duration": 221955,
  "status": "passed"
});
formatter.after({
  "duration": 116845,
  "status": "passed"
});
formatter.after({
  "duration": 87511,
  "status": "passed"
});
formatter.after({
  "duration": 798155701,
  "status": "passed"
});
formatter.after({
  "duration": 125156,
  "status": "passed"
});
formatter.after({
  "duration": 131511,
  "status": "passed"
});
formatter.after({
  "duration": 75289,
  "status": "passed"
});
formatter.after({
  "duration": 82622,
  "status": "passed"
});
formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "As a guest user\r\nI want to login with my mailaddress and password",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Login successful",
  "description": "",
  "id": "login;login-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"login user\" with email \"login@mail.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the email is \"login@mail.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the login button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the main page is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the logged in user is deleted from database again",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "login user",
      "offset": 24
    },
    {
      "val": "login@mail.de",
      "offset": 48
    },
    {
      "val": "test",
      "offset": 77
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4934839693,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "login@mail.de",
      "offset": 14
    },
    {
      "val": "test",
      "offset": 47
    }
  ],
  "location": "LoginSteps.theEmailIsAndThePassword(String,String)"
});
formatter.result({
  "duration": 3736058074,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 69150409,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theMainPageIsShown()"
});
formatter.result({
  "duration": 472262816,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoggedInUserIsDeletedFromDatabaseAgain()"
});
formatter.result({
  "duration": 579400874,
  "status": "passed"
});
formatter.after({
  "duration": 174533,
  "status": "passed"
});
formatter.after({
  "duration": 91422,
  "status": "passed"
});
formatter.after({
  "duration": 756184585,
  "status": "passed"
});
formatter.after({
  "duration": 173067,
  "status": "passed"
});
formatter.after({
  "duration": 91422,
  "status": "passed"
});
formatter.after({
  "duration": 106088,
  "status": "passed"
});
formatter.after({
  "duration": 114400,
  "status": "passed"
});
formatter.after({
  "duration": 104134,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login failed",
  "description": "",
  "id": "login;login-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "the email is \"login@mail.de\" and the password \"falsePassword\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the login button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "an login error with the message \"Falsche E-Mail-Adresse oder Passwort.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "login@mail.de",
      "offset": 14
    },
    {
      "val": "falsePassword",
      "offset": 47
    }
  ],
  "location": "LoginSteps.theEmailIsAndThePassword(String,String)"
});
formatter.result({
  "duration": 3740896119,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 71708764,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Falsche E-Mail-Adresse oder Passwort.",
      "offset": 33
    }
  ],
  "location": "LoginSteps.anLoginErrorWithTheMessageIsShown(String)"
});
formatter.result({
  "duration": 45919872,
  "status": "passed"
});
formatter.after({
  "duration": 197511,
  "status": "passed"
});
formatter.after({
  "duration": 110001,
  "status": "passed"
});
formatter.after({
  "duration": 738384139,
  "status": "passed"
});
formatter.after({
  "duration": 221956,
  "status": "passed"
});
formatter.after({
  "duration": 104622,
  "status": "passed"
});
formatter.after({
  "duration": 82622,
  "status": "passed"
});
formatter.after({
  "duration": 70889,
  "status": "passed"
});
formatter.after({
  "duration": 76267,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Login failed",
  "description": "",
  "id": "login;login-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "the email is \"false@Email\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "the login button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "an login error with the message \"Falsche E-Mail-Adresse oder Passwort.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "false@Email",
      "offset": 14
    },
    {
      "val": "test",
      "offset": 45
    }
  ],
  "location": "LoginSteps.theEmailIsAndThePassword(String,String)"
});
formatter.result({
  "duration": 3723094696,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 73779210,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Falsche E-Mail-Adresse oder Passwort.",
      "offset": 33
    }
  ],
  "location": "LoginSteps.anLoginErrorWithTheMessageIsShown(String)"
});
formatter.result({
  "duration": 46065561,
  "status": "passed"
});
formatter.after({
  "duration": 194089,
  "status": "passed"
});
formatter.after({
  "duration": 88001,
  "status": "passed"
});
formatter.after({
  "duration": 750201073,
  "status": "passed"
});
formatter.after({
  "duration": 175511,
  "status": "passed"
});
formatter.after({
  "duration": 115377,
  "status": "passed"
});
formatter.after({
  "duration": 110489,
  "status": "passed"
});
formatter.after({
  "duration": 92401,
  "status": "passed"
});
formatter.after({
  "duration": 107067,
  "status": "passed"
});
formatter.uri("offerDienstleistungen.feature");
formatter.feature({
  "line": 1,
  "name": "offer Dienstleistung",
  "description": "As a logged in user\r\nI want to create an offer for a service",
  "id": "offer-dienstleistung",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "create Dienstleitung successful",
  "description": "",
  "id": "offer-dienstleistung;create-dienstleitung-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"offer Dienstleistungen\" with email \"offer@Dienstleistungen.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "offer login with the email \"offer@Dienstleistungen.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the flavior \"Dienstleistung\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the offer with offername \"Dienstleistungstest\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the mainpage with the message \"Ihr Angebot wurde erfolgreich erstellt.\" in the element with id \"successfulCreateOffer\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer Dienstleistungen",
      "offset": 24
    },
    {
      "val": "offer@Dienstleistungen.de",
      "offset": 60
    },
    {
      "val": "test",
      "offset": 101
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4921883647,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Dienstleistungen.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 73
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 4032522779,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 788812056,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dienstleistung",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 65637252,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dienstleistungstest",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 65
    },
    {
      "val": "01.01.9999",
      "offset": 93
    },
    {
      "val": "little description",
      "offset": 126
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 525144467,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1074275292,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ihr Angebot wurde erfolgreich erstellt.",
      "offset": 31
    },
    {
      "val": "successfulCreateOffer",
      "offset": 96
    }
  ],
  "location": "OfferDienstleistungenSteps.theMainpageWithTheMessageInTheElementWithIdIsShown(String,String)"
});
formatter.result({
  "duration": 42314317,
  "status": "passed"
});
formatter.after({
  "duration": 183822,
  "status": "passed"
});
formatter.after({
  "duration": 790281167,
  "status": "passed"
});
formatter.after({
  "duration": 164266,
  "status": "passed"
});
formatter.after({
  "duration": 96311,
  "status": "passed"
});
formatter.after({
  "duration": 102178,
  "status": "passed"
});
formatter.after({
  "duration": 138355,
  "status": "passed"
});
formatter.after({
  "duration": 81155,
  "status": "passed"
});
formatter.after({
  "duration": 95333,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "create Dienstleistung failed",
  "description": "",
  "id": "offer-dienstleistung;create-dienstleistung-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "offer login with the email \"offer@Dienstleistungen.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the flavior \"Dienstleistung\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "the offer with offername \"\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the offer form is still shown and an warning to fill out the offername is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "cleanup offer Dienstleistungen",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Dienstleistungen.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 73
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3822888175,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 786319211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dienstleistung",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 64609119,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 46
    },
    {
      "val": "01.01.9999",
      "offset": 74
    },
    {
      "val": "little description",
      "offset": 107
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 471948460,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1070768980,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 22196535,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 554850826,
  "status": "passed"
});
formatter.after({
  "duration": 140800,
  "status": "passed"
});
formatter.after({
  "duration": 803701657,
  "status": "passed"
});
formatter.after({
  "duration": 165245,
  "status": "passed"
});
formatter.after({
  "duration": 117334,
  "status": "passed"
});
formatter.after({
  "duration": 81156,
  "status": "passed"
});
formatter.after({
  "duration": 84577,
  "status": "passed"
});
formatter.after({
  "duration": 71866,
  "status": "passed"
});
formatter.after({
  "duration": 67467,
  "status": "passed"
});
formatter.uri("offerVerleihen.feature");
formatter.feature({
  "line": 1,
  "name": "offer Verleihen",
  "description": "As a logged in user\r\nI want to create an offer to lend something",
  "id": "offer-verleihen",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "create Verleihen successful",
  "description": "",
  "id": "offer-verleihen;create-verleihen-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"offer Verleihen\" with email \"offer@Verleihen.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "offer login with the email \"offer@Verleihen.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the flavior \"Verleihen\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the offer with offername \"Verleihentest\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the mainpage with the message \"Ihr Angebot wurde erfolgreich erstellt.\" in the element with id \"successfulCreateOffer\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer Verleihen",
      "offset": 24
    },
    {
      "val": "offer@Verleihen.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 87
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4995905346,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Verleihen.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 66
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3824507863,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 791005212,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verleihen",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 67100986,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verleihentest",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 59
    },
    {
      "val": "01.01.9999",
      "offset": 87
    },
    {
      "val": "little description",
      "offset": 120
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 494770285,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1075554226,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ihr Angebot wurde erfolgreich erstellt.",
      "offset": 31
    },
    {
      "val": "successfulCreateOffer",
      "offset": 96
    }
  ],
  "location": "OfferDienstleistungenSteps.theMainpageWithTheMessageInTheElementWithIdIsShown(String,String)"
});
formatter.result({
  "duration": 45522895,
  "status": "passed"
});
formatter.after({
  "duration": 222445,
  "status": "passed"
});
formatter.after({
  "duration": 748384361,
  "status": "passed"
});
formatter.after({
  "duration": 169155,
  "status": "passed"
});
formatter.after({
  "duration": 96800,
  "status": "passed"
});
formatter.after({
  "duration": 88977,
  "status": "passed"
});
formatter.after({
  "duration": 74312,
  "status": "passed"
});
formatter.after({
  "duration": 78222,
  "status": "passed"
});
formatter.after({
  "duration": 122711,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "create Verleihen failed",
  "description": "",
  "id": "offer-verleihen;create-verleihen-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "offer login with the email \"offer@Verleihen.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the flavior \"Verleihen\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "the offer with offername \"\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the offer form is still shown and an warning to fill out the offername is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "cleanup offer Dienstleistungen",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Verleihen.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 66
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3932049255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 812489926,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verleihen",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 77170632,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 46
    },
    {
      "val": "01.01.9999",
      "offset": 74
    },
    {
      "val": "little description",
      "offset": 107
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 486726595,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1081886804,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 19816625,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 548259626,
  "status": "passed"
});
formatter.after({
  "duration": 170133,
  "status": "passed"
});
formatter.after({
  "duration": 748810183,
  "status": "passed"
});
formatter.after({
  "duration": 168178,
  "status": "passed"
});
formatter.after({
  "duration": 73822,
  "status": "passed"
});
formatter.after({
  "duration": 67956,
  "status": "passed"
});
formatter.after({
  "duration": 112445,
  "status": "passed"
});
formatter.after({
  "duration": 86534,
  "status": "passed"
});
formatter.after({
  "duration": 88978,
  "status": "passed"
});
formatter.uri("offerVerschenken.feature");
formatter.feature({
  "line": 1,
  "name": "offer Verschenken",
  "description": "As a logged in user\r\nI want to create an offer to comp something to someone",
  "id": "offer-verschenken",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "create Verschenken successful",
  "description": "",
  "id": "offer-verschenken;create-verschenken-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"offer Verschenken\" with email \"offer@Verschenken.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "offer login with the email \"offer@Verschenken.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the flavior \"Verschenken\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the offer with offername \"Verschenkentest\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the mainpage with the message \"Ihr Angebot wurde erfolgreich erstellt.\" in the element with id \"successfulCreateOffer\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer Verschenken",
      "offset": 24
    },
    {
      "val": "offer@Verschenken.de",
      "offset": 55
    },
    {
      "val": "test",
      "offset": 91
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4915970536,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Verschenken.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 68
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3839974354,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 795476101,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verschenken",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 72849343,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verschenkentest",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 61
    },
    {
      "val": "01.01.9999",
      "offset": 89
    },
    {
      "val": "little description",
      "offset": 122
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 74075965,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d54.0.2840.99)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 23 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027MerkWaldemar-PC\u0027, ip: \u0027192.168.178.48\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\MERKWA~1\\AppData\\Local\\Temp\\scoped_dir12672_29008}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d54.0.2840.99, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 592c6d9d42437528df6a134ec016b743\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.sendKeys(RemoteWebElement.java:122)\r\n\tat com.vnv.ZCucumber.OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(OfferDienstleistungenSteps.java:45)\r\n\tat ✽.And the offer with offername \"Verschenkentest\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created(offerVerschenken.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Ihr Angebot wurde erfolgreich erstellt.",
      "offset": 31
    },
    {
      "val": "successfulCreateOffer",
      "offset": 96
    }
  ],
  "location": "OfferDienstleistungenSteps.theMainpageWithTheMessageInTheElementWithIdIsShown(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3067778,
  "status": "passed"
});
formatter.after({
  "duration": 779492366,
  "status": "passed"
});
formatter.after({
  "duration": 220001,
  "status": "passed"
});
formatter.after({
  "duration": 131511,
  "status": "passed"
});
formatter.after({
  "duration": 98756,
  "status": "passed"
});
formatter.after({
  "duration": 96311,
  "status": "passed"
});
formatter.after({
  "duration": 82622,
  "status": "passed"
});
formatter.after({
  "duration": 228800,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "create Verschenken failed",
  "description": "",
  "id": "offer-verschenken;create-verschenken-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "offer login with the email \"offer@Verschenken.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the Link \"Neues Angebot\" is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the flavior \"Verschenken\" is selected",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "the offer with offername \"\" and the category \"Haustiere\" and the endtime \"01.01.9999\" and the description \"little description\" is created",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "the create offer Button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the offer form is still shown and an warning to fill out the offername is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "cleanup offer Dienstleistungen",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "offer@Verschenken.de",
      "offset": 28
    },
    {
      "val": "test",
      "offset": 68
    }
  ],
  "location": "OfferDienstleistungenSteps.offerLoginWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3823652796,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Neues Angebot",
      "offset": 10
    }
  ],
  "location": "OfferDienstleistungenSteps.theLinkIsClicked(String)"
});
formatter.result({
  "duration": 793232101,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Verschenken",
      "offset": 13
    }
  ],
  "location": "OfferDienstleistungenSteps.theFlaviorIsSelected(String)"
});
formatter.result({
  "duration": 68826764,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 26
    },
    {
      "val": "Haustiere",
      "offset": 46
    },
    {
      "val": "01.01.9999",
      "offset": 74
    },
    {
      "val": "little description",
      "offset": 107
    }
  ],
  "location": "OfferDienstleistungenSteps.theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String,String,String,String)"
});
formatter.result({
  "duration": 490402063,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1080752093,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 20827647,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 575260962,
  "status": "passed"
});
formatter.after({
  "duration": 143244,
  "status": "passed"
});
formatter.after({
  "duration": 736786449,
  "status": "passed"
});
formatter.after({
  "duration": 160355,
  "status": "passed"
});
formatter.after({
  "duration": 106577,
  "status": "passed"
});
formatter.after({
  "duration": 75778,
  "status": "passed"
});
formatter.after({
  "duration": 87022,
  "status": "passed"
});
formatter.after({
  "duration": 95822,
  "status": "passed"
});
formatter.after({
  "duration": 73823,
  "status": "passed"
});
formatter.uri("register.feature");
formatter.feature({
  "line": 1,
  "name": "Register",
  "description": "as a guest user\r\nI want to register an user account",
  "id": "register",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Successfully registered",
  "description": "",
  "id": "register;successfully-registered",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "the username is \"vorname nachname\" and the email is \"registeruser@mail.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the register button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the register page is shown and the cssSelector is \"alert-success\" and the message is \"Willkommen! Die Registrierung war erfolgreich.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "vorname nachname",
      "offset": 17
    },
    {
      "val": "registeruser@mail.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 93
    }
  ],
  "location": "RegisterSteps.the_username_is_something_and_the_email_is_something_and_the_password_something(String,String,String)"
});
formatter.result({
  "duration": 4125355457,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 69376275,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alert-success",
      "offset": 51
    },
    {
      "val": "Willkommen! Die Registrierung war erfolgreich.",
      "offset": 86
    }
  ],
  "location": "RegisterSteps.theRegisterPageIsShownAndTheCssSelectorIsAndTheMessageIs(String,String)"
});
formatter.result({
  "duration": 884384957,
  "status": "passed"
});
formatter.after({
  "duration": 1005645,
  "status": "passed"
});
formatter.after({
  "duration": 738711,
  "status": "passed"
});
formatter.after({
  "duration": 659510,
  "status": "passed"
});
formatter.after({
  "duration": 579334,
  "status": "passed"
});
formatter.after({
  "duration": 554889,
  "status": "passed"
});
formatter.after({
  "duration": 563689,
  "status": "passed"
});
formatter.after({
  "duration": 738147028,
  "status": "passed"
});
formatter.after({
  "duration": 846756,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Register failed",
  "description": "",
  "id": "register;register-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "the username is \"\" and the email is \"email@email.de\" and the password \"1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "the register button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the register page is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 17
    },
    {
      "val": "email@email.de",
      "offset": 37
    },
    {
      "val": "1",
      "offset": 71
    }
  ],
  "location": "RegisterSteps.the_username_is_something_and_the_email_is_something_and_the_password_something(String,String,String)"
});
formatter.result({
  "duration": 3880519870,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 76299920,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.theRegisterPageIsShown()"
});
formatter.result({
  "duration": 60442808,
  "status": "passed"
});
formatter.after({
  "duration": 174044,
  "status": "passed"
});
formatter.after({
  "duration": 86533,
  "status": "passed"
});
formatter.after({
  "duration": 132978,
  "status": "passed"
});
formatter.after({
  "duration": 94844,
  "status": "passed"
});
formatter.after({
  "duration": 92401,
  "status": "passed"
});
formatter.after({
  "duration": 81155,
  "status": "passed"
});
formatter.after({
  "duration": 738553294,
  "status": "passed"
});
formatter.after({
  "duration": 188223,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Email is already stored in Database",
  "description": "",
  "id": "register;email-is-already-stored-in-database",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the username is \"vorname nachname\" and the email is \"registeruser@mail.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the register button is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "an Registrationerror with the message \"Es existiert bereits ein Account mit dieser Mailadresse.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "vorname nachname",
      "offset": 17
    },
    {
      "val": "registeruser@mail.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 93
    }
  ],
  "location": "RegisterSteps.the_username_is_something_and_the_email_is_something_and_the_password_something(String,String,String)"
});
formatter.result({
  "duration": 4082171896,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 89412900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Es existiert bereits ein Account mit dieser Mailadresse.",
      "offset": 39
    }
  ],
  "location": "RegisterSteps.anRegistrationerrorWithTheMessageIsShown(String)"
});
formatter.result({
  "duration": 47558629,
  "error_message": "java.lang.AssertionError: \nExpected: is \"\"\n     but: was \"Es existiert bereits ein Account mit dieser Mailadresse.\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.junit.Assert.assertThat(Assert.java:956)\r\n\tat org.junit.Assert.assertThat(Assert.java:923)\r\n\tat com.vnv.ZCucumber.RegisterSteps.anRegistrationerrorWithTheMessageIsShown(RegisterSteps.java:73)\r\n\tat ✽.Then an Registrationerror with the message \"Es existiert bereits ein Account mit dieser Mailadresse.\" is shown(register.feature:18)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 156444,
  "status": "passed"
});
formatter.after({
  "duration": 78222,
  "status": "passed"
});
formatter.after({
  "duration": 74800,
  "status": "passed"
});
formatter.after({
  "duration": 80667,
  "status": "passed"
});
formatter.after({
  "duration": 70400,
  "status": "passed"
});
formatter.after({
  "duration": 68934,
  "status": "passed"
});
formatter.after({
  "duration": 759334008,
  "status": "passed"
});
formatter.after({
  "duration": 151067,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Cleanup",
  "description": "",
  "id": "register;cleanup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "login and delete the registered user with the email \"registeruser@mail.de\" and the password \"test\" from database again",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "registeruser@mail.de",
      "offset": 53
    },
    {
      "val": "test",
      "offset": 93
    }
  ],
  "location": "BackgroundSteps.loginAndDeleteTheRegisteredUserWithTheEmailAndThePasswordFromDatabaseAgain(String,String)"
});
formatter.result({
  "duration": 4859320040,
  "status": "passed"
});
formatter.after({
  "duration": 203867,
  "status": "passed"
});
formatter.after({
  "duration": 78711,
  "status": "passed"
});
formatter.after({
  "duration": 70889,
  "status": "passed"
});
formatter.after({
  "duration": 727956,
  "status": "passed"
});
formatter.after({
  "duration": 757112985,
  "status": "passed"
});
formatter.after({
  "duration": 154489,
  "status": "passed"
});
formatter.after({
  "duration": 80666,
  "status": "passed"
});
formatter.after({
  "duration": 61600,
  "status": "passed"
});
formatter.uri("searchFriend.feature");
formatter.feature({
  "line": 1,
  "name": "Search friend",
  "description": "As a logged in user\r\nI want to search for a friend",
  "id": "search-friend",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "search friend successful",
  "description": "",
  "id": "search-friend;search-friend-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"search friend\" with email \"search@friend.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "login to search a friend with the email \"search@friend.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I am on the add friends page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I type \"test\" in the searchfield",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I find my friend \"test user\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "search friend",
      "offset": 24
    },
    {
      "val": "search@friend.de",
      "offset": 51
    },
    {
      "val": "test",
      "offset": 83
    }
  ],
  "location": "BackgroundSteps.aRegisterdUserWithNamedWithEmailAndPassword(String,String,String)"
});
formatter.result({
  "duration": 4883019420,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "search@friend.de",
      "offset": 41
    },
    {
      "val": "test",
      "offset": 77
    }
  ],
  "location": "SearchFriendSteps.loginToSearchAFriendWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3757667455,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iAmOnTheAddFriendsPage()"
});
formatter.result({
  "duration": 490628907,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 8
    }
  ],
  "location": "SearchFriendSteps.iTypeInTheSearchfield(String)"
});
formatter.result({
  "duration": 131113172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test user",
      "offset": 18
    }
  ],
  "location": "SearchFriendSteps.iFindMyFriend(String)"
});
formatter.result({
  "duration": 189623402,
  "status": "passed"
});
formatter.after({
  "duration": 149600,
  "status": "passed"
});
formatter.after({
  "duration": 85067,
  "status": "passed"
});
formatter.after({
  "duration": 89955,
  "status": "passed"
});
formatter.after({
  "duration": 77245,
  "status": "passed"
});
formatter.after({
  "duration": 100221,
  "status": "passed"
});
formatter.after({
  "duration": 99244,
  "status": "passed"
});
formatter.after({
  "duration": 73822,
  "status": "passed"
});
formatter.after({
  "duration": 747834851,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "search friend failed",
  "description": "",
  "id": "search-friend;search-friend-failed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "login to search a friend with the email \"search@friend.de\" and the password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I am on the add friends page",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I type \"not_a_Friend\" in the searchfield",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I find no entry in list",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "search@friend.de",
      "offset": 41
    },
    {
      "val": "test",
      "offset": 77
    }
  ],
  "location": "SearchFriendSteps.loginToSearchAFriendWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 3852175555,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iAmOnTheAddFriendsPage()"
});
formatter.result({
  "duration": 503953086,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "not_a_Friend",
      "offset": 8
    }
  ],
  "location": "SearchFriendSteps.iTypeInTheSearchfield(String)"
});
formatter.result({
  "duration": 147436197,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iFindNoEntryInList()"
});
formatter.result({
  "duration": 10653152775,
  "status": "passed"
});
formatter.after({
  "duration": 193600,
  "status": "passed"
});
formatter.after({
  "duration": 79689,
  "status": "passed"
});
formatter.after({
  "duration": 71867,
  "status": "passed"
});
formatter.after({
  "duration": 85556,
  "status": "passed"
});
formatter.after({
  "duration": 597422,
  "status": "passed"
});
formatter.after({
  "duration": 101200,
  "status": "passed"
});
formatter.after({
  "duration": 69911,
  "status": "passed"
});
formatter.after({
  "duration": 726648359,
  "status": "passed"
});
});