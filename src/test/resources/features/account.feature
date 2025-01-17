Feature: Account Operations
  As a bank client, I have a access to my account.
  From which I can:
  - save money
  - retrieve some or all of my savings

  Scenario: Initialize account with strictly negative amount
    Given a balance of -1
    Then fail negative initialization

  Scenario: Initialize account with null
    Given a balance of null
    Then fail null initialization

  Scenario Template: Withdraw money
    Given an initial balance of <initial>
    When making a withdrawal of <amount>
    Then balance is <balance>
    Examples:
      | initial | amount | balance |
      | 10      | 10     | 0       |
      | 15      | 3      | 12      |
      | 100     | 2      | 98      |

  Scenario Template: Save money
    Given an initial balance of <initial>
    When making a deposit of <amount>
    Then balance is <balance>
    Examples:
      | initial | amount | balance |
      | 0       | 10     | 10      |
      | 15      | 3      | 18      |
      | 100     | 2      | 102     |

  Scenario Template: Validate withdrawal
    Given an initial balance of 10
    When making a withdrawal of <amount>
    Then fail with <message>
    Examples:
      | amount | message                |
      | 15     | "insufficient balance" |
      | -1     | "negative amount"      |

  Scenario Template: Validate deposit
    Given an initial balance of 10
    When making a deposit of <amount>
    Then fail with <message>
    Examples:
      | amount | message           |
      | -15    | "negative amount" |
      | -1     | "negative amount" |
