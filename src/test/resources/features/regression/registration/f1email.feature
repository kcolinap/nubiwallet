Feature: Email screen regression test.

  Background:
    Given That nubi wallet app is running and user is on email screen
   # And User is on email screen

  Scenario Outline: Email screen test with invalid values
    When User set an email as "<email>"
    Then Validate condition on next button as "<condition>"
    Then Validate if legend is present as "<legend>"
    Examples:
    |      email      |   condition   |   legend  |
    | testdominio.com |     false     |     f     |
    | test@dominio    |     false     |     f     |
    | test@dominiocom |     false     |     f     |
    |                 |     false     |     f     |
    | test#*@test.com |     false     |     t     |


  Scenario: Email screen test with email more tha 255characteres
    When User set an email with more than permit characteres
    Then Validate condition on next button as "false"
    Then Validate if legend is present as "t"

  Scenario: Email screen test with a valid email
    #Given That nubi wallet app is running
    When User set a valid email
    Then Validate condition on next button as "true"
    And Click on next button
    Then Validate elements on next screen

  Scenario: Back to set email screen
   # Given That nubi wallet app is running
    When User set a valid email
    And Click on next button
    And Click on back button
    Then Validate that previous setted email is show
    Then Validate condition on next button as "true"

  Scenario: edit the previous email from back button
   # Given That nubi wallet app is running
    When User set a valid email
    And Click on next button
    And Click on back button
    When User set a new valid email
    Then Validate condition on next button as "true"
    And Click on next button
    Then Validate that newest setted email is show

  Scenario: edit the previous email from update button
   # Given That nubi wallet app is running
    When User set a valid email
    And Click on next button
    And Click on update button
    When User set a new valid email
    Then Validate condition on next button as "true"
    And Click on next button
    Then Validate that newest setted email is show
#
#  Scenario: open  and confirm email test
#    #Given That nubi wallet app is running
#    When User set a valid email
#    Then Validate condition on next button as "true"
#    And Click on next button
#    Then Open email from confirm mail button
#    When User confirm email
#    Then validate personal information screen was showed

#  Scenario: confirm email
#    #Given That nubi wallet app is running
#    When User set a valid email
#    Then Validate condition on next button as "true"
#    And Click on next button
#    Then Open email from confirm mail button
#    When User confirm email
#    Then validate personal information screen was showed
#    Then Close app