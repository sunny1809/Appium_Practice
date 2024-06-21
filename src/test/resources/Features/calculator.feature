@calculator
Feature: Test Calculator app using Appium

  @calculation
  Scenario: Execute few calculations
    #	Addition: plus, Substraction: minus, Multiplication: multiply, Division: divide
    # Keep last cell as NA
    Given Perform methods with numbers
      | Numbers | Methods  |
      |       1 | plus     |
      |      10 | multiply |
      |      30 | minus    |
      |       1 | NA       |
    Then Verify the result "300"
