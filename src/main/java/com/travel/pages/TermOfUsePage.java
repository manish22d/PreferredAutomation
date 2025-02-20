package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TermOfUsePage extends BasePage{

    @FindBy(css = "h1")
    WebElement pageTitle;

    @FindBy(css = "#content li")
    List<WebElement> contentList;
    public List<String> getContentList() {
        contentList.forEach(this::highlightAndReset);
        return contentList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getHeading() {
        highlightAndReset(pageTitle);
        return pageTitle.getText();
    }
}
