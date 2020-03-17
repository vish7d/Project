package com.StepDefinitions;

import com.Pages.Logout;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout_TestCase extends Logout{
	
	@When("^User is loggedin$")
	public void user_is_loggedin() throws Throwable {
		this.clickLogin();
		this.PerformLogin();
	}
	
	@Then("^User should be logged out$")
	public void user_should_be_logged_out() throws Throwable {
		this.performLogout();
	}

}
