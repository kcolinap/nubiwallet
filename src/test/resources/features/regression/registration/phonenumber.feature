Feature: phone number validation feature

  Scenario: complete previous screen
    Given That nubi wallet app is running and user is on home screen
    And User is on email screen
    And User complete email screen
    And Personal information screen is completed


  Scenario Outline: complete screen with invalid information
    Given User is on user information screen
    When user set his user as "<user>"
    And set his password as "<pass>"
    Then Validate status circle button as "<condition>"
    Then Validate if legend is present as "<legend>" on screen "userInf"
    Examples:
      |   user    |    pass    |   condition |   legend  |
      |           |  111Cc-11  |     f       |    f      |
      | usertest  |            |     f       |    f      |
      |   use     |  111Cc-11  |     f       |    t      |
      |  user#$   |  111Cc-11  |     f       |    t      |
      | usertest  |  Cc-(kLha  |     f       |    f      |
      | usertest  |   Cc11-(   |     f       |    f      |
      | usertest  |  c1-(klha  |     f       |    f      |
      | usertest  |  c1Nfklha  |     f       |    f      |


  Scenario Outline: complete screen with valid information
    Given User is on user information screen
    When user set his user as "<user>"
    And set his password as "<pass>"
    Then Validate status circle button as "<condition>"
    Then Validate if legend is present as "<legend>" on screen "userInf"
    Examples:
      |   user    |    pass    |   condition |   legend  |
      | usertest  |  111Cc-11  |     t       |    f      |


  Scenario: Validate an already registered user
    Given User is on user information screen
    When User set an already registered user
    And set his password as "111Cc-11"
    And tap button circle on screen "user"
    Then validate input error message is already on bd as "  El nombre de usuario no está disponible"

  Scenario: reset app
    Then Reset app