package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com.sanketqa.featurefiles",
		glue = {"stepdefinitions","hooks"},
		dryRun = false,
		plugin =  {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
		
		)
					
public class RunnerClass extends AbstractTestNGCucumberTests {

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
