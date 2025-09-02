Feature: Division in calculator

  Scenario: Division by zero
    Given a calculator
    When the user enters 5 and 0 and presses "/"
    Then the displayed result is "Error: No se puede dividir por cero."

  Scenario: Division with negative number
    Given a calculator
    When the user enters -10 and 2 and presses "/"
    Then the displayed result is "-5.00"

  Scenario: Division with negative divisor
    Given a calculator
    When the user enters 7 and -2 and presses "/"
    Then the displayed result is "-3.50"
