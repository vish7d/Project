package com.StepDefinitions;

import com.Pages.Login1;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login1_testcase extends Login1
{
	@When("^User Navigate to Login page$")
	public void user_Navigate_to_Login_page() throws Throwable {
		this.createReport();
		   this.clickLogin();
	}
	
	@Then("^User enters UserName and Password and Status is updated in excel$")
	public void user_enters_UserName_and_Password_and_Status_is_updated_in_excel() throws Throwable {
		   this.read();
		   this.flusher();
	}

}
