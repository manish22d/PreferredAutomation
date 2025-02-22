package com.travel.pages.ptg;

import com.travel.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {

    @FindBy(css = "h1.about__header")
    WebElement pageTitle;

    @FindBy(css = "img.about__missionImg")
    WebElement pageBody;

    public String getHeader() {
        highlightAndReset(pageTitle);
        return pageTitle.getText();
    }

    public String getMissionStatement() {
        highlightAndReset(pageBody);
        return pageBody.getAttribute("alt");
    }
}
