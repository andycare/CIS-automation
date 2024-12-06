#Author: your.email@your.domain.com

@RegistrationListNurse
Feature: Registration List Nurse
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Nurse
	And I already open Medical Record page
	And I open Registration List Nurse Menu

  @ServiceActivityDetailLogBook
  Scenario: Input Service Activity Detail - Treatment Log Book
    Given I search registration nurse data
    When I open registration list nurse detail
    And I open nurse service activity detail
    And I input nurse service activity - Treatment Log Book
    Then Success input nurse service activity detail
    
  @ServiceActivityDetailItemUsed
  Scenario: Input Service Activity Detail - Item Used
    Given I search registration nurse data
    When I open registration list nurse detail
    And I open nurse service activity detail
    And I input nurse service activity - Item Used
    Then Success input nurse service activity detail
    
  @ServiceActivityDetailDocument
  Scenario: Input Service Activity Detail - Foto dan Dokumen
    Given I search registration nurse data
    When I open registration list nurse detail
    And I open nurse service activity detail
    And I input nurse service activity - Foto & Document
    Then Success input nurse service activity detail