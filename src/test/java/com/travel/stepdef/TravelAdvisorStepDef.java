package com.travel.stepdef;


import com.travel.pages.ta.DashBoard;
import com.travel.pages.ta.LaunchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TravelAdvisorStepDef {
    LaunchPage launchPage;
    DashBoard dashBoard;

    @Given("user launch's travel advisor portal")
    public void userLaunchPreferredTravelApplication() {
        launchPage = new LaunchPage();
        dashBoard = launchPage.launchTravelAdvisorPortal().performLogin();
    }

    @When("user name {string} displayed in dashboard")
    public void userNameDisplayedInDashboard(String name) {
        assertEquals(dashBoard.getUserName(), name);
    }

    @Then("verify tab {string} displayed in dashboard")
    public void verifyTabDisplayedInDashboard(String tabName) {
        assertTrue(dashBoard.isTabsOptionsAvailable(tabName));

    }
}
