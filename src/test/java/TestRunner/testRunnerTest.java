package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/", //".//Features/"
        glue="StepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:Target/cucumber.html"}, //for Report generation  "
        monochrome = true,
        tags= "@regression, @sanity"
)

public class testRunnerTest {
}
