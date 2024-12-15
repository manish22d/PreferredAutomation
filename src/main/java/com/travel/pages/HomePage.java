package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends BasePage {
    @FindBy(css = ".header__menu")
    WebElement menuLink;

    @FindBy(css = ".mega-menu__close")
    WebElement closeMenu;

    @FindBy(css = ".mega-menu__main-link")
    List<WebElement> menuLinks;


    public HomePage() {
        super();
    }

    public HomePage launchApplication() {
        driver.navigate().to(property.getProperty("app.url"));
        waitForPageToLoad();
        return this;
    }

    public HomePage openMenuOptions() {
        wait.until(elementToBeClickable(menuLink));
        menuLink.click();
        pause(2);
        return this;
    }

    public HomePage closeMenuOptions() {
        wait.until(elementToBeClickable(closeMenu));
        closeMenu.click();
        pause(2);
        return this;
    }

    public List<String> menuOptions() {
        wait.until(visibilityOfAllElements(menuLinks));
        return menuLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void navigateToOption(String optionName) {
        WebElement ele = menuLinks.stream().filter(e->e.getText().equalsIgnoreCase(optionName)).findFirst().orElse(null);
        wait.until(elementToBeClickable(ele));
        assert ele != null;
        ele.click();
        pause(2);
    }
}