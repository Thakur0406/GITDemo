package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.*;

@CucumberOptions(
		features = "src/test/java/Features",
		glue = "StepDefinations"
		)
public class TestRunnerTestNg extends AbstractTestNGCucumberTests {

}
