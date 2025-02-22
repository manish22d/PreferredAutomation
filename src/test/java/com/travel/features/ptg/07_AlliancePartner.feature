@Preferred @AlliancePartner
Feature: As a user i want to test press center option in submenu

  @AlliancePartner
  Scenario: verify Alliance Partner page
    Given user launch's preferred travel application
    When user want to navigate to "Alliance Partner" option in sub menu
    Then verify current page is "/ptgcorporatealliancepartners"
    And verify Alliance partner page heading displayed correctly
    And verify Alliance partner page body displayed correctly
