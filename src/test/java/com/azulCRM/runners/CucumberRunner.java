package com.azulCRM.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",    // Path to your .feature files
        glue = "com/azulCRM/step_definitions",       // Package(s) where step definitions are located
        plugin = {                                   // Plugins for report generation
                "pretty",                                // For pretty console output
                "html:target/cucumber-reports.html",     // HTML report
                "json:target/cucumber.json",             // JSON report
                "junit:target/cucumber.xml"              // JUnit XML report (useful for CI integration)
        },
        tags = "@ActivityStream",                    // Tags to filter which scenarios to run
        dryRun = false,                              // If true, checks for step definitions without executing
        monochrome = true                            // More readable console output
)
public class CucumberRunner {
}




