package com.google.searchengine.views;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.searchengine.utils.DriverUtils;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEngineView {
	
	private static String expectedResult;
	
	private static By inputSearch = By.name("q");
	private static By inputGoogleSearchButton = By.name("btnK");
	private static By spanFirstMatch = By.className("aypzV");
	private static By titleResult = By.cssSelector(".LC20lb.DKV0Md");
	
	@Given("I am on the homepage")
	public void iAmOnTheHomepage() {
	    DriverUtils.startDriverConfiguration();
	    DriverUtils.driver.navigate().to("https://www.google.com/?hl=en");
	}

	@When("I type {string} into the search field")
	public void iTypeIntoTheSearchField(String text) {
	    DriverUtils.waitElementToLoad(inputSearch, 5).sendKeys(text);
	}
	
	@When("I click the Google Search button")
	public void iClickTheGoogleSearchButton() {
	    DriverUtils.waitElementToLoad(inputGoogleSearchButton, 5).submit();
	}
	
	@Then("I go to the search results page")
	public void iGoToTheSearchResultsPage() {
	    try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Then("the first result is {string}")
	public void theFirstResultIs(String expectedText) {
	    expectedResult = DriverUtils.waitElementToLoad(titleResult, 5).getText();
	    Assert.assertEquals(expectedText, expectedResult);
	}
	
	@When("I click on the first result link")
	public void iClickOnTheFirstResultLink() {
		DriverUtils.waitElementToLoad(titleResult, 5).click();
	}
	
	@Then("I go to the {string} page")
	public void iGoToThePage(String pageName) {
	    String title = DriverUtils.driver.getTitle();
	    Assert.assertEquals(title, pageName);
	}
	
	@When("the suggestions list is displayed")
	public void theSuggestionsListIsDisplayed() {
	    try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
	}

	@When("I click on the first suggestion in the list")
	public void iClickOnTheFirstSuggestionInTheList() {
	    DriverUtils.waitElementToLoad(spanFirstMatch, 5).click();
	}
	
	@After
	public void tearDown() {
		DriverUtils.driver.quit();
	}
	
}
