package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Waldemar on 23.05.2017.
 */
public class EditStatusSteps extends BasedriverConfiguration{
    @And("^login to edit status with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginToEditStatusWithTheEmailAndThePassword(String message, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^navigated to offers$")
    public void navigatedToOffers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^status changed to \"([^\"]*)\"$")
    public void statusChangedTo(String statusText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^save status button is clicked$")
    public void saveStatusButtonIsClicked() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^a successful edited status message \"([^\"]*)\" appears$")
    public void aSuccessfulEditedStatusMessageAppears(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
