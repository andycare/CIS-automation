#Author: your.email@your.domain.com

@RegistrationList
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	#Given I already logout
	Given I already login as Doctor
	And I already open Medical Record page

  @DoctorConsultationTreatment
  Scenario: Process Doctor Consultation - Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I open service activity detail - first row
    And I input service activity information
    And I back to registration list detail
    And I open service activity detail - second row
    And I input service activity information 
    Then Service activity success inputed
    
  @DoctorConsultationRegularTreatment
  Scenario: Process Doctor Consultation - Regular Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I open service activity detail - second row
    And I input service activity information
    Then Service activity success inputed
    
  @DoctorTreatmentRegularTreatment
  Scenario: Process Doctor Treatment - Regular Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I open service activity detail - third row
    And I input service activity information
    Then Service activity success inputed