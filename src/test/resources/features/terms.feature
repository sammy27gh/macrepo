@login
Feature: Login Feature
  I want to use this template for my feature file

  Scenario: Validate the UserName and Password
    Given I have a prescription Application
    When I enter the correct UserName and Password
    Then I should be able to see the HomePage
