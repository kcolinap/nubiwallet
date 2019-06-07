package suite.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\regression\\Dashboard.feature",
        glue = {"steps/def"},
        monochrome = true
)
public class DashboardR {
}
