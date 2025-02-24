package com.travel.pages.ta;

import com.travel.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LaunchPage extends BasePage {

    @FindBy(css = "div.login input[id=':r0:']")
    WebElement emailTxtBox;

    @FindBy(css = "div.login input[id=':r1:']")
    WebElement pwdTxtBox;

    @FindBy(css = "button.login__submit")
    WebElement nextBtn;

    @FindBy(css = "span.HeaderLink__text p")
    WebElement myAccountLink;

    public LaunchPage launchTravelAdvisorPortal() {
        driver.navigate().to(property.getProperty("app.ta.url"));
        waitForPageToLoad();
        pause(3);
        WebElement acceptBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        wait.until(visibilityOf(acceptBtn));
        highlightAndClick(acceptBtn);
        return this;
    }

    public DashBoard performLogin() {
        String user = property.getProperty("app.ta.email");
        String cred = property.getProperty("app.ta.cred");
        fillText(emailTxtBox, user);
        fillText(pwdTxtBox, cred);
        highlightAndClick(nextBtn);
        wait.until(visibilityOf(myAccountLink));
        return new DashBoard();
    }
}
