Feature: Login Action
 
 @tag1
Scenario: Login
 When User Navigate to Login page
 Then User enters UserName and Password and Status is updated in excel
 
 @tag2 
Scenario: Forgot Password
 Given User is on Home Page
 When User is Navigated to LogIn Page
 Then User enters Email and Status is updated in to excel
 
 
 @tag3
Scenario: Logout
 When User is loggedin
 Then User should be logged out
 
 