$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Explore.feature");
formatter.feature({
  "line": 1,
  "name": "Kickstarter Explore",
  "description": "",
  "id": "kickstarter-explore",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "exp01-Search projects using explore",
  "description": "",
  "id": "kickstarter-explore;exp01-search-projects-using-explore",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I click on explore",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "And click on one of the categories",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "And selecting some filters",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Selecting a project and backing the project",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "And return to home page",
  "keyword": "Then "
});
formatter.match({
  "location": "Explore_testcase.i_click_on_explore()"
});
formatter.result({
  "duration": 23682168100,
  "status": "passed"
});
formatter.match({
  "location": "Explore_testcase.and_click_on_one_of_the_categories()"
});
formatter.result({
  "duration": 2462512800,
  "status": "passed"
});
formatter.match({
  "location": "Explore_testcase.and_selecting_some_filters()"
});
formatter.result({
  "duration": 1842191900,
  "status": "passed"
});
formatter.match({
  "location": "Explore_testcase.selecting_a_project_and_backing_the_project()"
});
formatter.result({
  "duration": 10496376300,
  "status": "passed"
});
formatter.match({
  "location": "Explore_testcase.and_return_to_home_page()"
});
formatter.result({
  "duration": 8364731500,
  "status": "passed"
});
formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login",
  "description": "",
  "id": "login-action;login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User Navigate to Login page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters UserName and Password and Status is updated in excel",
  "keyword": "Then "
});
formatter.match({
  "location": "Login1_testcase.user_Navigate_to_Login_page()"
});
formatter.result({
  "duration": 1280985600,
  "status": "passed"
});
formatter.match({
  "location": "Login1_testcase.user_enters_UserName_and_Password_and_Status_is_updated_in_excel()"
});
formatter.result({
  "duration": 15218454200,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Forgot Password",
  "description": "",
  "id": "login-action;forgot-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "User is Navigated to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "User enters Email and Status is updated in to excel",
  "keyword": "Then "
});
formatter.match({
  "location": "ForgotPassword_testcase.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 4401477500,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPassword_testcase.user_is_Navigated_to_LogIn_Page()"
});
formatter.result({
  "duration": 807165700,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPassword_testcase.user_enters_Email_and_Status_is_updated_in_to_excel()"
});
formatter.result({
  "duration": 13761997300,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Logout",
  "description": "",
  "id": "login-action;logout",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@tag3"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User is loggedin",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User should be logged out",
  "keyword": "Then "
});
formatter.match({
  "location": "Logout_TestCase.user_is_loggedin()"
});
formatter.result({
  "duration": 5439705800,
  "status": "passed"
});
formatter.match({
  "location": "Logout_TestCase.user_should_be_logged_out()"
});
formatter.result({
  "duration": 3392860600,
  "status": "passed"
});
formatter.uri("Search.feature");
formatter.feature({
  "line": 1,
  "name": "Search for kickstarter website",
  "description": "",
  "id": "search-for-kickstarter-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "srch01- Do a valid search with a single keyword",
  "description": "",
  "id": "search-for-kickstarter-website;srch01--do-a-valid-search-with-a-single-keyword",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@srch01"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I do a single keyword search for (...)",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the certain filters",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on certain project",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I see the project details and store in the excel",
  "keyword": "Then "
});
formatter.match({
  "location": "Search_testcase.i_do_a_single_keyword_search_for()"
});
formatter.result({
  "duration": 3762718500,
  "status": "passed"
});
formatter.match({
  "location": "Search_testcase.i_click_on_the_certain_filters()"
});
formatter.result({
  "duration": 6834049900,
  "status": "passed"
});
formatter.match({
  "location": "Search_testcase.click_on_certain_project()"
});
formatter.result({
  "duration": 6243453800,
  "status": "passed"
});
formatter.match({
  "location": "Search_testcase.i_see_the_project_details_and_store_in_the_excel()"
});
formatter.result({
  "duration": 330929100,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "srch01- Do a valid search with a multiple keyword",
  "description": "",
  "id": "search-for-kickstarter-website;srch01--do-a-valid-search-with-a-multiple-keyword",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@srch02"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I do a multiple keyword search for (...)",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I click on certain filters",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Click on certain projects",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Project details are stored in excel",
  "keyword": "Then "
});
formatter.match({
  "location": "Search2_testcase.i_do_a_multiple_keyword_search_for()"
});
formatter.result({
  "duration": 3417459500,
  "status": "passed"
});
formatter.match({
  "location": "Search2_testcase.i_click_on_certain_filters()"
});
formatter.result({
  "duration": 6790307800,
  "status": "passed"
});
formatter.match({
  "location": "Search2_testcase.click_on_certain_projects()"
});
formatter.result({
  "duration": 6224822900,
  "status": "passed"
});
formatter.match({
  "location": "Search2_testcase.project_details_are_stored_in_excel()"
});
formatter.result({
  "duration": 306592500,
  "status": "passed"
});
formatter.uri("Signup.feature");
formatter.feature({
  "line": 1,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Title of your scenario",
  "description": "",
  "id": "title-of-your-feature;title-of-your-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@signUp"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Sign up page is open",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Do the sign up actions",
  "keyword": "Then "
});
formatter.match({
  "location": "SignUp_testcase.sign_up_page_is_open()"
});
formatter.result({
  "duration": 1913289000,
  "status": "passed"
});
formatter.match({
  "location": "SignUp_testcase.do_the_sign_up_actions()"
});
formatter.result({
  "duration": 69031719000,
  "status": "passed"
});
formatter.uri("StartProject.feature");
formatter.feature({
  "line": 2,
  "name": "Start a new Project",
  "description": "",
  "id": "start-a-new-project",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Start Project",
  "description": "",
  "id": "start-a-new-project;start-project",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "The user should be logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Start project should be navigated",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter values to necessary fields.",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I validate the outcomes",
  "keyword": "Then "
});
formatter.match({
  "location": "StartProject_TestCase.the_user_should_be_logged_in()"
});
formatter.result({
  "duration": 6247066100,
  "status": "passed"
});
formatter.match({
  "location": "StartProject_TestCase.start_project_should_be_navigated()"
});
formatter.result({
  "duration": 4208745000,
  "status": "passed"
});
formatter.match({
  "location": "StartProject_TestCase.enter_values_to_necessary_fields()"
});
formatter.result({
  "duration": 67325925100,
  "status": "passed"
});
formatter.match({
  "location": "StartProject_TestCase.i_validate_the_outcomes()"
});
formatter.result({
  "duration": 761458100,
  "status": "passed"
});
});