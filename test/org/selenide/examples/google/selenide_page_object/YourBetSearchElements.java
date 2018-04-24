package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class YourBetSearchElements {

    @FindBy(css = "#applicationContainer img")
    private SelenideElement logoPresent;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div")
    private SelenideElement loginButton;
    @FindBy(name = "email")
    private SelenideElement loginField;
    @FindBy(name = "password")
    private SelenideElement passwordFiled;
    @FindBy (tagName = "button")
    private SelenideElement buttonEnter;
    @FindBy (css = "#applicationContainer div.item.pincode.for-desktop-view.ng-binding")
    private SelenideElement pinCodeElement;
    @FindBy (className = "error-popup")
    private SelenideElement popupErrorLogin;

    public YourBetSearchElements searchLogoPresent() {
        logoPresent.shouldBe(visible);

        return page(YourBetSearchElements.class);

    }

    public YourBetSearchElements loginMethod() {
        loginButton.exists();
        loginButton.click();
        loginField.exists();
        loginField.setValue("ydt4");
        passwordFiled.exists();
        passwordFiled.setValue("Test2018");
        buttonEnter.exists();
        buttonEnter.pressEnter();
        pinCodeElement.isDisplayed();
        pinCodeElement.shouldHave(text("PIN:65243653"));



        return page(YourBetSearchElements.class);

    }
    public YourBetSearchElements loginMethodNegative() {
        loginButton.exists();
        loginButton.click();
        loginField.exists();
        loginField.setValue("ydt4");
        passwordFiled.exists();
        passwordFiled.setValue("Test28");
        buttonEnter.exists();
        buttonEnter.pressEnter();
        popupErrorLogin.isDisplayed();

        return page(YourBetSearchElements.class);
    }
}

