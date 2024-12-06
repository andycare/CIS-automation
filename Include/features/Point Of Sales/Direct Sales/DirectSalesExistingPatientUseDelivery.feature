#Author: your.email@your.domain.com

@DirectSalesExistingPatient2
Feature: Direct Sales Existing Patient Use Delivery
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page

  @ReceiverPatientItSelf
    Scenario: Existing patient(have membership) - use delivery(receiver patient itself)
    Given I am open direct sales page
    And I search patient data
    When I open direct sales detail page
    And I input sales info data2
    And I input delivery info
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I click next proses
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment & delivery data is correct
    
    @ReceiverOtherPerson
    Scenario: Existing patient(have membership) - use delivery(receiver other person)
    Given I am open direct sales page
    And I search patient data
    When I open direct sales detail page
    And I input sales info data2
    And I input new delivery info
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I click next proses
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment & delivery data is correct