package test.suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "test/features/",
        glue = "main/java/test/stepDefinitions/e2e/",
        strict = true,
        monochrome = true
)
public class E2ESuite {

}
