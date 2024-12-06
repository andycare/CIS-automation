#Author: your.email@your.domain.com

@RegistrationListNurse
Feature: Registration List Nurse
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Nurse
	And I already open Medical Record page

  @NurseRegularTreatment
  Scenario: Process Regular Treatment
    Given I open Registration List Nurse Menu
    And I search registration nurse data
    When I open registration list nurse detail
    And I verify registration nurse data
    And I open nurse service activity detail
    And I input nurse service activity information
    Then Service activity nurse success inputed
    
  @NurseConsultationRegularTreatment
  Scenario: Process Regular Treatment
    Given I open Registration List Nurse Menu
    And I search registration nurse data
    When I open registration list nurse detail
    And I verify registration nurse data
    And I open service activity detail - first row
    And I input nurse service activity information
    Then Service activity nurse success inputed
    
  @NurseTreatmentRegularTreatment
  Scenario: Process Regular Treatment
    Given I open Registration List Nurse Menu
    And I search registration nurse data
    When I open registration list nurse detail
    And I verify registration nurse data
    And I open service activity detail - first row
    And I input nurse service activity information
    Then Service activity nurse success inputed