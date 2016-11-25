package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
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

public class ChangePasswordSteps extends BasedriverConfiguration {

    private WebDriver browser;

    @And("^login to change the password with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginToChangeThePasswordWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        Thread.sleep(100);
        browser.findElement(id("form-password")).sendKeys(password);
        Thread.sleep(100);
        browser.findElement(tagName("button")).click();
        Thread.sleep(3000);
    }

    @And("^navigate to password settings$")
    public void navigateToPasswordSettings() throws Throwable {
        browser.findElement(By.linkText("Profil")).click();
        browser.findElement(By.linkText("Einstellungen")).click();
        browser.findElement(By.linkText("Passwort ändern")).click();
    }

    @When("^the actual password \"([^\"]*)\" new password \"([^\"]*)\" and confirm password \"([^\"]*)\" is entered$")
    public void theActualPasswordNewPasswordAndConfirmPasswordIsEntered(String actualPassword, String newPassword, String confirmPassword) throws Throwable {
        browser.findElement(id("form-actualPW")).sendKeys(actualPassword);
        browser.findElement(id("form-newPW")).sendKeys(newPassword);
        browser.findElement(id("form-confirmNewPW")).sendKeys(confirmPassword);
    }

    @And("^the change password button is clicked$")
    public void theChangePasswordButtonIsClicked() throws Throwable {
        browser.findElement(id("form-changePW")).click();
        Thread.sleep(1000);
    }

    @Then("^the message \"([^\"]*)\" is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        WebElement element = browser.findElement(id("successfulChangePassword"));
        String text = element.getText();
        assertThat(text.contains(message), Matchers.is(true));
    }
}
