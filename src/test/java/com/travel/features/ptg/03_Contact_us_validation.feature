@Preferred
Feature: As a user i want to test contact-us page

  @contactUsPage
  Scenario: verify contact us page attributes
    Given user launch's preferred travel application
    When user want to navigate to "contact" option in menu
    And user clicks on contact-us link
    Then verify current page is "/contact-us"
    And verify Contact Page Freedom element is present
    And verify Join element is present
    And verify hoteliers element is present
    And verify email element is present
    And verify regional element is present
    And fill and submit contact form
