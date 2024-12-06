#Author: your.email@your.domain.com

@tag
Feature: Login Feature
  I want to use this template for my feature file

  @loginDoctor
  Scenario: Login as Doctor
    Given I am stay on login page
    When I input doctor userid
    And I input correct password
    And I click login
    Then I can login into dashboard