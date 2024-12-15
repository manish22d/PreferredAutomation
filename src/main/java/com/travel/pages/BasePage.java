package com.travel.pages;


import com.travel.core.WebActions;
import com.travel.core.WebDriverManager;
import com.travel.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Properties;

public class BasePage extends WebActions {

    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public Properties property;
    Actions actions;

    public BasePage() {
        this.driver = WebDriverManager.getDriver();
        property = PropertyUtils.getProperty();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        actions = new Actions(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}
