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
        WebElement profil = browser.findElement(By.linkText("Profil"));
        profil.click();
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
        Thread.sleep(100);

        browser.findElement(id("form-password")).sendKeys(password);
        Thread.sleep(100);

        browser.findElement(tagName("button")).click();
        Thread.sleep(3000);
    }
}
