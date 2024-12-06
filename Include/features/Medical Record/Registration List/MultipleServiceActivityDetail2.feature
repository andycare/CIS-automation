#Author: your.email@your.domain.com

@RegistrationList
Feature: Registration List
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Doctor
	And I already open Medical Record page
	And I open Registration List Menu
	
	@MultipleServiceActivityDetailReferral
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - first row
    And I input service activity - Referal
    And I back to registration list detail
    And I open service activity detail - second row
    And I input service activity - Referral
    Then Success input service activity detail
    
  @FinishConsultationData
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - second row
    And I click done
    And I click finish
    Then Success finish data
    
  @FinishTreatmentData
  Scenario: Input Service Activity Detail
    Given I search registration data
    When I open registration list detail
    And I open service activity detail - third row
    And I click done
    And I click finish
    Then Success finish data
	
	