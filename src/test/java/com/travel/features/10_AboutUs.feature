@Preferred @AboutUs
Feature: As a user i want to test press center option in submenu

  @AboutUs
  Scenario: verify About Us page
    Given user launch's preferred travel application
    When user want to navigate to "About Us" option in sub menu
    Then verify current page is "/about-us"
    And Verify about us page heading displayed correctly
    And verify about us page mission statement displayed correctly

