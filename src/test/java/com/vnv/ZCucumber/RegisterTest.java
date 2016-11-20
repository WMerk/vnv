package com.vnv.ZCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Must have 'Test' as suffix to be registered as testclass
 */
@RunWith(Cucumber.class)
@CucumberOptions(   plugin ={ "pretty",
                            "html:target/cucumber-htmlreport"},
                    features = "src/test/features/register.feature")
public class RegisterTest {
}
