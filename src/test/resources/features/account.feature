Feature: Account Operations
  As a bank client, I have a access to my account.
  From which I can:
  - save money
  - retrieve some or all of my savings

  Scenario: Save money
    Given an amount 10
    When doing a deposit
    Then my balance is increased by 10

  Scenario: Retrieve some or all of my savings
    Given an amount 7
    When make a withdrawal
    Then my balance is decreased by 7
