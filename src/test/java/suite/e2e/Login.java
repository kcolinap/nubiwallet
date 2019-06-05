package suite.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\e2e\\F2login.feature",
        glue = "stepdefinitions\\endtoend\\",
        tags = "@e2e",
        strict = true,
        monochrome = true
)
public class Login {
}
