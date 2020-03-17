package com.StepDefinitions;

import com.Pages.Search;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_testcase extends Search{

	@Given("^I do a single keyword search for \\(\\.\\.\\.\\)$")
	public void i_do_a_single_keyword_search_for() throws Throwable {
		this.createReport();
		this.clickLogin();
	    this.keyword1("Software");
	}

	@When("^I click on the certain filters$")
	public void i_click_on_the_certain_filters() throws Throwable {
	  this.filters();
	}

	@When("^Click on certain project$")
	public void click_on_certain_project() throws Throwable {
	  this.click_project();
	}

	
	@Then("^I see the project details and store in the excel$")
	public void i_see_the_project_details_and_store_in_the_excel() throws Throwable {
	    this.store_in_excel();
	    this.flusher();
	}


}
