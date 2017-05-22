package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.tagName;

public class AddFriendSteps extends BasedriverConfiguration{

    private WebDriver browser;

    @And("^logged in to add a friend with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loggedInToAddAFriendWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
        browser.findElement(linkText("Freunde hinzufügen")).click();

    }

    @When("^I want to add \"([^\"]*)\" and click on the button$")
    public void iWantToAddAndClickOnTheButton(String username) throws Throwable {
        browser.findElement(id("inputShowFriendsFilter")).sendKeys(username);
        browser.findElement(id("buttonSearchUserAddFriend")).click();
    }

    @Then("^the buttontext changes to \"([^\"]*)\"$")
    public void theButtontextChangesTo(String buttonText) throws Throwable {
        String text = browser.findElement(id("buttonSearchUserReqSent")).getText();
        assertThat(text,Matchers.is(buttonText));

        cleanUp(browser);
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }
}
