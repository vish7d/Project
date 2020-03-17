package com.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features="C:\\Users\\Sreelakshmi\\eclipse-workspace\\PROJECT\\src\\test\\resources\\com\\Features",
        glue = {"com.StepDefinitions"})
public class CucumberRunner {

}
