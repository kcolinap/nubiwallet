package suite.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\regression\\Login.feature",
        glue = {"steps"},
        monochrome = true
)
public class LoginR {
}
