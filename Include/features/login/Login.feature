#Author: your.email@your.domain.com

@tag
Feature: Login Feature
  I want to use this template for my feature file

  @loginAdmin
  Scenario: Login as Admin
    Given I am on login page
    When I input admin userid
    And I input correct password
    And I click login
    Then I can login into dashboard
    
  @loginFO
  Scenario: Login as FO
    Given I am on login page
    When I input FO userid
    And I input correct FO password
    And I click login
    Then I can login into dashboard
    
   @loginDoctor
  Scenario: Login as Doctor
    Given I am on login page
    When I input doctor userid
    And I input correct password
    And I click login
    Then I can login into dashboard
    
    @loginNurse
  Scenario: Login as Nurse
    Given I am on login page
    When I input nurse userid
    And I input correct password
    And I click login
    Then I can login into dashboard
    
     @loginPharmacy
  Scenario: Login as Pharmacy
    Given I am on login page
    When I input pharmacy userid
    And I input correct password
    And I click login
    Then I can login into dashboard
   
    