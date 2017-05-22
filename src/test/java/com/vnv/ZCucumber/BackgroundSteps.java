package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;


public class BackgroundSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @Given("^a registerd user named \"([^\"]*)\" with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void aRegisterdUserWithNamedWithEmailAndPassword(String name, String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("anchorLoginShowRegister")).click();

        if(!name.isEmpty()) {
            browser.findElement(id("form-firstname")).sendKeys(name.split(" ")[0]);
            browser.findElement(id("form-lastname")).sendKeys(name.split(" ")[1]);
        }

        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(id("form-confirmPassword")).sendKeys(password);

        browser.findElement(id("signUp")).click();
        closeBrowser();
    }

    @Then("^logout$")
    public void logout() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        browser.findElement(By.linkText("Ausloggen")).click();
    }

    @Then("^user is deleted from database again$")
    public void userIsDeletedFromDatabaseAgain() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        browser.findElement(By.linkText("Einstellungen")).click();
        browser.findElement(By.linkText("Account löschen")).click();
        browser.findElement(By.id("deleteAccountButton")).click();

    }

    @Given("^a registerd user named <name> with email <email> and password <password>$")
    public void aRegisterdUserNamedNameWithEmailEmailAndPasswordPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^login and delete the registered user with the email \"([^\"]*)\" and the password \"([^\"]*)\" from database again$")
    public void loginAndDeleteTheRegisteredUserWithTheEmailAndThePasswordFromDatabaseAgain(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();

        cleanUp(browser);
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

}
