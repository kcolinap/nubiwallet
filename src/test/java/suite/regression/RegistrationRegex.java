package suite.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\regression\\registration\\",
        glue = "stepsregex",
        monochrome = true
)
public class RegistrationRegex {

}
