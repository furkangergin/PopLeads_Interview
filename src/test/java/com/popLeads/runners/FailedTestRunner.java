package com.popLeads.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/popLeads/stepDefinition",
        features = "@target/cucumber-report.txt"
)
public class FailedTestRunner {
}
