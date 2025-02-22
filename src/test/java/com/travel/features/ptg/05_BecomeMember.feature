@Preferred
Feature: As a user i want to test become a member option in submenu

  @becomeamember
  Scenario: verify Become a member page
    Given user launch's preferred travel application
    When user want to navigate to "Become A Member" option in sub menu
    Then verify current page is "/contact-us"