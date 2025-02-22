package com.travel.pages.ptg;

import com.travel.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ExecutiveProfilesPage extends BasePage {

    @FindBy(css = ".profiles__person-container")
    List<WebElement> profiles;

    public void isProfilePictureDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(profiles));
        for (WebElement profile : profiles) {
            WebElement profilePic = profile.findElement(By.cssSelector("img.profiles__img"));
            highlightAndReset(profilePic);
            Assert.assertTrue(profilePic.isDisplayed());
        }
    }

    public void isProfilePositionDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(profiles));
        for (WebElement profile : profiles) {
            WebElement profilePosition = profile.findElement(By.cssSelector("h6.profiles__position"));
            highlightAndReset(profilePosition);
            Assert.assertTrue(profilePosition.isDisplayed());
        }
    }

    public void isProfileNameDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(profiles));
        for (WebElement profile : profiles) {
            WebElement profileName = profile.findElement(By.cssSelector("h2.profiles__name"));
            highlightAndReset(profileName);
            Assert.assertTrue(profileName.isDisplayed());
        }
    }

    public void isProfileBodyDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(profiles));
        for (WebElement profile : profiles) {
            WebElement profileBody = profile.findElement(By.cssSelector("div.profiles__body"));
            highlightAndReset(profileBody);
            Assert.assertTrue(profileBody.isDisplayed());
        }
    }
}
