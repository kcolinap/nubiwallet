package suite.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\features\\e2e\\Login.feature"},
        glue = {"steps"},
        tags = "@e2e",
        monochrome = true
)
public class Login {
}
