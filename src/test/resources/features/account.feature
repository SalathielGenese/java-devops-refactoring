Feature: Account Operations
  As a bank client, I have a access to my account.
  From which I can:
  - save money
  - retrieve some or all of my savings

  Scenario Template: Save money
    Given an initial balance of <initialAmount>
    When doing a deposit of <deposit>
    Then my new balance is <newBalance>
    Examples:
      | initialAmount | deposit | newBalance |
      | 0             | 10      | 10         |
      | 4             | 9       | 13         |

  Scenario Template: Retrieve some or all of my savings
    Given an initial balance of <initialAmount>
    When make a withdrawal of <withdrawal>
    Then my new balance is <newBalance>
    Examples:
      | initialAmount | withdrawal | newBalance |
      | 10            | 7          | 3          |
      | 1             | 2          | -1         |
