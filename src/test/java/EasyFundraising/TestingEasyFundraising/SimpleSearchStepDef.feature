#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test Easy Fundraising Find a cause feature

  Scenario: Check if user can find a cause with three character search 
    Given browser is open
    And user opened the website "https://www.easyfundraising.org.uk/"
    And user Go to the link "Find a cause" on the top of the page
    When User Enter "mac" in the Search field
    And User select the 3rd cause from the suggestion list
    And click Search Cause
    Then Confirm with a message that the selected third Cause exists in the Search results
