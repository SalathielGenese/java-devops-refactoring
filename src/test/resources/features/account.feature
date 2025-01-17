Feature: Account Operations
  As a bank client, I have a access to my account.
  From which I can:
  - save money
  - retrieve some or all of my savings

  Scenario: Save money
    Given an initial balance of 0
    When doing a deposit of 10
    Then my new balance is 10

  Scenario: Retrieve some or all of my savings
    Given an initial balance of 10
    When make a withdrawal of 7
    Then my new balance is 3
