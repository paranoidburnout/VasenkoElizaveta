Feature: UI elements functionality on Different Elements Page

  Scenario: Check, that page elements on the service page was functioned
    Given Page opened
    Then Page title is 'Home Page' was displayed
    When User logged with 'Roman' login and 'Jdi1234' password
    Then  User name is 'ROMAN IOVLEV' was displayed
    When User opened through the header menu Service -> Different Elements Page
    And Checkbox 'Water' elements have been selected
    And Checkbox 'Wind' elements have been selected
    And Radio 'Selen' element has been selected
    And In dropdown 'Yellow' element has been selected
    Then 'Water: condition changed to true' log row for water was displayed
    And 'Wind: condition changed to true' log row for wind was displayed
    And 'metal: value changed to  Selen' log row for selen was displayed
    And 'Colors: value changed to Yellow' log row for yellow color was displayed