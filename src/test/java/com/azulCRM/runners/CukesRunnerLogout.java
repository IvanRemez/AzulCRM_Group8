package com.azulCRM.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/azulCRM/step_definitions", // corrected path
        dryRun = false, // Set to false to actually run tests and generate report
        tags = "@logout",
        publish = true // generates a report with a public link
)
public class CukesRunnerLogout {}