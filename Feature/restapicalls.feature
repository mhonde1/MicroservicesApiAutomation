#Author: mhonde@restorationhardware.com
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
@api
Feature: GET and POST API Calls
@apilookup
 Scenario Outline: : API Customer Lookup
    Given get call base url as "<url>"
    When I search for person "<name>"
    Then I get response as "<responsecode>"
	Examples:
		|url| name | responsecode|
		|https://www.google.com | Meera | 200 |
  
 # Scenario: Usershould be able to make POST call
  #  When User sends correct request body with given details 
   # Then User should get expected response as "<ResponseCode>"

