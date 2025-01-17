Feature: Noop

  Scenario Template: Test hello
    Given a name <username>
    When hello method is called with name
    Then A hello + name string is returned
    Examples:
      | username |
      | Jules     |
      | Charles   |
