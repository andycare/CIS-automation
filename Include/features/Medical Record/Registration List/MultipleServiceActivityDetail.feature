#Author: your.email@your.domain.com

@RegistrationListDetail
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu
  
  @MultipleServiceActivityDetailDiagnosis
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - first row
    And I input service activity detail - diagnosis
    And I back to registration list detail
    And I open service activity detail - second row
    And I input service activity detail - diagnosis
    Then Success input service activity detail
    
  @MultipleServiceActivityDetailDocument
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - first row
    And I input service activity - Foto & Document
    And I back to registration list detail
    And I open service activity detail - second row
    #And I input service activity - Photo & Document
    Then Success input service activity detail
    
  @MultipleServiceActivityDetailPrescriptionStandard
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - first row
    And I input service activity - Prescription Standard
    And I back to registration list detail
    And I open service activity detail - second row
    And I input service activity - Prescription Standard
   	Then Success input service activity detail