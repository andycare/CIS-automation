#Author: your.email@your.domain.com
@Registration
Feature: Registration Feature
  I want to use this template for my feature file
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	When I already open FO page

  @Consultation-RegularTreatment-Treatment
  Scenario: Consultation - Regular Treatment - Treatment Registration
    Given I open registration page
    When I click add registration
    And I search patient on registration
    And I open registration detail
    And I input registration info4
    And I click next
    And I input registration info detail Consul
    And I click save registration detail
    And I input registration info detail RT
    And I click save registration detail 
    And I scroll to button add
    And I input registration info detail Treatment
    And I click save registration detail
    And I verify registration info data created
    And I click next
    And I close pop up screening
    And I click next
    And I verify registration info data7
    And I click post registration
    And I click Yes on pop up confirmation
    Then registration data created
    And I click back
    
  @Pharmacy
  Scenario: Pharmacy Only Registration
    Given I open registration page
    When I click add registration
    And I search patient data pharmacy
    And I open registration detail - pharmacy
    And I input registration info5
    And I click next
    And I input registration info detail-Pharmacy
    And I click save registration detail
    And I verify registration info data created
    And I click next
    And I verify registration info data8
    And I click post registration
    Then registration data created
    And I click back