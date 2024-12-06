#Author: your.email@your.domain.com

@tag
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu

  @SubmitData
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I click done
    And I click finish
    Then Status change to Done
    And post registration data
    
  @ServiceActivityDetailItemUsed
  Scenario: Input Service Activity Detail - Item Used
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Item Used
    Then Success input service activity detail
    
  @SubmitDataMultipleService
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - first row
    And I click done
    And I click finish
    And I open service activity detail - second row
    And I click done
    And I click finish
    Then Status Service change to Done
    And post registration data