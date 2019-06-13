Feature: Dashboard screen

  Background:
    Given That nubi wallet app is running and user is on home screen
    When User set its credential to acces nubi wallet
    Then User is on dashboard screen


  Scenario: Validate elements on dashboard screen
    Given That user is on dashboard screen
    #Then validate balance card element
    Then validate balance card title
    Then validate frequent contacts container
    Then Reset app

  Scenario: kill the app to validate session has been closed
    Given That user is on dashboard screen
    When user kill-close the app
    Then open the app
    Then validate user is on login screen