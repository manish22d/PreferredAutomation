package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlliancePartnerPage extends BasePage {
    @FindBy(css = ".Page__header")
    WebElement pageTitle;

    @FindBy(css = ".Page__body")
    WebElement pageBody;

    public String getHeader() {
        highlightAndReset(pageTitle);
        return pageTitle.getText();
    }

    public String getBody() {
        highlightAndReset(pageBody);
        return pageBody.getText();
    }
}
