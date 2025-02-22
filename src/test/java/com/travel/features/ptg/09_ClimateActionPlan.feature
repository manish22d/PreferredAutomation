@Preferred @ClimateActionPlan
Feature: As a user i want to test press center option in submenu

  @ClimateActionPlan
  Scenario: verify Climate Action Plan page
    Given user launch's preferred travel application
    When user want to navigate to "Climate Action Plan" option in sub menu
    Then verify current page is "/related-file/PTG_ClimateActionPlan.pdf"
