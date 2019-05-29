package test.suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "test/features/",
        glue = "test/stepDefinitions/e2e/"
)
public class E2ESuite {

}