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

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class EditProfileSteps extends BasedriverConfiguration{

    private WebDriver browser;

    @And("^login to edit profile with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginToEditProfileWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        Thread.sleep(100);
        browser.findElement(id("form-password")).sendKeys(password);
        Thread.sleep(100);
        browser.findElement(tagName("button")).click();
        Thread.sleep(3000);
    }
    @And("^navigated to profile settings$")
    public void navigatedToProfileSettings() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        Thread.sleep(100);
        browser.findElement(By.linkText("Profil bearbeiten")).click();
        Thread.sleep(100);
    }

    @And("^Vorname changed to \"([^\"]*)\"$")
    public void vornameChangedTo(String vorname) throws Throwable {
        browser.findElement(id("updateUserInputFirstName")).clear();
        Thread.sleep(100);
        browser.findElement(id("updateUserInputFirstName")).sendKeys(vorname);
    }

    @When("^save profile button is clicked$")
    public void saveProfileButtonIsClicked() throws Throwable {
        browser.findElement(id("updateUserButtonUpdate")).click();
        Thread.sleep(300);
    }

    @Then("^the success message \"([^\"]*)\" in the field with id \"([^\"]*)\" is shown$")
    public void theSuccessMessageInTheFieldWithIdIsShown(String message, String id) throws Throwable {
        assertThat(browser.findElement(id(id)).getText().equals(message), Matchers.is(true));
        cleanUp(browser);
    }



    @And("^the prename is changed to \"([^\"]*)\"$")
    public void thePrenameIsChangedTo(String vorname) throws Throwable {
        String text = browser.findElement(id("updateUserInputFirstName")).getText();
        assertThat(text.equals(vorname), Matchers.is(true));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }
}
