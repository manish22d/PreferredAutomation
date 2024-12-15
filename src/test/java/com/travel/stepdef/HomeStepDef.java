package com.travel.stepdef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.travel.core.WebDriverManager;
import com.travel.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class HomeStepDef {
    public HomePage homePage;

    @Given("user launch's preferred travel application")
    public void userLaunchsPreferredTravelApplication() {
        homePage = new HomePage();
        homePage.launchApplication();
    }

    @When("user want to get list menu options")
    public void userWantToGetListMenuOptions() {
        System.out.println(homePage.menuOptions());
        homePage.closeMenuOptions();
    }

    @Then("user want to verify all menu options available")
    public void userWantToVerifyAllMenuOptionsAvailable(List<String> expectedMenuOptions) {
        List<String> actualMenuOptions = homePage.openMenuOptions().menuOptions();
        System.out.println("actual ->" + actualMenuOptions);
        System.out.println("expected -> " + expectedMenuOptions);
        homePage.closeMenuOptions();
        Assert.assertEquals(actualMenuOptions, expectedMenuOptions);
    }

    @And("get screenshot")
    public void getScreenshot() {
        WebDriver driver = WebDriverManager.getDriver();
        ExtentCucumberAdapter.getCurrentStep()
                .log(Status.INFO, "screenshot",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
    }

    @Then("user want to navigate to {string} option in menu")
    public void userWantToNavigateToOptionInMenu(String optionName) {
        homePage.openMenuOptions().navigateToOption(optionName);

    }
}
