@Preferred
Feature: As a user i want to test Career page

  @CareerPage
  Scenario: verify career page attributes
    Given user launch's preferred travel application
    When user want to navigate to "Careers" option in sub menu
    Then verify current page is "/ptgcorpcareers"
    And verify page title is "_PTG_CORP_CAREERS_"
    And verify career page content displayed correctly
    And click on cta link
    Then verify current page is "workforcenow.adp.com"
