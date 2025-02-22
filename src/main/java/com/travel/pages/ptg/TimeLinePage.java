package com.travel.pages.ptg;

import com.travel.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TimeLinePage extends BasePage {
    @FindBy(css = ".fp-slidesContainer .active h1.timeline__title")
    WebElement displayedYear;

    @FindBy(css = ".fp-slidesContainer .active div.timeline__text")
    List<WebElement> displayedText;

    @FindBy(css = "img.timeline__arrow-right")
    WebElement nextButton;

    @FindBy(css = "img.timeline__arrow-left")
    WebElement prevButton;

    public TimeLinePage navigateToYear(String year) {
        wait.until(visibilityOf(displayedYear));
        while (!displayedYear.getText().equalsIgnoreCase(year)) {
            highlightAndClick(nextButton);
            wait.until(visibilityOf(displayedYear));
        }
        return this;
    }

    public String getContentText() {
        return displayedText.stream().map(WebElement::getText).collect(Collectors.joining());
    }

    public String getContentYear() {
        return displayedYear.getText();
    }
}
