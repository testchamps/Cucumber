Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  
    @testEntityKey=SAM-TC-1
    Scenario: Add two numbers
    Given I have a calculator 123
    When I add 21 and 31
    Then the result should be 52