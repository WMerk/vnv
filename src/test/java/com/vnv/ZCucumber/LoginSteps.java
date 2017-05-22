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

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class LoginSteps extends BasedriverConfiguration {

    private WebDriver browser;


    @Given("^the email is \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void theEmailIsAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();

        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
    }

    @When("^the login button is clicked$")
    public void theLoginButtonIsClicked() throws Throwable {
        WebElement registerForm = browser.findElement(tagName("button"));
        registerForm.click();
    }

    @Then("^the main page is shown$")
    public void theMainPageIsShown() throws Throwable {

        WebElement element = browser.findElement(id("successfulRegistration"));
        String text = browser.getCurrentUrl();
        assertThat(text.contains("Main"), Matchers.is(true));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

    @Then("^an login error with the message \"([^\"]*)\" is shown$")
    public void anLoginErrorWithTheMessageIsShown(String message) throws Throwable {
        WebElement element = browser.findElement(id("errorLogin"));
        String text = element.getText();
        assertThat(text.contains(message), Matchers.is(true));
    }

    @Then("^the logged in user is deleted from database again$")
    public void theLoggedInUserIsDeletedFromDatabaseAgain() throws Throwable {
        cleanUp(browser);
    }
}
