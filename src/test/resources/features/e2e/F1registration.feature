Feature: Registration process

  Background:
    Given That nubi wallet app is running for endToend process
    #And Home screen has been showed


    Scenario: Complete full registration process
      When Email screen is completed
     And Personal information screen is completed
     And Create user screen is completed
      And Phone number screen is completed
     And Terms and conditions screen is completed
#      Then User sees the welcome screen with its name e2e. this is failing at tihis moment 31-05-2019