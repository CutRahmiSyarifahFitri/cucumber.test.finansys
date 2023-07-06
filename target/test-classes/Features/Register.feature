
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I am on the app
    And i register as new user
    When I fill all the instruction
    And I click submit
    Then my account is active
    

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I am on the app
    And i register with email already in use
    Then I get error notification

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
