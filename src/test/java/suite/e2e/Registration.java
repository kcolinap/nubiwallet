package suite.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\e2e\\F1registration.feature",
        glue = "stepdefinitions",
        strict = true,
        monochrome = true
)
public class Registration {


}
