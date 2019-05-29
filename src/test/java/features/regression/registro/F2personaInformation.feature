Feature: Personal information screen test

  Background:
    Given That nubi wallet app is running
    Given Email screen is completed with a valid email and condition next button as "true"
    Then validate personal information screen was showed



  #Scenario: complete email screen to get personal information screen
    #Given That nubi wallet app is running


#  @SmokeTest
#  Scenario Outline: validate personal information fields
#  #  Given That nubi wallet app is running
#    And User is on personal information screen
#    When User sets names as "<names>", lastnames as "<lastNames>", dni as "<dni>" and genre as "<genre>"
#    Then Validate circle next button codition as "<condition>"
#    Examples:
#    #colocar p como parametro del dni para generar uno random
#    |   names   |   lastNames   |   dni  | genre |    condition   |
#    |           |   Gonzalez    |    p   |   h   |      false     |
#    |     Ana   |               |   p    |   m   |      false     |
#    |   Lucia   |   Torres      |        |   m   |      false     |
#    #|   Carlos  |     Sosa      |   p    |       |      false     |
#    |     67    |               |        |       |      false     |
#    |     %&#   |               |        |       |      false     |
#    |           |     %&#       |        |       |      false     |
#    |           |      34       |        |       |      false     |
#
#

#
#  Scenario Outline: Complete form with valid information with letter ñ on both name and lastnames input
#    And User is on personal information screen
#    When User sets names as "<names>", lastnames as "<lastNames>", dni as "<dni>" and genre as "<genre>"
#    Then Validate circle next button codition as "<condition>"
#    #When Click on circle next button
#   # Then validate cuil screen was showed
#    #Then Close app
#    Examples:
#    #colocar p como parametro del dni para generar uno random
#      |   names   |   lastNames   |   dni  | genre |    condition   |
#      |   Kariña  |      Peña     |    p   |   h   |      true     |
#      #|     Ana   |     Peña      |    p   |   m   |      true     |

#  Scenario Outline: Complete form with valid information and go to CUIL screen
#    Given User is on personal information screen
#    When User sets names as "<names>", lastnames as "<lastNames>", dni as "<dni>" and genre as "<genre>"
#    Then Validate circle next button codition as "<condition>"
#    Then Click on circle next button
#    Then validate cuil screen was showed
#    Then Close app
#    Examples:
#    #colocar p como parametro del dni para generar uno random
#      |   names   |   lastNames   |   dni  | genre |    condition   |
#      |    Ana    |   Gonzalez    |    p   |   h   |      true     |
#
#  Scenario Outline: Complete form with valid information and Cuil to get create user screen
#    Given User is on personal information screen
#    When User sets names as "<names>", lastnames as "<lastNames>", dni as "<dni>" and genre as "<genre>"
#    Then Validate circle next button codition as "<condition>"
#    Then Click on circle next button
#    Then validate cuil screen was showed
#    Then Validate circle next button codition as "<condition>"
#    Then Click on circle next button
#    Then Validate that create user screen was showed
#    Then Close app
#    Examples:
#    #colocar p como parametro del dni para generar uno random
#      |   names   |   lastNames   |   dni  | genre |    condition   |
#      |  Carlos   |    Ramires    |    p   |   h   |      true     |

    #Scenario Outline: Validate cuil screen