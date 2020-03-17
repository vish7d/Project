@tag
Feature: Start a new Project

  @tag1
  Scenario: Start Project
    Given The user should be logged in
    And Start project should be navigated
    When Enter values to necessary fields.
    Then I validate the outcomes