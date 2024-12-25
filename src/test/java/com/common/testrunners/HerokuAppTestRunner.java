package com.common.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = {"com.internet.herokuapp.stepdefs", "com.common"},   // Package containing step definition classes
        plugin = {
                "pretty",                            // Prints Gherkin steps in the console
                "html:target/cucumber-reports.html", // Generates an HTML report
                "json:target/cucumber-reports.json"  // Generates a JSON report
        },
        monochrome = true,                       // Makes console output more readable
        tags = "@WebTable"                      // Executes scenarios tagged with @SmokeTest
)
public class HerokuAppTestRunner {
}
