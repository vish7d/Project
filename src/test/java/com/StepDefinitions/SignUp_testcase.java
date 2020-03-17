package com.StepDefinitions;

import com.Pages.SignUp;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUp_testcase extends SignUp{
	@When("^Sign up page is open$")
	public void sign_up_page_is_open() throws Throwable {
		this.createReport();
		this.clickSignup();
	}

	@Then("^Do the sign up actions$")
	public void do_the_sign_up_actions() throws Throwable {
		this.performSignup();
		this.flusher();
	}
	
}
