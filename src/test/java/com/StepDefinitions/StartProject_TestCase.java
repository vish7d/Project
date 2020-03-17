package com.StepDefinitions;

import java.io.IOException;

import com.ExcelUtilities.ExcelReadWrite;
import com.Pages.StartProject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StartProject_TestCase extends StartProject{
	
	@Given("^The user should be logged in$")
	public void the_user_should_be_logged_in(){
		this.createReport();
		this.clickLogin();
		this.PerformLogin();
	}

	@Given("^Start project should be navigated$")
	public void start_project_should_be_navigated(){
		this.clickStartProject();
	}

	@When("^Enter values to necessary fields\\.$")
	public void enter_values_to_necessary_fields() throws IOException{
		ExcelReadWrite obj = new ExcelReadWrite();
		int len = obj.ExcelRowLength("StartProject");
		for(int i=1;i<len;i++) {
			String categ = obj.ExcelRead("StartProject", i, 0);
			String desc = obj.ExcelRead("StartProject", i, 1);
			String country = obj.ExcelRead("StartProject", i, 2);
			//System.out.println(categ+desc+country);
			this.SelectCategory(categ);
			this.EnterDescription(desc);
			this.SelectCountry(country);
			String tmp = String.valueOf(i);
			this.screensht("Project"+tmp+".png");
			DeleteProject();
			obj.ExcelWrite("StartProject", i, 3, "PASS");
			clickStartProject();
		}
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes(){
		   this.flusher();
		   this.quit();
	}

}
