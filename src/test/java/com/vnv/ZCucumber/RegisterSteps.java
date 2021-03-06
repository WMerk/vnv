package com.vnv.ZCucumber;


import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class RegisterSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @Given("^the username is \"([^\"]*)\" and the email is \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void the_username_is_something_and_the_email_is_something_and_the_password_something(String username, String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("anchorLoginShowRegister")).click();

        if(!username.isEmpty()) {
            browser.findElement(id("form-firstname")).sendKeys(username.split(" ")[0]);
            browser.findElement(id("form-lastname")).sendKeys(username.split(" ")[1]);
        }

        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(id("form-confirmPassword")).sendKeys(password);

    }

    @When("^the register button is clicked$")
    public void the_register_button_is_clicked() throws Throwable {
        WebElement registerForm = browser.findElement(id("signUp"));
        registerForm.click();
        Thread.sleep(1000);
    }

    @Then("^the register page is shown and the cssSelector is \"([^\"]*)\" and the message is \"([^\"]*)\"$")
    public void theRegisterPageIsShownAndTheCssSelectorIsAndTheMessageIs(String cssSelector, String message) throws Throwable {

        WebElement element = browser.findElement(id("successfulRegistration"));
        String text = element.getText();
        assertThat(text.contains(message), Matchers.is(true));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

    @Then("^the register page is shown$")
    public void theRegisterPageIsShown() throws Throwable {
        WebElement registerForm = browser.findElement(id("form-firstname"));
        String username = registerForm.getText();
        assertThat(username, Matchers.isEmptyOrNullString());
    }

    @Then("^an Registrationerror with the message \"([^\"]*)\" is shown$")
    public void anRegistrationerrorWithTheMessageIsShown(String message) throws Throwable {
        WebElement registerError = browser.findElement(id("errorAlreadyRegistered"));
        String text = registerError.getText();
        assertThat(text,Matchers.is(message));
    }


}
