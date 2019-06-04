package suite.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\regression\\registration\\",
        glue = "stepdefinitions\\regression\\",
        strict = true,
        monochrome = true
)
public class RegistrationRegexTest {


}
