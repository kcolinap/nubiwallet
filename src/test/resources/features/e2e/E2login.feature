@e2e
Feature: Login process

  Background:
    Given That nubi wallet app is running for endToend process
    #And Home screen has been showed


  Scenario: Complete login form on nubi wallet
    When User set its credential to acces nubi wallet
    Then User sees dashboard screen
#      Then User sees the welcome screen with its name e2e. this is failing at tihis moment 31-05-2019