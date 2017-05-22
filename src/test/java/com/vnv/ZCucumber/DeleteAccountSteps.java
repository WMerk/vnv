package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class DeleteAccountSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @And("^the settings are selected$")
    public void theSettingsAreSelected() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        browser.findElement(By.linkText("Einstellungen")).click();
    }

    @And("^the delete account settings is selected$")
    public void theDeleteAccountSettingsIsSelected() throws Throwable {
        browser.findElement(By.linkText("Account löschen")).click();
    }

    @When("^the delete Account button is clicked$")
    public void theDeleteAccountButtonIsClicked() throws Throwable {
        browser.findElement(By.id("deleteAccountButton")).click();
    }

    @And("^the confirmation with the password \"([^\"]*)\" is done$")
    public void theConfirmationWithThePasswordIsDone(String password) throws Throwable {
        browser.findElement(id("deletAccountInputPw")).sendKeys(password);
        browser.findElement(id("confirmDeleteAccount")).click();
    }

    @Then("^the mainpage with the message \"([^\"]*)\" is shown$")
    public void theMainpageWithTheMessageIsShown(String message) throws Throwable {
        String text = browser.findElement(By.id("deleteSuccessful")).getText();
        assertThat(text.contains(message), Matchers.is(true));
    }



    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

    @And("^login with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();

        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
    }

    @Then("^an error message \"([^\"]*)\" is shown$")
    public void anErrorMessageIsShown(String message) throws Throwable {
        assertThat(browser.findElement(id("errorDeleteAccount")).getText().equals(message), Matchers.is(true));
        cleanup();
    }

    private void cleanup() {
        browser.findElement(id("deletAccountInputPw")).sendKeys("test");
        browser.findElement(id("confirmDeleteAccount")).click();
    }
}
