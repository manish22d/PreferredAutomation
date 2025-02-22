package com.travel.pages.ptg;

import com.travel.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ContactUsPage extends BasePage {
    @FindBy(css = "a.mm-contact__link[href='/contact-us']")
    WebElement contactUsLink;

    @FindBy(css = "div.contact-page__freedom")
    WebElement freedom;
    @FindBy(css = "div.contact-page__join")
    WebElement join;
    @FindBy(css = "div.contact-page__hoteliers")
    WebElement hotelier;
    @FindBy(css = "div.contact-page__email-us")
    WebElement email;
    @FindBy(css = "div.contact-page__regional")
    WebElement regional;

    @FindBy(id = "your_name")
    WebElement name;
    @FindBy(id = "email")
    WebElement emailTxtBox;
    @FindBy(id = "hotel_name")
    WebElement hotel_name;
    @FindBy(id = "number_of_rooms_and_suites")
    WebElement number_of_rooms_and_suites;
    @FindBy(name = "submit")
    WebElement submitBtn;

    public ContactUsPage clickOnContactLink() {
        wait.until(elementToBeClickable(contactUsLink));
        highlightAndClick(contactUsLink);
        return this;
    }

    public String getFreedomElementText() {
        wait.until(visibilityOf(freedom));
        highlightAndReset(freedom);
        return freedom.getText();
    }

    public String getJoinElementText() {
        wait.until(visibilityOf(join));
        highlightAndReset(join);
        return join.getText();
    }

    public String getHotelierElementText() {
        wait.until(visibilityOf(hotelier));
        highlightAndReset(hotelier);
        return hotelier.getText();
    }

    public String getEmailElementText() {
        wait.until(visibilityOf(email));
        highlightAndReset(email);
        return email.getText();
    }

    public String getRegionalElementText() {
        wait.until(visibilityOf(regional));
        highlightAndReset(regional);
        return regional.getText();
    }

    public void fillAndSubmitForm() {
        highlightAndFillText(name, "test");
        highlightAndFillText(emailTxtBox, "aesparza@preferredtravelgroup.com");
        highlightAndFillText(hotel_name, "test");
        highlightAndFillText(number_of_rooms_and_suites, "test");
        highlightAndClick(submitBtn);

        pause(20);
    }


}
