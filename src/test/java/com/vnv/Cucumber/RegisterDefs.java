package com.vnv.Cucumber;


import Configuration.BasedriverConfiguration;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class RegisterDefs extends BasedriverConfiguration {

    private WebDriver browser;



    @Given("^the username is \"([^\"]*)\" and the email is \"([^\"]*)\" and the password \"([^\"]*)\"$")

    public void the_username_is_something_and_the_email_is_something_and_the_password_something(String username, String email, String password) throws Throwable {

        browser = webDriver();

        browser.get("localhost:8080/#/Register");

        browser.findElement(id("form-firstname")).sendKeys(username);

        Thread.sleep(100);

        browser.findElement(id("form-lastname")).sendKeys(username);

        Thread.sleep(100);

        Random random = new Random();

        browser.findElement(id("form-email")).sendKeys(email);

        Thread.sleep(100);

        browser.findElement(id("form-password")).sendKeys(password);

        Thread.sleep(100);

        browser.findElement(id("form-confirmPassword")).sendKeys(password);

    }



    @When("^the register button is clicked$")

    public void the_register_button_is_clicked() throws Throwable {

        Thread.sleep(1000);

        WebElement registerForm = browser.findElement(id("signUp"));

        registerForm.submit();

    }



    @Then("^the register page is shown and the cssSelector is \"([^\"]*)\" and the message is \"([^\"]*)\"$")

    public void theRegisterPageIsShownAndTheCssSelectorIsAndTheMessageIs(String cssSelector, String message) throws Throwable {

        Thread.sleep(1000);
        browser.get("localhost:8080/#/Main");

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

        Thread.sleep(1000);

        WebElement registerForm = browser.findElement(id("register-button"));

        String disabled = registerForm.getAttribute("disabled");

        assertThat(disabled, Matchers.notNullValue());

    }
}
