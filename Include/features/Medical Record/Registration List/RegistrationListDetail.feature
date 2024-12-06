#Author: your.email@your.domain.com

@RegistrationListDetail
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu
  
  @ServiceActivityDetailDiagnosis
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity detail - diagnosis
    Then Success input service activity detail
    
  @ServiceActivityDetailDocument
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Foto & Document
    Then Success input service activity detail
    
  @ServiceActivityDetailPrescriptionStandard
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Prescription Standard
   	Then Success input service activity detail
    
  @ServiceActivityDetailReferral
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    And I input service activity - Referal
    Then Success input service activity detail
    
  @ServiceActivityDetailMedicalPlan
  Scenario: Input Service Activity Detail
    #Given Doctor already input service activity information
    Given I search registration data
    When I open registration list detail
    And I open service activity detail
    #And I input service activity detail - Medical Plan
   	Then Success input service activity detail