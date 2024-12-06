#Author: your.email@your.domain.com

@tag
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu

  @ServiceActivityDetailReferral2
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Referral
    Then Success input service activity detail
    
  @ServiceActivityDetailDocument2
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Photo & Document
    Then Success input service activity detail
    
  @ServiceActivityDetailLogBook
  Scenario: Input Service Activity Detail - Treatment Log Book
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Treatment Log Book
    Then Success input service activity detail