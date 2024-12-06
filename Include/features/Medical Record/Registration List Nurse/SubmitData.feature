#Author: your.email@your.domain.com

@tag
Feature: Registration List Nurse
  I want to use this template for my feature file
  
  Background: User is Logged In and open Medical Record page
	Given I already login as Nurse
	And I already open Medical Record page
	And I open Registration List Nurse Menu

  @SubmitData
  Scenario: Input Service Activity Detail
   Given I search registration nurse data
    When I open registration list nurse detail
    And I open nurse service activity detail
    And I click done
    And I click finish
    Then Status change to Done
    And post registration data
    
  @SubmitDataNurse
  Scenario: Input Service Activity Detail
   Given I search registration nurse data
    When I open registration list nurse detail
    And I open service activity detail - first row
    And I click done
    And I click finish
    Then Status Service change to Done
    And post registration data