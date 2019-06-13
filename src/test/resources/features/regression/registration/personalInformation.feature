Feature: personal information validation feature

  Scenario: complete previous screen
    Given That nubi wallet app is running and user is on home screen
    And User is on email screen
    Then User complete email screen


  Scenario Outline: complete screen with invalid information
    Given User is on personal information screen
    When user set his name as "<name>"
    And set his last name as "<lname>"
    And set his dni as "<dni>"
    And tap his gender as "<gender>"
    Then Validate status circle button as "<condition>"
    Then Validate if legend is present as "<legend>" on screen "personalInf"
    Examples:
    |   name    |   lname   |     dni     |  gender  |   condition   |   legend  |
    |    Ana    |  Garcia   |   96872123  |          |       f       |    f      |
    |           |   Garcia  |   96872123  |    m     |       f       |    f      |
    |    Ana    |           |   96872123  |    f     |       f       |    f      |
    |    Ana    |  Garcia   |             |    f     |       f       |    f      |
    |    Ana    |  Garcia   |   999999    |    f     |       f       |    t      |
    |     55    |  Garcia   |  96872123   |    f     |       f       |    t      |
    |     %$    |  Garcia   |  96872123   |    f     |       f       |    t      |
    |    Ana    |    82     |  96872123   |    f     |       f       |    t      |
    |    Ana    |    #$     |  96872123   |    f     |       f       |    t      |
#    | especialChar |    Garcia    |   96872123  |    m     |       t       |    f      |
#    |    Julia     | especialChar |   96872123  |    f     |       t       |    f      |

  Scenario: reset app
    Then Reset app
