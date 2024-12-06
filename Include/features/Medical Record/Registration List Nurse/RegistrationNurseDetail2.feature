#Author: your.email@your.domain.com

@RegistrationListNurse
Feature: Registration List Nurse
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Nurse
	And I already open Medical Record page
	And I open Registration List Nurse Menu

  @ServiceActivityDetailNurse
  Scenario: Input Service Activity Detail - Treatment Log Book
    Given I search registration nurse data
    When I open registration list nurse detail
    And I open service activity detail - first row
    And I input nurse service activity - Treatment Log Book
    And I input nurse service activity - Item Used
    #And I input nurse service activity - Foto & Document
    Then Success input nurse service activity detail