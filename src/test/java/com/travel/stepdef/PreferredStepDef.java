package com.travel.stepdef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.travel.core.WebDriverManager;
import com.travel.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class PreferredStepDef {
    public HomePage homePage;
    public TimeLinePage timeLinePage;
    public ContactUsPage contactUsPage;
    public CareerPage careerPage;

    public PressCenter pressCenter;

    public ExecutiveProfilesPage executiveProfilesPage;

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

    @When("user want to navigate to {string} option in sub menu")
    public void userWantToNavigateToOptionInSubMenu(String subMenuName) {
        homePage.openMenuOptions().navigateToSubMenu(subMenuName);
    }

    @And("user want something")
    public void userWantSomething() {

    }

    @Then("user wants to verify {string} link is correct")
    public void userWantsToVerifyLinkIsCorrect(String socialMediaName) {
        String url = homePage.getSocialLink(socialMediaName);
        System.out.println("verifying -> " + url);
        Assert.assertTrue(url.endsWith("PreferredHotels"));
    }

    @And("user want to navigate to {string} year in timeline page")
    public void userWantToNavigateToYearInTimelinePage(String year) {
        timeLinePage = new TimeLinePage();
        timeLinePage.navigateToYear(year);
    }

    @Then("verify content text displayed related to year {string}")
    public void verifyContentTextDisplayedRelatedToYear(String year) {
        System.out.println(timeLinePage.getContentYear() + " - " + timeLinePage.getContentText());
        Assert.assertEquals(year, timeLinePage.getContentYear());
        Assert.assertFalse(timeLinePage.getContentText().isEmpty());
    }

    @And("user clicks on contact-us link")
    public void userClicksOnContactUsLink() {
        contactUsPage = new ContactUsPage();
        contactUsPage.clickOnContactLink();
    }

    @Then("verify current page is {string}")
    public void verifyCurrentPageIs(String url) {
        Assert.assertTrue(WebDriverManager.getDriver().getCurrentUrl().contains(url));
    }

    @And("verify page title is {string}")
    public void verifyPageTitleIs(String title) {
        Assert.assertEquals(title, WebDriverManager.getDriver().getTitle());
    }

    @And("verify Contact Page Freedom element is present")
    public void verifyContactPageFreedomElementIsPresent() {
        String text = contactUsPage.getFreedomElementText();
        System.out.println(text);
        Assert.assertFalse(text.isEmpty());
    }

    @And("verify Join element is present")
    public void verifyJoinElementIsPresent() {
        String text = contactUsPage.getJoinElementText();
        System.out.println(text);
        Assert.assertFalse(text.isEmpty());
    }

    @And("verify hoteliers element is present")
    public void verifyHoteliersElementIsPresent() {
        String text = contactUsPage.getHotelierElementText();
        System.out.println(text);
        Assert.assertFalse(text.isEmpty());
    }

    @And("verify email element is present")
    public void verifyEmailElementIsPresent() {
        String text = contactUsPage.getEmailElementText();
        System.out.println(text);
        Assert.assertFalse(text.isEmpty());
    }

    @And("verify regional element is present")
    public void verifyRegionalElementIsPresent() {
        String text = contactUsPage.getRegionalElementText();
        System.out.println(text);
        Assert.assertFalse(text.isEmpty());
    }

    @And("fill and submit contact form")
    public void fillAndSubmitContactForm() {
        contactUsPage.fillAndSubmitForm();
    }


    @And("verify career page content displayed correctly")
    public void verifyCareerPageContentDisplayedCorrectly() {
        careerPage = new CareerPage();
        String text = careerPage.getPageBodyContent();
        Assert.assertFalse(text.isEmpty());
    }

    @And("click on cta link")
    public void clickOnCtaLink() {
        careerPage.clickOnCta();
    }

    @And("Verify press center page Header is present")
    public void verifyPressCenterPageHeaderIsPresent() {
        pressCenter = new PressCenter();
        Assert.assertFalse(pressCenter.getPageHeader().isEmpty());
    }

    @And("Verify press center page  Sub header is present")
    public void verifyPressCenterPageSubHeaderIsPresent() {
        Assert.assertFalse(pressCenter.getPageSubHeader().isEmpty());

    }
    @And("verify press center card {string} is present")
    public void verifyPressCenterCardIsPresent(String cardLink) {
        Assert.assertTrue(pressCenter.isCardAvailable(cardLink));
    }

    @Then("user click on {string} card")
    public void userClickOnCard(String cardLink) {
        PressCenter pressCenter=new PressCenter();
        pressCenter.navigateToCard(cardLink);
    }



    @And("click on random article link on in the news page")
    public void clickOnRandomArticleLinkOnInTheNewsPage() {
        InTheNewsPage inTheNewsPage = new InTheNewsPage();
        inTheNewsPage.clickOnRandomArticle();
    }

    @And("click on random article link and verify date is same")
    public void clickOnRandomArticleLinkAndVerifyDateIsSame() {
        pressCenter.openRandomArticle();
    }

    @And("verify Profile picture displayed for each executive")
    public void verifyProfilePictureDisplayedForEachExecutive() {
        executiveProfilesPage = new ExecutiveProfilesPage();
        executiveProfilesPage.isProfilePictureDisplayed();
    }

    @And("verify Profile name displayed for each executive")
    public void verifyProfileNameDisplayedForEachExecutive() {
        executiveProfilesPage.isProfileNameDisplayed();
    }

    @And("verify Profile position displayed for each executive")
    public void verifyProfilePositionDisplayedForEachExecutive() {
        executiveProfilesPage.isProfilePositionDisplayed();
    }

    @And("verify Profile body displayed for each executive")
    public void verifyProfileBodyDisplayedForEachExecutive() {
        executiveProfilesPage.isProfileBodyDisplayed();
    }

    @And("user clicks on link {string} in press center page")
    public void userClicksOnLinkInPressCenterPage(String linkText) {
        PressCenter pressCenter = new PressCenter();
        pressCenter.clickOnLink(linkText);
    }

    @And("navigate back to original page")
    public void navigateBackToOriginalPage() {
        WebDriverManager.getDriver().navigate().back();
    }
}
