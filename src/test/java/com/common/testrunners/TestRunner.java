package com.common.testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = {"com.stepdefs","com.common"},   // Package containing step definition classes
        plugin = {
                "pretty",                            // Prints Gherkin steps in the console
                "html:target/cucumber-reports.html", // Generates an HTML report
                "json:target/cucumber-reports.json"  // Generates a JSON report
        },
        monochrome = true
)
public class TestRunner {
}
