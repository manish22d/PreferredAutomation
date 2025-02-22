@Preferred
Feature: As a user i want to test Timeline page

  @timelinepage
  Scenario: verify Year wise content displayed correctly on timeline page
    Given user launch's preferred travel application
    When user want to navigate to "TIMELINE" option in menu
    And user want to navigate to "1968" year in timeline page
    Then verify content text displayed related to year "1968"
    And user want to navigate to "1981" year in timeline page
    Then verify content text displayed related to year "1981"
    And user want to navigate to "1990" year in timeline page
    Then verify content text displayed related to year "1990"
    And user want to navigate to "1990s" year in timeline page
    Then verify content text displayed related to year "1990s"
    And user want to navigate to "2000" year in timeline page
    Then verify content text displayed related to year "2000"
    And user want to navigate to "2001" year in timeline page
    Then verify content text displayed related to year "2001"
    And user want to navigate to "2004" year in timeline page
    Then verify content text displayed related to year "2004"
    And user want to navigate to "2005" year in timeline page
    Then verify content text displayed related to year "2005"
    And user want to navigate to "2006" year in timeline page
    Then verify content text displayed related to year "2006"
    And user want to navigate to "2007" year in timeline page
    Then verify content text displayed related to year "2007"
    And user want to navigate to "2010" year in timeline page
    Then verify content text displayed related to year "2010"
    And user want to navigate to "2011" year in timeline page
    Then verify content text displayed related to year "2011"
    And user want to navigate to "2012" year in timeline page
    Then verify content text displayed related to year "2012"
    And user want to navigate to "2015" year in timeline page
    Then verify content text displayed related to year "2015"
    And user want to navigate to "2016" year in timeline page
    Then verify content text displayed related to year "2016"
    And user want to navigate to "2019" year in timeline page
    Then verify content text displayed related to year "2019"
    And user want to navigate to "2020" year in timeline page
    Then verify content text displayed related to year "2020"
    And user want to navigate to "2022" year in timeline page
    Then verify content text displayed related to year "2022"
    And get screenshot