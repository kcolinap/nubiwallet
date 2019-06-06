@regexLogin
Feature: Login process

  Background:
    Given That nubi wallet app is running and user is on home screen
    #And Home screen has been showed


  Scenario Outline: Login screen test with invalid values
    When User set his credentials as "<user>" and "<password>"
    Then Validate condition on init session button as "<condition>"
    Then Validate if legend is present as "<legend>"
    Then Reset app
    Examples:
      |             user      |       password    |   condition   |   legend  |
      |                       |     111Cc-c11     |     false     |     f     |
      |           userdt31    |                   |     false     |    f      |
      |           userdt31    |      Eder-876     |      true     |     t     |
      |           userdt30    |      111Cc-11     |      true     |    t      |
      |demotest31@yopmail.com |                   |      false    |    f      |
      |demotest31@yopmail.com |     122Cc-c11     |      true     |    t      |


#    When User set its credential to acces nubi wallet
#    Then User sees dashboard screen
#      Then User sees the welcome screen with its name e2e. this is failing at tihis moment 31-05-2019