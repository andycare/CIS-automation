@DirectSalesExistingPatient1
Feature: Direct Sales Existing Patient no delivery
  I want to use this template for my feature file
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page

  @directsales1
  Scenario: Existing patient - new membership - no delivery
    Given I am open direct sales page
    And I search patient data
    When I open direct sales detail page
    And I input sales info data1
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I click next
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment data is correct
    
    @directsales2
    Scenario: Existing patient(have membership) - no delivery
    Given I am open direct sales page
    And I search patient data
    When I open direct sales detail page
    And I input sales info data2
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I click next
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment data is correct