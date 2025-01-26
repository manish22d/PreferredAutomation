package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{
    @FindBy(css = ".Page__header")
    WebElement pageTitle;

    @FindBy(css = ".Page__body")
    WebElement pageContent;

    @FindBy(css = ".Page__body h1 a")
    WebElement ctaLink;


    public String getPageBodyContent() {
        highlightAndReset(pageContent);
        return pageContent.getText();
    }

    public void clickOnCta(){
        highlightAndReset(ctaLink);
        String url = ctaLink.getAttribute("href");
        driver.get(url);
    }
}
