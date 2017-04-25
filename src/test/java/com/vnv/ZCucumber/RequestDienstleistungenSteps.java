package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class RequestDienstleistungenSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @And("^request login with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void requestLoginWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
    }

    @And("^the request Link \"([^\"]*)\" is clicked$")
    public void theRequestLinkIsClicked(String linkName) throws Throwable {
        browser.findElement(By.linkText(linkName)).click();
        Thread.sleep(300);
    }

    @And("^the request flavior \"([^\"]*)\" is selected$")
    public void theRequestFlaviorIsSelected(String flavior) throws Throwable {
        browser.findElement(By.linkText(flavior)).click();
    }

    @And("^the request with offername \"([^\"]*)\" and the category \"([^\"]*)\" and the endtime \"([^\"]*)\" and the description \"([^\"]*)\" is created$")
    public void theRequestWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String offername, String category, String endtime, String description) throws Throwable {
        browser.findElement(id("insertRequestName")).sendKeys(offername);
        browser.findElement(id("dropdownMenu1")).click();
        browser.findElement(By.linkText(category)).click();
        browser.findElement(id("insertRequestDate")).sendKeys(endtime);
        browser.findElement(id("insertRequestDescription")).sendKeys(description);
    }

    @When("^the create request Button is clicked$")
    public void theCreateRequestButtonIsClicked() throws Throwable {
        browser.findElement(id("insertRequestSubmitButton")).click();
        Thread.sleep(1000);
    }

    @Then("^the request mainpage with the message \"([^\"]*)\" in the element with id \"([^\"]*)\" is shown$")
    public void theRequestMainpageWithTheMessageInTheElementWithIdIsShown(String message, String id) throws Throwable {
        WebElement succeessMessage = browser.findElement(id(id));
        String text = succeessMessage.getText().split("\\n")[1];
        assertThat(message, Matchers.equalTo(text));
    }

    @Then("^cleanup request Dienstleistungen$")
    public void cleanupRequestDienstleistungen() throws Throwable {
        cleanUp(browser);
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

    @Then("^the form is still shown and an warning to fill out the requestname is shown$")
    public void theFormIsStillShownAndAnWarningToFillOutTheRequestnameIsShown() throws Throwable {
        assertThat(browser.findElement(id("formCreateRequest")), Matchers.notNullValue());
    }
}
