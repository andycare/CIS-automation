#Author: your.email@your.domain.com

@RegistrationList
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	#Given I already logout
	Given I already login as Doctor
	And I already open Medical Record page

  @DoctorConsultation
  Scenario: Process Doctor Consultation
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I open service activity detail
    And I input service activity information
    Then Service activity success inputed
    
  @DoctorTreatment
  Scenario: Process Doctor Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I open service activity detail
    And I input service activity information
    Then Service activity success inputed