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
@tag
Feature: Google Homepage Search

  @search
  Scenario Outline: User can search with "Google Search"
    Given I am on the homepage
    When I type "<searchText>" into the search field
    And I click the Google Search button
    Then I go to the search results page
    And the first result is "<expectedResult>"
    When I click on the first result link
    Then I go to the "<pageName>" page

    Examples: 
      | searchText  | expectedResult | pageName	|
      | The name of the wind |     The Name of the Wind - Patrick Rothfuss |	Patrick Rothfuss - The Books |
      | The name of the wind	|	The Name of the Wind - Wikipedia |	The Name of the Wind - Wikipedia |
      |	The name wind	|	The Name of the Wind - Wikipedia | The Name of the Wind - Wikipedia |
      |	The name of the wind by Patrick Rothfuss	|	The Name of the Wind by Patrick Rothfuss - Goodreads | The Name of the Wind by Patrick Rothfuss |
      |	The wind	|	The Name of the Wind - Wikipedia | The Name of the Wind - Wikipedia |
      |	The nome of the wind by Patryck Rothfous	|	The Name of the Wind by Patrick Rothfuss - Goodreads | The Name of the Wind by Patrick Rothfuss |
   
   @searchAutocomplete
   Scenario Outline: User can search by using the suggestion
   Given I am on the homepage
    When I type "<searchText>" into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search results page
    And the first result is "<expectedResult>"
    When I click on the first result link
    Then I go to the "<pageName>" page
    
    Examples: 
      | searchText  | expectedResult | pageName	|
      | The name of the w |     The Name of the Wind - Patrick Rothfuss |	Patrick Rothfuss - The Books |
      | The name of the w	|	The Name of the Wind - Wikipedia |	The Name of the Wind - Wikipedia |
      |	The name of the wind by Patrick	|	The Name of the Wind by Patrick Rothfuss - Goodreads | The Name of the Wind by Patrick Rothfuss |
      |	The nome of the wind by Patryck	|	The Name of the Wind by Patrick Rothfuss - Goodreads | The Name of the Wind by Patrick Rothfuss |
      | The name of the will	|	The Name of the Wind - Wikipedia |	The Name of the Wind - Wikipedia |
