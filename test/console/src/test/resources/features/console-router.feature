Feature: As an account owner, I navigate the console app with standard input.
  """
  The application start with the menu command.
  Then visit it, which eventually result in a new command (eg.: Menu -> PrintStatement)
  Or none (eg.: PrintStatement -> null) which let the router decide next step.
  And unless the next command is Quit, repeat the visitation.

  The menu is as follow:
  1. Print Statement
  2. Make Withdrawal
  3. Make Deposit
  0. Quit
  """

  Background:
    Given my new account

  Scenario: Deposit invalid amount
    Given a console router with my account executed with input:
    """
    3
    -20
    0
    """
    Then the balance is 0

  Scenario: Withdraw negative amount
    Given a console router with my account executed with input:
    """
    2
    -20
    0
    """
    Then the balance is 0

  Scenario: Withdraw more than balance
    Given a console router with my account executed with input:
    """
    3
    100
    2
    150
    0
    """
    Then the balance is 100

  Scenario: Track statement in order
    Given a console router with my account executed with input:
    """
    3
    100
    2
    50
    3
    25
    2
    37
    0
    """
    Then the balance is 38
