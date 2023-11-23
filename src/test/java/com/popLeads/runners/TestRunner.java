package com.popLeads.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/cucumber-report.txt",
                "junit:target/cucumber-report.xml"

        },
        features = "src/test/resources/features",
        glue = "com/popLeads/stepDefinition",
        dryRun = false,
        publish = true,
        tags = "@pop"

)



public class TestRunner {
}
