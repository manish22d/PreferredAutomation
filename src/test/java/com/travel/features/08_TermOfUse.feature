@Preferred @TermOfUse
Feature: As a user i want to test press center option in submenu

  @TermOfUse
  Scenario: verify Term Of Use page
    Given user launch's preferred travel application
    When user want to navigate to "Terms Of Use" option in sub menu
    Then verify current page is "/terms-of-use-all-languages"
    And verify term of use page header displayed correctly
    And verify content list is available in term of use page
