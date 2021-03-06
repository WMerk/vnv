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

import javax.swing.table.TableRowSorter;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class OfferDienstleistungenSteps extends BasedriverConfiguration{

    private WebDriver browser;

    @And("^offer login with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void offerLoginWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
    }

    @And("^the Link \"([^\"]*)\" is clicked$")
    public void theLinkIsClicked(String linkName) throws Throwable {
        browser.findElement(By.linkText(linkName)).click();
        Thread.sleep(300);
    }

    @And("^the flavior \"([^\"]*)\" is selected$")
    public void theFlaviorIsSelected(String flavior) throws Throwable {
        browser.findElement(By.linkText(flavior)).click();
    }

    @And("^the offer with offername \"([^\"]*)\" and the category \"([^\"]*)\" and the endtime \"([^\"]*)\" and the description \"([^\"]*)\" is created$")
    public void theOfferWithOffernameAndTheCategoryAndTheEndtimeAndTheDescriptionIsCreated(String offername, String category, String endtime, String description) throws Throwable {
        browser.findElement(id("insertOfferName")).sendKeys(offername);
        browser.findElement(id("dropdownMenu1")).click();
        browser.findElement(By.linkText(category)).click();
        browser.findElement(id("insertOfferDate")).sendKeys(endtime);
        browser.findElement(id("insertOfferDescription")).sendKeys(description);

    }


    @When("^the create offer Button is clicked$")
    public void theCreateOfferButtonIsClicked() throws Throwable {
        browser.findElement(id("insertOfferSubmitButton")).click();
        Thread.sleep(1000);
    }

    @Then("^the mainpage with the message \"([^\"]*)\" in the element with id \"([^\"]*)\" is shown$")
    public void theMainpageWithTheMessageInTheElementWithIdIsShown(String message, String id) throws Throwable {
        WebElement succeessMessage = browser.findElement(id(id));
        String text = succeessMessage.getText().split("\\n")[1];
        assertThat(message, Matchers.equalTo(text));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }


    @Then("^cleanup offer Dienstleistungen$")
    public void cleanupOfferDienstleistungen() throws Throwable {
        cleanUp(browser);
    }

    @Then("^the offer form is still shown and an warning to fill out the offername is shown$")
    public void theOfferFormIsStillShownAndAnWarningToFillOutTheOffernameIsShown() throws Throwable {
        assertThat(browser.findElement(id("formCreateOffer")), Matchers.notNullValue());
    }
}
