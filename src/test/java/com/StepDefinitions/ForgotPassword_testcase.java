package com.StepDefinitions;

import com.Pages.Login2;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForgotPassword_testcase extends Login2
{
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		this.createReport();
		   this.clickLogin();
		   this.forgetPassword();
		   this.clickLogin();
	}
	@When("^User is Navigated to LogIn Page$")
	public void user_is_Navigated_to_LogIn_Page() throws Throwable {
		this.waiter(5);
		this.clickLogin();
	}
	@Then("^User enters Email and Status is updated in to excel$")
	public void user_enters_Email_and_Status_is_updated_in_to_excel() throws Throwable {
		this.read();
		this.flusher();
	}


}
