@Preferred @PressCenter
Feature: As a user i want to test press center option in submenu

  @pressCenterPressRelease
  Scenario: verify press center page
    Given user launch's preferred travel application
    When user want to navigate to "Press Center" option in sub menu
    Then verify current page is "/press-center"
    And Verify press center page Header is present
    And Verify press center page  Sub header is present
    And verify press center card "/press-center/press-releases" is present
    And verify press center card "/press-center/in-the-news" is present
    And verify press center card "/executive-profiles" is present
    And verify press center card "/press-center/press-kit" is present
    And verify press center card "/media-contacts" is present
    Then user click on "/press-center/press-releases" card
    Then verify current page is "/press-center/press-releases"
    And click on random article link and verify date is same


  @pressCenterInTheNews
  Scenario: verify press center - in the news article displayed correctly
    Given user launch's preferred travel application
    When user want to navigate to "Press Center" option in sub menu
    Then verify current page is "/press-center"
    Then user click on "/press-center/in-the-news" card
    Then verify current page is "/press-center/in-the-news"
    And click on random article link on in the news page
    And verify current page is ".pdf"

  @pressCenterExecutiveProfile
  Scenario: verify press center-executive profiles displayed correctly
    Given user launch's preferred travel application
    When user want to navigate to "Press Center" option in sub menu
    Then verify current page is "/press-center"
    Then user click on "/executive-profiles" card
    Then verify current page is "/executive-profiles"
    And verify Profile picture displayed for each executive
    And verify Profile name displayed for each executive
    And verify Profile position displayed for each executive
    And verify Profile body displayed for each executive

  @pressCenterPressKit
  Scenario: verify press center - Press Kit links are correct
    Given user launch's preferred travel application
    When user want to navigate to "Press Center" option in sub menu
    Then verify current page is "/press-center"
    Then user click on "/press-center/press-kit" card
    Then verify current page is "/press-center/press-kit"
    And user clicks on link "Executive Profiles" in press center page
    Then verify current page is "/executive-profiles"
    And navigate back to original page
    And user clicks on link "Preferred Hotels & Resorts Corporate Fact Sheet" in press center page
    Then verify current page is ".pdf"
    And navigate back to original page
    And user clicks on link "Preferred Hotels & Resorts Timeline" in press center page
    Then verify current page is "/timeline"
    And navigate back to original page
    And user clicks on link "HVS Study of Preferred Hotels & Resorts" in press center page
    Then verify current page is ".pdf"
    And navigate back to original page