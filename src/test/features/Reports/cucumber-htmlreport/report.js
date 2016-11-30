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
  "duration": 21485687905,
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
  "duration": 10475866824,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 1301684915,
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
  "duration": 1186808830,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 3160128759,
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
  "duration": 182765786,
  "status": "passed"
});
formatter.after({
  "duration": 1415288728,
  "status": "passed"
});
formatter.after({
  "duration": 836065,
  "status": "passed"
});
formatter.after({
  "duration": 1510048,
  "status": "passed"
});
formatter.after({
  "duration": 953241,
  "status": "passed"
});
formatter.after({
  "duration": 619671,
  "status": "passed"
});
formatter.after({
  "duration": 1058017,
  "status": "passed"
});
formatter.after({
  "duration": 981894,
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
  "duration": 10066686282,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.navigateToPasswordSettings()"
});
formatter.result({
  "duration": 1051662357,
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
  "duration": 1257714350,
  "status": "passed"
});
formatter.match({
  "location": "ChangePasswordSteps.theChangePasswordButtonIsClicked()"
});
formatter.result({
  "duration": 3245118646,
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
  "duration": 142886162,
  "status": "passed"
});
formatter.after({
  "duration": 1735816950,
  "status": "passed"
});
formatter.after({
  "duration": 677832,
  "status": "passed"
});
formatter.after({
  "duration": 567069,
  "status": "passed"
});
formatter.after({
  "duration": 416107,
  "status": "passed"
});
formatter.after({
  "duration": 536706,
  "status": "passed"
});
formatter.after({
  "duration": 445616,
  "status": "passed"
});
formatter.after({
  "duration": 431075,
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
  "duration": 6008119874,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"form-email\"}\n  (Session info: chrome\u003d54.0.2840.99)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 83 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027WaldemarLaptop\u0027, ip: \u0027169.254.178.50\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\Waldemar\\AppData\\Local\\Temp\\scoped_dir7344_32542}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d54.0.2840.99, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: c6fbc2e1fa1fecf913c1e1c582091970\n*** Element info: {Using\u003did, value\u003dform-email}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat com.vnv.ZCucumber.BackgroundSteps.loginAndDeleteTheRegisteredUserWithTheEmailAndThePasswordFromDatabaseAgain(BackgroundSteps.java:70)\r\n\tat ✽.Then login and delete the registered user with the email \"change@password.de\" and the password \"test\" from database again(changePassword.feature:22)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 851887,
  "status": "passed"
});
formatter.after({
  "duration": 543976,
  "status": "passed"
});
formatter.after({
  "duration": 499500,
  "status": "passed"
});
formatter.after({
  "duration": 504205,
  "status": "passed"
});
formatter.after({
  "duration": 1590452959,
  "status": "passed"
});
formatter.after({
  "duration": 2511186,
  "status": "passed"
});
formatter.after({
  "duration": 334426,
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
  "duration": 14485238441,
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
  "duration": 9697711665,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 863502138,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 234298991,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 653786858,
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
  "duration": 3440170087,
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
  "duration": 144220872,
  "status": "passed"
});
formatter.after({
  "duration": 542693,
  "status": "passed"
});
formatter.after({
  "duration": 383606,
  "status": "passed"
});
formatter.after({
  "duration": 398146,
  "status": "passed"
});
formatter.after({
  "duration": 5532564,
  "status": "passed"
});
formatter.after({
  "duration": 455880,
  "status": "passed"
});
formatter.after({
  "duration": 1666338086,
  "status": "passed"
});
formatter.after({
  "duration": 506343,
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
  "duration": 14890888696,
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
  "duration": 10092460582,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theSettingsAreSelected()"
});
formatter.result({
  "duration": 822465282,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountSettingsIsSelected()"
});
formatter.result({
  "duration": 237567554,
  "status": "passed"
});
formatter.match({
  "location": "DeleteAccountSteps.theDeleteAccountButtonIsClicked()"
});
formatter.result({
  "duration": 662363894,
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
  "duration": 3673288325,
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
  "duration": 496605494,
  "status": "passed"
});
formatter.after({
  "duration": 539273,
  "status": "passed"
});
formatter.after({
  "duration": 505060,
  "status": "passed"
});
formatter.after({
  "duration": 421240,
  "status": "passed"
});
formatter.after({
  "duration": 19192272,
  "status": "passed"
});
formatter.after({
  "duration": 756948,
  "status": "passed"
});
formatter.after({
  "duration": 1492982406,
  "status": "passed"
});
formatter.after({
  "duration": 342551,
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
  "duration": 13991932301,
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
  "duration": 10039887750,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.navigatedToProfileSettings()"
});
formatter.result({
  "duration": 755116563,
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
  "duration": 647167624,
  "status": "passed"
});
formatter.match({
  "location": "EditProfileSteps.saveProfileButtonIsClicked()"
});
formatter.result({
  "duration": 552047032,
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
  "duration": 1676144200,
  "status": "passed"
});
formatter.after({
  "duration": 279686,
  "status": "passed"
});
formatter.after({
  "duration": 204847,
  "status": "passed"
});
formatter.after({
  "duration": 171062,
  "status": "passed"
});
formatter.after({
  "duration": 1165222121,
  "status": "passed"
});
formatter.after({
  "duration": 212545,
  "status": "passed"
});
formatter.after({
  "duration": 218959,
  "status": "passed"
});
formatter.after({
  "duration": 201853,
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
  "duration": 14324563568,
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
  "duration": 6740549374,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 3241800904,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theMainPageIsShown()"
});
formatter.result({
  "duration": 79631379,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoggedInUserIsDeletedFromDatabaseAgain()"
});
formatter.result({
  "duration": 2024614074,
  "status": "passed"
});
formatter.after({
  "duration": 348538,
  "status": "passed"
});
formatter.after({
  "duration": 280969,
  "status": "passed"
});
formatter.after({
  "duration": 1205860832,
  "status": "passed"
});
formatter.after({
  "duration": 221952,
  "status": "passed"
});
formatter.after({
  "duration": 136849,
  "status": "passed"
});
formatter.after({
  "duration": 108625,
  "status": "passed"
});
formatter.after({
  "duration": 98789,
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
  "duration": 6981706657,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 3194870970,
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
  "duration": 144025006,
  "status": "passed"
});
formatter.after({
  "duration": 496079,
  "status": "passed"
});
formatter.after({
  "duration": 383606,
  "status": "passed"
});
formatter.after({
  "duration": 1841292338,
  "status": "passed"
});
formatter.after({
  "duration": 514040,
  "status": "passed"
});
formatter.after({
  "duration": 353670,
  "status": "passed"
});
formatter.after({
  "duration": 311332,
  "status": "passed"
});
formatter.after({
  "duration": 623948,
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
  "duration": 7374160782,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.theLoginButtonIsClicked()"
});
formatter.result({
  "duration": 3156152001,
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
  "duration": 173374069,
  "status": "passed"
});
formatter.after({
  "duration": 464433,
  "status": "passed"
});
formatter.after({
  "duration": 316464,
  "status": "passed"
});
formatter.after({
  "duration": 1542722884,
  "status": "passed"
});
formatter.after({
  "duration": 445616,
  "status": "passed"
});
formatter.after({
  "duration": 387455,
  "status": "passed"
});
formatter.after({
  "duration": 381895,
  "status": "passed"
});
formatter.after({
  "duration": 521738,
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
  "duration": 14318868067,
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
  "duration": 9953992944,
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
  "duration": 617575226,
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
  "duration": 452186747,
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
  "duration": 2016356496,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1198538106,
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
  "duration": 160089842,
  "status": "passed"
});
formatter.after({
  "duration": 425088,
  "status": "passed"
});
formatter.after({
  "duration": 1324174402,
  "status": "passed"
});
formatter.after({
  "duration": 450748,
  "status": "passed"
});
formatter.after({
  "duration": 452886,
  "status": "passed"
});
formatter.after({
  "duration": 380612,
  "status": "passed"
});
formatter.after({
  "duration": 717604,
  "status": "passed"
});
formatter.after({
  "duration": 322879,
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
  "duration": 9837213370,
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
  "duration": 559174319,
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
  "duration": 598897421,
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
  "duration": 1806234088,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1155126485,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 68659051,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 1985260037,
  "status": "passed"
});
formatter.after({
  "duration": 676977,
  "status": "passed"
});
formatter.after({
  "duration": 1427368682,
  "status": "passed"
});
formatter.after({
  "duration": 313471,
  "status": "passed"
});
formatter.after({
  "duration": 127868,
  "status": "passed"
});
formatter.after({
  "duration": 109052,
  "status": "passed"
});
formatter.after({
  "duration": 156094,
  "status": "passed"
});
formatter.after({
  "duration": 106914,
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
  "duration": 14735693786,
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
  "duration": 9940429459,
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
  "duration": 523516499,
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
  "duration": 475495619,
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
  "duration": 2197078949,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1240103971,
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
  "duration": 149582802,
  "status": "passed"
});
formatter.after({
  "duration": 389165,
  "status": "passed"
});
formatter.after({
  "duration": 1425221001,
  "status": "passed"
});
formatter.after({
  "duration": 416107,
  "status": "passed"
});
formatter.after({
  "duration": 272416,
  "status": "passed"
});
formatter.after({
  "duration": 241197,
  "status": "passed"
});
formatter.after({
  "duration": 300213,
  "status": "passed"
});
formatter.after({
  "duration": 254026,
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
  "duration": 9643226361,
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
  "duration": 503612182,
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
  "duration": 562298334,
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
  "duration": 1983112358,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1168892679,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 80269440,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 2048290302,
  "status": "passed"
});
formatter.after({
  "duration": 405844,
  "status": "passed"
});
formatter.after({
  "duration": 1306874928,
  "status": "passed"
});
formatter.after({
  "duration": 256592,
  "status": "passed"
});
formatter.after({
  "duration": 159943,
  "status": "passed"
});
formatter.after({
  "duration": 141126,
  "status": "passed"
});
formatter.after({
  "duration": 162937,
  "status": "passed"
});
formatter.after({
  "duration": 162509,
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
  "duration": 14682201924,
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
  "duration": 10050214319,
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
  "duration": 551188729,
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
  "duration": 480933672,
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
  "duration": 2342652492,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1170040504,
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
  "duration": 154409737,
  "status": "passed"
});
formatter.after({
  "duration": 402850,
  "status": "passed"
});
formatter.after({
  "duration": 1451101787,
  "status": "passed"
});
formatter.after({
  "duration": 395581,
  "status": "passed"
});
formatter.after({
  "duration": 186458,
  "status": "passed"
});
formatter.after({
  "duration": 176194,
  "status": "passed"
});
formatter.after({
  "duration": 197577,
  "status": "passed"
});
formatter.after({
  "duration": 203991,
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
  "duration": 9776401349,
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
  "duration": 544507913,
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
  "duration": 454603849,
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
  "duration": 2060731195,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theCreateOfferButtonIsClicked()"
});
formatter.result({
  "duration": 1172578204,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown()"
});
formatter.result({
  "duration": 62459773,
  "status": "passed"
});
formatter.match({
  "location": "OfferDienstleistungenSteps.cleanupOfferDienstleistungen()"
});
formatter.result({
  "duration": 1975558271,
  "status": "passed"
});
formatter.after({
  "duration": 503349,
  "status": "passed"
});
formatter.after({
  "duration": 1436297677,
  "status": "passed"
});
formatter.after({
  "duration": 276693,
  "status": "passed"
});
formatter.after({
  "duration": 170207,
  "status": "passed"
});
formatter.after({
  "duration": 172772,
  "status": "passed"
});
formatter.after({
  "duration": 169351,
  "status": "passed"
});
formatter.after({
  "duration": 171489,
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
  "duration": 9215368016,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 3253475013,
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
  "duration": 156189206,
  "status": "passed"
});
formatter.after({
  "duration": 2498357,
  "status": "passed"
});
formatter.after({
  "duration": 2512897,
  "status": "passed"
});
formatter.after({
  "duration": 2447893,
  "status": "passed"
});
formatter.after({
  "duration": 4691796,
  "status": "passed"
});
formatter.after({
  "duration": 2232356,
  "status": "passed"
});
formatter.after({
  "duration": 2166925,
  "status": "passed"
});
formatter.after({
  "duration": 1331935046,
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
  "duration": 8620937017,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 3301226898,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.theRegisterPageIsShown()"
});
formatter.result({
  "duration": 172712059,
  "status": "passed"
});
formatter.after({
  "duration": 491375,
  "status": "passed"
});
formatter.after({
  "duration": 231361,
  "status": "passed"
});
formatter.after({
  "duration": 293371,
  "status": "passed"
});
formatter.after({
  "duration": 313898,
  "status": "passed"
});
formatter.after({
  "duration": 266856,
  "status": "passed"
});
formatter.after({
  "duration": 296365,
  "status": "passed"
});
formatter.after({
  "duration": 1595811040,
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
  "duration": 9413113251,
  "status": "passed"
});
formatter.match({
  "location": "RegisterSteps.the_register_button_is_clicked()"
});
formatter.result({
  "duration": 3371860429,
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
  "duration": 127710420,
  "status": "passed"
});
formatter.after({
  "duration": 387027,
  "status": "passed"
});
formatter.after({
  "duration": 265146,
  "status": "passed"
});
formatter.after({
  "duration": 227512,
  "status": "passed"
});
formatter.after({
  "duration": 10330847,
  "status": "passed"
});
formatter.after({
  "duration": 444760,
  "status": "passed"
});
formatter.after({
  "duration": 319030,
  "status": "passed"
});
formatter.after({
  "duration": 1338476875,
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
  "duration": 11763024320,
  "status": "passed"
});
formatter.after({
  "duration": 769778,
  "status": "passed"
});
formatter.after({
  "duration": 316037,
  "status": "passed"
});
formatter.after({
  "duration": 274554,
  "status": "passed"
});
formatter.after({
  "duration": 23228902,
  "status": "passed"
});
formatter.after({
  "duration": 1561744094,
  "status": "passed"
});
formatter.after({
  "duration": 301924,
  "status": "passed"
});
formatter.after({
  "duration": 187312,
  "status": "passed"
});
});