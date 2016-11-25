package com.vnv.ZCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(   plugin ={ "pretty",
        "html:target/cucumber-htmlreport"},
        features = "src/test/features/offerVerschenken.feature")
public class OfferVerschenkenTest {
}
