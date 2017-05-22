package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class ChangePasswordSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @And("^login to change the password with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginToChangeThePasswordWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
    }

    @And("^navigate to password settings$")
    public void navigateToPasswordSettings() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        browser.findElement(By.linkText("Einstellungen")).click();
        browser.findElement(By.linkText("Passwort ändern")).click();
    }

    @And("^the actual password \"([^\"]*)\" new password \"([^\"]*)\" and confirm password \"([^\"]*)\" is entered$")
    public void theActualPasswordNewPasswordAndConfirmPasswordIsEntered(String actualPassword, String newPassword, String confirmPassword) throws Throwable {
        browser.findElement(id("passwordInputCurrentPw")).sendKeys(actualPassword);
        browser.findElement(id("passwordInputNewPw")).sendKeys(newPassword);
        browser.findElement(id("passwordInputConfirmPw")).sendKeys(confirmPassword);
    }

    @When("^the change password button is clicked$")
    public void theChangePasswordButtonIsClicked() throws Throwable {
        browser.findElement(id("passwordButtonChangePw")).click();
    }

    @Then("^the message \"([^\"]*)\" form element with id \"([^\"]*)\" is shown$")
    public void theMessageFormElementWithIdIsShown(String message, String password) throws Throwable {
        assertThat(browser.findElement(id(password)).getText().equals(message), Matchers.is(true));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }
}
