#Author: your.email@your.domain.com

@tag
Feature: Title of your feature
  I want to use this template for my feature file
  
  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page

  @tag1
  Scenario: Regular Treatment appointment
    Given I open appointment page
    When I click add appointment
    And I search patient data
    And I open appointment detail
    And I input appointment info
    And I click next
    And I verify appointment info data
    And I click post appointment
    Then appointment created