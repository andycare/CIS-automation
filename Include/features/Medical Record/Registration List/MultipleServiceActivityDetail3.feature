#Author: your.email@your.domain.com

@RegistrationListDetail
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu
  
  @MultipleServiceActivityDetailConsultation
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - second row
    And I input service activity detail - diagnosis
    And I input service activity - Foto & Document
    And I input service activity - Prescription Standard
    And I input service activity - Referal
    Then Success input service activity detail
    
  @MultipleServiceActivityDetailTreatment
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - second row
    And I input service activity detail - diagnosis
    And I input service activity - Photo & Document
    And I input service activity - Prescription Standard
    And I input service activity - Referral
    Then Success input service activity detail
    
  @MultipleServiceActivityDetailTreatment2
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - third row
    And I input service activity detail - diagnosis
    #And I input service activity - Photo & Document
    And I input service activity - Prescription Standard
    And I input service activity - Referral
    Then Success input service activity detail