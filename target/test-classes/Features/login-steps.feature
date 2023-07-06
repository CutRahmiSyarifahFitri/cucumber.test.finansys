
Feature: Fungsi Login
  @tag1
  Scenario: Successful Login
    Given browser open chrome browser
    When I type valid username and password
    And I click submit
    Then it direct to home page


  @tag2

	Scenario: Unsuccessful Login
	When User enters either wrong Email or Password  
	Then It should be reverse back on the login page with an error message

    Examples: 
      |Username|password			| status  |
      | system |P@ssw0rd123# 	| success |
			| system |P@ssw0rd12# 	| fail		|