Feature: Registration procces end to end

  Background:
    Given That nubi wallet app is running for E2E proccess
    #And Home screen has been showed


    Scenario: Complete full registration process
      When Email screen is completed e2e
      And Personal information screen is completed e2e
      And Create user screen is completed e2e
      And Phone number screen is completed e2e
      And Terms and conditions screen is completed e2e
      Then User sees the welcome screen with its name e2e