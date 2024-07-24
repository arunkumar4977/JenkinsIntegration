package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(tags="",
features="src/test/resources/features/login.feature",
glue={"StepDefinitions","AppHooks"})
public class TestRunner {
	
	

}
