Feature: FizzBuzz Game
  Scenario: Let's Play to get Fizz
    Given create a FizzBuzz game
    When I play with number 3
    Then The result is "Fizz"

  Scenario: Let's Play to get Buzz
    Given create a FizzBuzz game
    When I play with number 5
    Then The result is "Buzz"

  Scenario: Let's Play to get FizzBuzz
    Given create a FizzBuzz game
    When I play with number 15
    Then The result is "FizzBuzz"

  Scenario: Let's Play to get Buzz
    Given create a FizzBuzz game
    When I play with number 501
    Then The result is "Buzz"