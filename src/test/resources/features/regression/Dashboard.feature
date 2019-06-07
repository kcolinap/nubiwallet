Feature: Dashboard screen

  Background:
    Given That nubi wallet app is running and user is on home screen
    When User set its credential to acces nubi wallet
    Then User sees dashboard screen


  Scenario: Validate elements on dashboard screen
    Given That user is on dashboard screen
    Then validate balance card element
    Then validate balance card title as "Mi Saldo"
    Then validate frequent contacts container
    Then Reset app