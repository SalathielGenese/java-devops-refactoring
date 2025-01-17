Feature: Noop

  Scenario Template: Test hello
    Given a name "<name>"
    When hello method is called with name
    Then A hello + name string is returned
    Examples:
      | name    |
      | Jules   |
      | Charles |
      | Renee   |
