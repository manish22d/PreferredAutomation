@HomePage
Feature: As a user i want to test different operation in Receiving page


  @HomePageTitle
  Scenario: verify menu option are correct
    Given user launch's preferred travel application
    Then user want to verify all menu options available
      | HOME            |
      | MEET OUR BRANDS |
      | TIMELINE        |
      | CONTACT         |
    And get screenshot


  @HomePageContact
  Scenario: verify title of Receiving page
    Given user launch's preferred travel application
    Then user want to navigate to "CONTACT" option in menu
    And get screenshot

  @HomePageFooterOptions
  Scenario: verify Footer Options
    Given user launch's preferred travel application
    Then user wants to verify "instagram" link is correct
    Then user wants to verify "facebook" link is correct
    Then user wants to verify "twitter" link is correct
    And get screenshot