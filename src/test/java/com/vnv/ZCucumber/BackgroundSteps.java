package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;


public class BackgroundSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @Given("^a registerd user named \"([^\"]*)\" with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void aRegisterdUserWithNamedWithEmailAndPassword(String name, String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("anchorLoginShowRegister")).click();
        Thread.sleep(1000);

        if(!name.isEmpty()) {
            browser.findElement(id("form-firstname")).sendKeys(name.split(" ")[0]);
            Thread.sleep(100);
            browser.findElement(id("form-lastname")).sendKeys(name.split(" ")[1]);
            Thread.sleep(100);
        }

        browser.findElement(id("form-email")).sendKeys(email);
        Thread.sleep(300);
        browser.findElement(id("form-password")).sendKeys(password);
        Thread.sleep(100);
        browser.findElement(id("form-confirmPassword")).sendKeys(password);

        browser.findElement(id("signUp")).click();
        Thread.sleep(3000);

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
}
