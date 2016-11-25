package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;

public class ChangePasswordSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @And("^the change password settings is selected$")
    public void theChangePasswordSettingsIsSelected() throws Throwable {
        
        browser.findElement(By.linkText("Passwort ändern")).click();
    }

    @When("^the actual password \"([^\"]*)\" new password \"([^\"]*)\" and confirm password \"([^\"]*)\" is entered$")
    public void theActualPasswordNewPasswordAndConfirmPasswordIsEntered(String actualPassword, String newPassword, String confirmPassword) throws Throwable {
        browser.findElement(id("actualPW")).sendKeys(actualPassword);
        browser.findElement(id("newPW")).sendKeys(newPassword);
        browser.findElement(id("confirmNewPW")).sendKeys(confirmPassword);
    }

    @And("^the change password button is clicked$")
    public void theChangePasswordButtonIsClicked() throws Throwable {
        browser.findElement(id("form-changePW")).click();
        Thread.sleep(1000);
    }

    @Then("^the message \"([^\"]*)\" is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        WebElement element = browser.findElement(id("successfulRegistration"));
        String text = element.getText();
        assertThat(text.contains(message), Matchers.is(true));
    }


}
