@tag
Feature: Mengubah format tanggal


  @tag1
  Scenario: Change the date format
    Given I am on finansys website
    And I login using my "<Username>" and "<password>"
    And I click login button
    And I choose App Editor
    And  I click my display name to my profile
    And click Setting
    And I change Display format
    And I click ok
    Then Success edit format
    
    
    Examples: 
      |Username|password			| status  |
      | system |P@ssw0rd123# 	| success |