package com.travel.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class PressCenter extends BasePage {

    @FindBy(css = "h1.press-center__header")
    WebElement pageTitle;

    @FindBy(css = "h3.press-center__subheader")
    WebElement pageSubHeader;

    @FindBy(css = "a.press-center__card")
    List<WebElement> pressCenterCard;

    @FindBy(css = "td.press-releases__date div")
    List<WebElement> articleDate;

    @FindBy(css = "td.press-releases__link a")
    List<WebElement> articleTitle;
    List<Map<String, String>> articleList = new ArrayList<>();

    public String getPageHeader() {
        highlightAndReset(pageTitle);
        return pageTitle.getText();
    }

    public String getPageSubHeader() {
        highlightAndReset(pageSubHeader);
        return pageSubHeader.getText();
    }

    public boolean isCardAvailable(String cardLink) {

        wait.until(visibilityOfAllElements(pressCenterCard));
        WebElement card = pressCenterCard.stream().filter(ele -> ele.getAttribute("href").endsWith(cardLink)).findFirst().orElse(null);
        assert card != null;
        highlightAndReset(card);
        return card.isDisplayed();
    }

    public void navigateToCard(String cardLink) {
        wait.until(visibilityOfAllElements(pressCenterCard));

        WebElement card = pressCenterCard.stream().filter(ele -> ele.getAttribute("href").endsWith(cardLink)).findFirst().orElse(null);
        assert card != null;
        highlightAndReset(card);
        card.click();
        pause(2);
    }


    public void openRandomArticle() {
        wait.until(visibilityOfAllElements(articleDate));
        for (int i = 0; i < articleDate.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("date", articleDate.get(i).getText());
            map.put("title", articleTitle.get(i).getText());
            articleList.add(map);
        }

        WebElement article = articleTitle.get(new Random().nextInt(articleTitle.size() - 1));
        highlightAndReset(article);
        String articleTitle = article.getText();
        article.click();

        WebElement articleDate = driver.findElement(By.cssSelector("div.bulletin__date"));
        wait.until(visibilityOf(articleDate));
        highlightAndReset(articleDate);
        String actualDate = articleDate.getText();
        String expectedDate = articleList.stream().filter(a -> a.get("title").equalsIgnoreCase(articleTitle)).map(a -> a.get("date")).findFirst().orElse("");
        Assert.assertEquals(expectedDate, actualDate);
    }


    public void clickOnLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        highlightAndClick(link);
    }
}
