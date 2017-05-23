package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteFriendSteps extends BasedriverConfiguration{
    @And("^logged in to delete a friend with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loggedInToDeleteAFriendWithTheEmailAndThePassword(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I want to delete \"([^\"]*)\" and click on the button$")
    public void iWantToDeleteAndClickOnTheButton(String friendName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^friend is deleted and the message \"([^\"]*)\" appears$")
    public void friendIsDeletedAndTheMessageAppears(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
