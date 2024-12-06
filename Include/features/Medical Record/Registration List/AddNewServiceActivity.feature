#Author: your.email@your.domain.com

@RegistrationList
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	#Given I already logout
	Given I already login as Doctor
	And I already open Medical Record page

  @AddNewServiceActivityTreatment
  Scenario: Add Service Activity - Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I click add service activity
    And I input new activity treatment
    Then New service activity has been created
    
  @AddNewServiceActivityConsultation
  Scenario: Add Service Activity - Consultation
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I click add service activity
    And I input new activity consultation
    Then New service activity has been created
    
  @AddNewServiceActivityRegularTreatment
  Scenario: Add Service Activity - Regular Treatment
    Given I open Registration List Menu
    And I search registration data
    When I open registration list detail
    And I verify registration data
    And I click add service activity
    And I input new activity regular treatment
    Then New service activity has been created
    
  