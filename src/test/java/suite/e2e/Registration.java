package suite.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\e2e\\Registration.feature",
        glue = {"steps"},
        monochrome = true
)
public class Registration {


}
