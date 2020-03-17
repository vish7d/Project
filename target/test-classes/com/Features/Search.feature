Feature: Search for kickstarter website

	@srch01
	Scenario: srch01- Do a valid search with a single keyword
		Given I do a single keyword search for (...)
		When I click on the certain filters
		And Click on certain project
		Then I see the project details and store in the excel
		
	@srch02
	Scenario: srch01- Do a valid search with a multiple keyword
		Given I do a multiple keyword search for (...)
		When I click on certain filters
		And Click on certain projects
		Then Project details are stored in excel
		

