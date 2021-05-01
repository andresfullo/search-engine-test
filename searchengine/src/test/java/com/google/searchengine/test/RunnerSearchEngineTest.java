package com.google.searchengine.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		features = "src/test/resources",
		glue = {"com.google.searchengine.views"},
		plugin = {"pretty", "html:repote/cucumber-reports.html"},
		tags = "@search or @searchAutocomplete"
		)
public class RunnerSearchEngineTest {

}
