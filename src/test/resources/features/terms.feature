@login
Feature: Login Feature
  I want to use this template for my feature file

  Scenario: Validate the UserName and Password
    Given I have a prescription Application
    When I enter the correct UserName and Password
    Then I should be able to see the HomePage

  # Given I enter an invalid userName and Password
   # When i initiate the tool
  #  Then I should be able to guide the tool

   ## Given i have a valid useraccount 
   ## When i enter the righ userName and external id 
    #Then i should be able to receive the response with a valid valid status code. 
    
  