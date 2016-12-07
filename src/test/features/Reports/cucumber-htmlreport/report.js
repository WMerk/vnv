$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addFriend.feature");
formatter.feature({
  "line": 1,
  "name": "Add friend",
  "description": "As a logged in user\r\nI want to add a friend",
  "id": "add-friend",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Add friend successful",
  "description": "",
  "id": "add-friend;add-friend-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a registerd user named \"add friend\" with email \"add@friend.de\" and password \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "logged in to add a friend with the email \"add@friend.de\" and the password \"test\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I want to add \"test\" and click on the button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the buttontext changes to \"Anfrage versendet\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "add friend",
      "offset": 24
    },
    {
      "val": "add@friend.de",
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
  "duration": 15631870000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "add@friend.de",
      "offset": 42
    },
    {
      "val": "test",
      "offset": 75
    }
  ],
  "location": "AddFriendSteps.loggedInToAddAFriendWithTheEmailAndThePassword(String,String)"
});
formatter.result({
  "duration": 7797443653,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 15
    }
  ],
  "location": "AddFriendSteps.iWantToAddAndClickOnTheButton(String)"
});
formatter.result({
  "duration": 292610517,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Anfrage versendet",
      "offset": 27
    }
  ],
  "location": "AddFriendSteps.theButtontextChangesTo(String)"
});
formatter.result({
  "duration": 1004332139,
  "status": "passed"
});
formatter.after({
  "duration": 1137560,
  "status": "passed"
});
formatter.after({
  "duration": 994297,
  "status": "passed"
});
formatter.after({
  "duration": 1004988,
  "status": "passed"
});
formatter.after({
  "duration": 933142,
  "status": "passed"
});
formatter.after({
  "duration": 36516977,
  "status": "passed"
});
formatter.after({
  "duration": 1668800519,
  "status": "passed"
});
formatter.after({
  "duration": 1172201,
  "status": "passed"
});
formatter.after({
  "duration": 775765,
  "status": "passed"
});
formatter.after({
  "duration": 1256448,
  "status": "passed"
});
formatter.uri("changePassword.feature");
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
  "duration": 10438651914,
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
  "duration": 6810845058,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 2445493527,
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
  "duration": 869157867,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 229365143,
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
  "duration": 3038372570,
  "status": "passed"
});
formatter.after({
  "duration": 641481,
  "status": "passed"
});
formatter.after({
  "duration": 587170,
  "status": "passed"
});
formatter.after({
  "duration": 628652,
  "status": "passed"
});
formatter.after({
  "duration": 673983,
  "status": "passed"
});
formatter.after({
  "duration": 510192,
  "status": "passed"
});
formatter.after({
  "duration": 583748,
  "status": "passed"
});
formatter.after({
  "duration": 1335722781,
  "status": "passed"
});
formatter.after({
  "duration": 670990,
  "status": "passed"
});
formatter.after({
  "duration": 726585,
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
  "duration": 6443826959,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 2538514765,
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
  "duration": 825404978,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 256690118,
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
  "duration": 1654240171,
  "status": "passed"
});
formatter.after({
  "duration": 913469,
  "status": "passed"
});
formatter.after({
  "duration": 655167,
  "status": "passed"
});
formatter.after({
  "duration": 603847,
  "status": "passed"
});
formatter.after({
  "duration": 6305336,
  "status": "passed"
});
formatter.after({
  "duration": 601282,
  "status": "passed"
});
formatter.after({
  "duration": 1094795,
  "status": "passed"
});
formatter.after({
  "duration": 1377570042,
  "status": "passed"
});
formatter.after({
  "duration": 657733,
  "status": "passed"
});
formatter.after({
  "duration": 349822,
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
  "duration": 9066213296,
  "status": "passed"
});
formatter.after({
  "duration": 487098,
  "status": "passed"
});
formatter.after({
  "duration": 263008,
  "status": "passed"
});
formatter.after({
  "duration": 220670,
  "status": "passed"
});
formatter.after({
  "duration": 85252040,
  "status": "passed"
});
formatter.after({
  "duration": 142837,
  "status": "passed"
});
formatter.after({
  "duration": 141981,
  "status": "passed"
});
formatter.after({
  "duration": 112901,
  "status": "passed"
});
formatter.after({
  "duration": 1251775941,
  "status": "passed"
});
formatter.after({
  "duration": 501210,
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
  "duration": 9606572534,
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
  "duration": 6907834927,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 1069753419,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 114970597,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 106752363,
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
  "duration": 316381258,
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
  "duration": 562119575,
  "status": "passed"
});
formatter.after({
  "duration": 173628,
  "status": "passed"
});
formatter.after({
  "duration": 98360,
  "status": "passed"
});
formatter.after({
  "duration": 115895,
  "status": "passed"
});
formatter.after({
  "duration": 2295221,
  "status": "passed"
});
formatter.after({
  "duration": 1182304347,
  "status": "passed"
});
formatter.after({
  "duration": 446899,
  "status": "passed"
});
formatter.after({
  "duration": 355381,
  "status": "passed"
});
formatter.after({
  "duration": 724019,
  "status": "passed"
});
formatter.after({
  "duration": 398146,
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
  "duration": 9786045809,
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
  "duration": 6584409347,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 1922154933,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 300652130,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 318599073,
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
  "duration": 681965431,
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
  "duration": 2089290808,
  "status": "passed"
});
formatter.after({
  "duration": 570491,
  "status": "passed"
});
formatter.after({
  "duration": 363506,
  "status": "passed"
});
formatter.after({
  "duration": 294226,
  "status": "passed"
});
formatter.after({
  "duration": 28269235,
  "status": "passed"
});
formatter.after({
  "duration": 1491177705,
  "status": "passed"
});
formatter.after({
  "duration": 567069,
  "status": "passed"
});
formatter.after({
  "duration": 874552,
  "status": "passed"
});
formatter.after({
  "duration": 357092,
  "status": "passed"
});
formatter.after({
  "duration": 373343,
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
  "duration": 9138463788,
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
  "duration": 6394960179,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.navigatedToProfileSettings()"
});
formatter.result({
  "duration": 2164894110,
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
  "duration": 839849432,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.saveProfileButtonIsClicked()"
});
formatter.result({
  "duration": 205838594,
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
  "duration": 1867624727,
  "status": "passed"
});
formatter.after({
  "duration": 435780,
  "status": "passed"
});
formatter.after({
  "duration": 441766,
  "status": "passed"
});
formatter.after({
  "duration": 384461,
  "status": "passed"
});
formatter.after({
  "duration": 1694133481,
  "status": "passed"
});
formatter.after({
  "duration": 362223,
  "status": "passed"
});
formatter.after({
  "duration": 311332,
  "status": "passed"
});
formatter.after({
  "duration": 293371,
  "status": "passed"
});
formatter.after({
  "duration": 204418,
  "status": "passed"
});
formatter.after({
  "duration": 212544,
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
  "duration": 8945116979,
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
  "duration": 6017567613,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 255239086,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theMainPageIsShown()"
});
formatter.result({
  "duration": 1758058398,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoggedInUserIsDeletedFromDatabaseAgain()"
});
formatter.result({
  "duration": 1706239948,
  "status": "passed"
});
formatter.after({
  "duration": 518317,
  "status": "passed"
});
formatter.after({
  "duration": 1438063033,
  "status": "passed"
});
formatter.after({
  "duration": 345117,
  "status": "passed"
});
formatter.after({
  "duration": 512330,
  "status": "passed"
});
formatter.after({
  "duration": 474269,
  "status": "passed"
});
formatter.after({
  "duration": 490519,
  "status": "passed"
});
formatter.after({
  "duration": 1740554,
  "status": "passed"
});
formatter.after({
  "duration": 337419,
  "status": "passed"
});
formatter.after({
  "duration": 475124,
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
  "duration": 6111039598,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 284001408,
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
  "duration": 265300939,
  "status": "passed"
});
formatter.after({
  "duration": 505060,
  "status": "passed"
});
formatter.after({
  "duration": 1454160798,
  "status": "passed"
});
formatter.after({
  "duration": 393014,
  "status": "passed"
});
formatter.after({
  "duration": 287383,
  "status": "passed"
});
formatter.after({
  "duration": 308339,
  "status": "passed"
});
formatter.after({
  "duration": 396436,
  "status": "passed"
});
formatter.after({
  "duration": 291660,
  "status": "passed"
});
formatter.after({
  "duration": 220670,
  "status": "passed"
});
formatter.after({
  "duration": 325873,
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
  "duration": 6024043582,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 332132622,
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
  "duration": 440560963,
  "status": "passed"
});
formatter.after({
  "duration": 470848,
  "status": "passed"
});
formatter.after({
  "duration": 1277631496,
  "status": "passed"
});
formatter.after({
  "duration": 442195,
  "status": "passed"
});
formatter.after({
  "duration": 322879,
  "status": "passed"
});
formatter.after({
  "duration": 403705,
  "status": "passed"
});
formatter.after({
  "duration": 392159,
  "status": "passed"
});
formatter.after({
  "duration": 394724,
  "status": "passed"
});
formatter.after({
  "duration": 406700,
  "status": "passed"
});
formatter.after({
  "duration": 388738,
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
  "duration": 8884965255,
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
  "duration": 6645525431,
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
  "duration": 10140099138,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"link text\",\"selector\":\"Neues Angebot\"}\n  (Session info: chrome\u003d54.0.2840.99)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 10.13 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027WaldemarLaptop\u0027, ip: \u0027169.254.178.50\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\Waldemar\\AppData\\Local\\Temp\\scoped_dir14264_10609}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d54.0.2840.99, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: e390179cf14dda148929b954ba289aa3\n*** Element info: {Using\u003dlink text, value\u003dNeues Angebot}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:246)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat com.vnv.ZCucumber.OfferDienstleistungenSteps.theLinkIsClicked(OfferDienstleistungenSteps.java:34)\r\n\tat ✽.And the Link \"Neues Angebot\" is clicked(offerDienstleistungen.feature:8)\r\n",
  "status": "failed"
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
  "status": "skipped"
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
  "status": "skipped"
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
  "duration": 414825,
  "status": "passed"
});
formatter.after({
  "duration": 339130,
  "status": "passed"
});
formatter.after({
  "duration": 1293134822,
  "status": "passed"
});
formatter.after({
  "duration": 473841,
  "status": "passed"
});
formatter.after({
  "duration": 399002,
  "status": "passed"
});
formatter.after({
  "duration": 643620,
  "status": "passed"
});
formatter.after({
  "duration": 450747,
  "status": "passed"
});
formatter.after({
  "duration": 387455,
  "status": "passed"
});
formatter.after({
  "duration": 388738,
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
  "duration": 6577322687,
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
  "duration": 10105667404,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"link text\",\"selector\":\"Neues Angebot\"}\n  (Session info: chrome\u003d54.0.2840.99)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 10.11 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027WaldemarLaptop\u0027, ip: \u0027169.254.178.50\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\Waldemar\\AppData\\Local\\Temp\\scoped_dir12000_1164}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d54.0.2840.99, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 443cfda862122b705c03eeadb679aa74\n*** Element info: {Using\u003dlink text, value\u003dNeues Angebot}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:246)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat com.vnv.ZCucumber.OfferDienstleistungenSteps.theLinkIsClicked(OfferDienstleistungenSteps.java:34)\r\n\tat ✽.And the Link \"Neues Angebot\" is clicked(offerDienstleistungen.feature:17)\r\n",
  "status": "failed"
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
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 446471,
  "status": "passed"
});
formatter.after({
  "duration": 373770,
  "status": "passed"
});
formatter.after({
  "duration": 1338119355,
  "status": "passed"
});
formatter.after({
  "duration": 410548,
  "status": "passed"
});
formatter.after({
  "duration": 411403,
  "status": "passed"
});
formatter.after({
  "duration": 372487,
  "status": "passed"
});
formatter.after({
  "duration": 282252,
  "status": "passed"
});
formatter.after({
  "duration": 333570,
  "status": "passed"
});
formatter.after({
  "duration": 382323,
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
  "duration": 9072906942,
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
  "duration": 6397312278,
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
  "duration": 2436393044,
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
  "duration": 181858731,
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
  "duration": 1389732105,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1261692819,
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
  "duration": 112290059,
  "status": "passed"
});
formatter.after({
  "duration": 507625,
  "status": "passed"
});
formatter.after({
  "duration": 336564,
  "status": "passed"
});
formatter.after({
  "duration": 1325733631,
  "status": "passed"
});
formatter.after({
  "duration": 318603,
  "status": "passed"
});
formatter.after({
  "duration": 221097,
  "status": "passed"
});
formatter.after({
  "duration": 232216,
  "status": "passed"
});
formatter.after({
  "duration": 201426,
  "status": "passed"
});
formatter.after({
  "duration": 185602,
  "status": "passed"
});
formatter.after({
  "duration": 212116,
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
  "duration": 7149904398,
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
  "duration": 1920224928,
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
  "duration": 278324724,
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
  "duration": 2079444494,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1308685190,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 53656937,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 1613932037,
  "status": "passed"
});
formatter.after({
  "duration": 401995,
  "status": "passed"
});
formatter.after({
  "duration": 262579,
  "status": "passed"
});
formatter.after({
  "duration": 1269651466,
  "status": "passed"
});
formatter.after({
  "duration": 670134,
  "status": "passed"
});
formatter.after({
  "duration": 391731,
  "status": "passed"
});
formatter.after({
  "duration": 421667,
  "status": "passed"
});
formatter.after({
  "duration": 585459,
  "status": "passed"
});
formatter.after({
  "duration": 564076,
  "status": "passed"
});
formatter.after({
  "duration": 387454,
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
  "duration": 8966630987,
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
  "duration": 6378632336,
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
  "duration": 2350733020,
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
  "duration": 188224794,
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
  "duration": 1486750199,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1306912135,
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
  "duration": 109361055,
  "status": "passed"
});
formatter.after({
  "duration": 522593,
  "status": "passed"
});
formatter.after({
  "duration": 395580,
  "status": "passed"
});
formatter.after({
  "duration": 1313485609,
  "status": "passed"
});
formatter.after({
  "duration": 431931,
  "status": "passed"
});
formatter.after({
  "duration": 398574,
  "status": "passed"
});
formatter.after({
  "duration": 236920,
  "status": "passed"
});
formatter.after({
  "duration": 255309,
  "status": "passed"
});
formatter.after({
  "duration": 243335,
  "status": "passed"
});
formatter.after({
  "duration": 256165,
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
  "duration": 6278733561,
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
  "duration": 2546717603,
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
  "duration": 184102206,
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
  "duration": 1535445490,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1260611708,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 60027276,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 1546038915,
  "status": "passed"
});
formatter.after({
  "duration": 2329433,
  "status": "passed"
});
formatter.after({
  "duration": 2010831,
  "status": "passed"
});
formatter.after({
  "duration": 1618658046,
  "status": "passed"
});
formatter.after({
  "duration": 2367922,
  "status": "passed"
});
formatter.after({
  "duration": 3304486,
  "status": "passed"
});
formatter.after({
  "duration": 2182321,
  "status": "passed"
});
formatter.after({
  "duration": 1991587,
  "status": "passed"
});
formatter.after({
  "duration": 1722164,
  "status": "passed"
});
formatter.after({
  "duration": 1569919,
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
  "duration": 7207922126,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 1417615169,
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
  "duration": 2167394178,
  "status": "passed"
});
formatter.after({
  "duration": 508909,
  "status": "passed"
});
formatter.after({
  "duration": 442622,
  "status": "passed"
});
formatter.after({
  "duration": 406699,
  "status": "passed"
});
formatter.after({
  "duration": 2324729,
  "status": "passed"
});
formatter.after({
  "duration": 366072,
  "status": "passed"
});
formatter.after({
  "duration": 315181,
  "status": "passed"
});
formatter.after({
  "duration": 328439,
  "status": "passed"
});
formatter.after({
  "duration": 338702,
  "status": "passed"
});
formatter.after({
  "duration": 1381764904,
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
  "duration": 6825898491,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 1364430790,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.theRegisterPageIsShown()"
});
formatter.result({
  "duration": 134335213,
  "status": "passed"
});
formatter.after({
  "duration": 402423,
  "status": "passed"
});
formatter.after({
  "duration": 255737,
  "status": "passed"
});
formatter.after({
  "duration": 326728,
  "status": "passed"
});
formatter.after({
  "duration": 395580,
  "status": "passed"
});
formatter.after({
  "duration": 227513,
  "status": "passed"
});
formatter.after({
  "duration": 331432,
  "status": "passed"
});
formatter.after({
  "duration": 275409,
  "status": "passed"
});
formatter.after({
  "duration": 255738,
  "status": "passed"
});
formatter.after({
  "duration": 1206526262,
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
  "duration": 6973953711,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 1620559397,
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
  "duration": 138626725,
  "error_message": "java.lang.AssertionError: \nExpected: is \"Es existiert bereits ein Account mit dieser Mailadresse.\"\n     but: was \"\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.junit.Assert.assertThat(Assert.java:956)\r\n\tat org.junit.Assert.assertThat(Assert.java:923)\r\n\tat com.vnv.ZCucumber.RegisterSteps.anRegistrationerrorWithTheMessageIsShown(RegisterSteps.java:74)\r\n\tat ✽.Then an Registrationerror with the message \"Es existiert bereits ein Account mit dieser Mailadresse.\" is shown(register.feature:18)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 350677,
  "status": "passed"
});
formatter.after({
  "duration": 283963,
  "status": "passed"
});
formatter.after({
  "duration": 257448,
  "status": "passed"
});
formatter.after({
  "duration": 260869,
  "status": "passed"
});
formatter.after({
  "duration": 458018,
  "status": "passed"
});
formatter.after({
  "duration": 314754,
  "status": "passed"
});
formatter.after({
  "duration": 385744,
  "status": "passed"
});
formatter.after({
  "duration": 322452,
  "status": "passed"
});
formatter.after({
  "duration": 1505065352,
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
  "duration": 9657481364,
  "status": "passed"
});
formatter.after({
  "duration": 401140,
  "status": "passed"
});
formatter.after({
  "duration": 236920,
  "status": "passed"
});
formatter.after({
  "duration": 256592,
  "status": "passed"
});
formatter.after({
  "duration": 55602763,
  "status": "passed"
});
formatter.after({
  "duration": 264290,
  "status": "passed"
});
formatter.after({
  "duration": 212544,
  "status": "passed"
});
formatter.after({
  "duration": 247612,
  "status": "passed"
});
formatter.after({
  "duration": 1534536297,
  "status": "passed"
});
formatter.after({
  "duration": 348539,
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
  "duration": 8282036336,
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
  "duration": 6277297498,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iAmOnTheAddFriendsPage()"
});
formatter.result({
  "duration": 1852445562,
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
  "duration": 377834761,
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
  "duration": 682408053,
  "status": "passed"
});
formatter.after({
  "duration": 1253247928,
  "status": "passed"
});
formatter.after({
  "duration": 291661,
  "status": "passed"
});
formatter.after({
  "duration": 184319,
  "status": "passed"
});
formatter.after({
  "duration": 251033,
  "status": "passed"
});
formatter.after({
  "duration": 217677,
  "status": "passed"
});
formatter.after({
  "duration": 166358,
  "status": "passed"
});
formatter.after({
  "duration": 256165,
  "status": "passed"
});
formatter.after({
  "duration": 243763,
  "status": "passed"
});
formatter.after({
  "duration": 271988,
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
  "duration": 6055624147,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iAmOnTheAddFriendsPage()"
});
formatter.result({
  "duration": 2399862381,
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
  "duration": 373479101,
  "status": "passed"
});
formatter.match({
  "location": "SearchFriendSteps.iFindNoEntryInList()"
});
formatter.result({
  "duration": 11495881047,
  "status": "passed"
});
formatter.after({
  "duration": 1460514459,
  "status": "passed"
});
formatter.after({
  "duration": 384461,
  "status": "passed"
});
formatter.after({
  "duration": 294653,
  "status": "passed"
});
formatter.after({
  "duration": 259586,
  "status": "passed"
});
formatter.after({
  "duration": 254454,
  "status": "passed"
});
formatter.after({
  "duration": 242480,
  "status": "passed"
});
formatter.after({
  "duration": 261297,
  "status": "passed"
});
formatter.after({
  "duration": 263863,
  "status": "passed"
});
formatter.after({
  "duration": 237348,
  "status": "passed"
});
});