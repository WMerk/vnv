package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AcceptFriendSteps extends BasedriverConfiguration {
    @And("^logged in to accept a friend with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loggedInToAcceptAFriendWithTheEmailAndThePassword(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I want to accept \"([^\"]*)\" and click on the button$")
    public void iWantToAcceptAndClickOnTheButton(String buttontext) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^friend is accepted and the message \"([^\"]*)\" appears$")
    public void friendIsAcceptedAndTheMessageAppears(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
