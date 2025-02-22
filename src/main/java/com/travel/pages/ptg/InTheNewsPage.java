package com.travel.pages.ptg;

import com.travel.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class InTheNewsPage extends BasePage {

    @FindBy(css = "h2.news-item__title a")
    List<WebElement> articleLink;


    public void clickOnRandomArticle() {
        wait.until(visibilityOfAllElements(articleLink));
        Random random = new Random();
        String url = articleLink.get(random.nextInt(articleLink.size())).getAttribute("href");
        driver.get(url);
        pause(2);
    }

}
