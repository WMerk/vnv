package com.vnv.ZCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(   plugin ={ "pretty",
        "html:src/test/features/Reports/cucumber-htmlreport"},
        features = "src/test/features")
public class CucumberTestRunner {
}
