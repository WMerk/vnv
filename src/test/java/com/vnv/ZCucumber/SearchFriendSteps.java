package com.vnv.ZCucumber;

import Configuration.BasedriverConfiguration;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class SearchFriendSteps extends BasedriverConfiguration {

    private WebDriver browser;
    @And("^login to search a friend with the email \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void loginToSearchAFriendWithTheEmailAndThePassword(String email, String password) throws Throwable {
        browser = webDriver();
        browser.findElement(id("form-email")).sendKeys(email);
        browser.findElement(id("form-password")).sendKeys(password);
        browser.findElement(tagName("button")).click();
    }
//
//    @And("^I have \"([^\"]*)\" friends$")
//    public void iHaveFriends(String arg0) throws Throwable {
////        browser.navigate().to("POST http://localhost:8080/users/fake?number=10");
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost("http://localhost:8080/users/fake?number=10");
//
//        httpClient.execute(httpPost);
//        //browser.navigate().to(httpPost.toString());
//        httpClient.close();
//    }

    @And("^I am on the add friends page$")
    public void iAmOnTheAddFriendsPage() throws Throwable {
        browser.findElement(By.linkText("Freunde hinzufügen")).click();
    }

    @When("^I type \"([^\"]*)\" in the searchfield$")
    public void iTypeInTheSearchfield(String name) throws Throwable {
        browser.findElement(id("inputShowFriendsFilter")).sendKeys(name);
    }

    @Then("^I find my friend \"([^\"]*)\"$")
    public void iFindMyFriend(String fullName) throws Throwable {
        List<WebElement> tableShowFriends = browser.findElement(id("tableShowFriends")).findElements(By.tagName("td"));
        final boolean[] contains = {false};
        tableShowFriends.forEach(x -> { if (Objects.equals(x.getText(), fullName)) contains[0] = true;
        });
        assertThat(contains[0], Matchers.is(true));
    }

    @After
    public void tearDown() throws Exception {
        closeBrowser();
    }

    @Then("^I find no entry in list$")
    public void iFindNoEntryInList() throws Throwable {
        List<WebElement> tableShowFriends = browser.findElement(id("tableShowFriends")).findElements(By.tagName("td"));
        assertThat(tableShowFriends.isEmpty(),Matchers.is(true));

        cleanUp(browser);
    }


}
