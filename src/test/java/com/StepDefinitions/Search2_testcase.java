package com.StepDefinitions;

import org.testng.annotations.Test;

import com.Pages.Search;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search2_testcase extends Search{
   
	@Test
	@Given("^I do a multiple keyword search for \\(\\.\\.\\.\\)$")
	public void i_do_a_multiple_keyword_search_for() throws Throwable {
		this.createReport();
		this.clickLogin();
	    this.keyword1("new apps");
	}
	@Test
	@When("^I click on certain filters$")
	public void i_click_on_certain_filters() throws Throwable {
	  this.filters();
	}
	@Test
	@When("^Click on certain projects$")
	public void click_on_certain_projects() throws Throwable {
	  this.click_project();
	}
	@Test
	@Then("^Project details are stored in excel$")
	public void project_details_are_stored_in_excel() throws Throwable {
	    this.store_in_excel();
	    this.flusher();
	}

}
