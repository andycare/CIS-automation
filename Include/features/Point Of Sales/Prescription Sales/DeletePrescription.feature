#Author: your.email@your.domain.com
@PrescriptionSales
Feature: Prescription Sales
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page

  @DeletePrescription
  Scenario: Add new Prescription Standard
    Given I am open prescription sales page
    And I search pharmacy registration data
    When I open prescription sales detail
    And I verify pharmacy registration data
    And I select prescription data - manual
    And I click delete prescription
    And I click yes
    Then Prescription Sales data successfully deleted