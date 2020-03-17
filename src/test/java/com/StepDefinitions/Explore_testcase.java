package com.StepDefinitions;

import com.Pages.Explore;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Explore_testcase extends Explore{
	@Given("^I click on explore$")
	public void i_click_on_explore() throws Throwable {
	this.LaunchBrowser();
	this.createReport();
	this.clickLogin();
	this.PerformLogin();
	 this.explore();
	}

	@When("^And click on one of the categories$")
	public void and_click_on_one_of_the_categories() throws Throwable {
	   this.categories();
	}

	@When("^And selecting some filters$")
	public void and_selecting_some_filters() throws Throwable {
	  this.filters();
	}

	@When("^Selecting a project and backing the project$")
	public void selecting_a_project_and_backing_the_project() throws Throwable {
	   this.select();
	   this.verify_amount();
	}

	@Then("^And return to home page$")
	public void and_return_to_home_page() throws Throwable {
		this.flusher();
		this.GoBackHome();
	}
}
