package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
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
    @FindBy(tagName = "button")
    private SelenideElement buttonEnter;
    @FindBy(css = "#applicationContainer div.item.pincode.for-desktop-view.ng-binding")
    private SelenideElement pinCodeElement;
    @FindBy(className = "error-popup")
    private SelenideElement popupErrorLogin;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[2]/div[1]/div")
    private SelenideElement registrationButton;
    @FindBy(name = "email")
    private SelenideElement emailFieldRegForm;
    @FindBy(name = "login")
    private SelenideElement loginRegFormField;
    @FindBy(name = "password")
    private SelenideElement passwordFiledRegForm;
    @FindBy(css = "#register > div > div.column-1.input-wrap > form > div.footer-bottom_wrap.column-1 > div.footer-bottom > div.currency-wrapper.p-b_17 > div:nth-child(2) > label")
    private SelenideElement radioButtonEUR;
    @FindBy(css = "#register > div > div.column-1.input-wrap > form > div.footer-bottom_wrap.column-1 > div.footer-bottom > div.checkbox-wrapper > div > label")
    private SelenideElement checkBoxAgreeTerms;
    @FindBy(xpath = "//*[@id=\"register\"]/div/div[2]/form/div[2]/div[1]/input")
    private SelenideElement registrationButtonInForm;
    @FindBy(xpath = "/html/body/div[8]/div/div/div/div[2]")
    private SelenideElement activateAccountPopupInfo;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/img")
    private SelenideElement profileAvatar;
    @FindBy(xpath = "/html/body/div[7]/div/div/div/div[2]/div[2]/div/form/div/div/div[4]/div/div[4]/div/input")
    private SelenideElement saveProfileDataButton;
    @FindBy(className = "holder-login")
    private SelenideElement saveProfilePopup;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[3]/div")
    private SelenideElement cashierIcon;
    @FindBy(xpath = "/html/body/div[7]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div[1]")
    private SelenideElement visa_mastercard_RadioButton;
    @FindBy(id = "profile-deposit-amount")
    private SelenideElement fieldForSumVisaMastercard;
    @FindBy(id = "profile-process-deposit")
    private SelenideElement depositButtonVisaMastercard;
    @FindBy(id = "total-amount")
    private SelenideElement cardPaySumPresent;
    @FindBy(id = "input-card-number")
    private SelenideElement inputCardNumberField;
    @FindBy(id = "input-card-holder")
    private SelenideElement inputCardHolderField;
    @FindBy(id = "card-expires-month")
    private SelenideElement cardExpiresMonth;
    @FindBy(id = "card-expires-year")
    private SelenideElement cardExpiresYear;
    @FindBy(id = "input-card-cvc")
    private SelenideElement cvvField;
    @FindBy(id = "action-submit")
    private SelenideElement payCardSubmitButton;

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

    public YourBetSearchElements checkRegistrationMethod() {
        registrationButton.exists();
        registrationButton.click();
        emailFieldRegForm.exists();
        emailFieldRegForm.setValue("fodsjjfds@gmail.com");
        loginRegFormField.exists();
        loginRegFormField.setValue("cow10");
        passwordFiledRegForm.exists();
        passwordFiledRegForm.setValue("Test2018");
        radioButtonEUR.exists();
        radioButtonEUR.click();
        checkBoxAgreeTerms.exists();
        checkBoxAgreeTerms.click();
        registrationButtonInForm.pressEnter();
        activateAccountPopupInfo.isDisplayed();

        return page(YourBetSearchElements.class);
    }

    public YourBetSearchElements profileUpdateMethod() {
        profileAvatar.click();
        passwordFiled.clear();
        passwordFiled.setValue("Test2018");
        saveProfileDataButton.waitUntil(enabled, 10000);
        saveProfileDataButton.pressEnter();
        saveProfilePopup.isDisplayed();
        // saveProfilePopup.shouldHave(text("Настройки профіля збережено"));
        return page(YourBetSearchElements.class);
    }

    public YourBetSearchElements bankCardDepositMethod() {
        cashierIcon.click();
        visa_mastercard_RadioButton.click();
        fieldForSumVisaMastercard.setValue("55");
        depositButtonVisaMastercard.pressEnter();
        cardPaySumPresent.shouldHave(exactText("55.00"));
        inputCardNumberField.setValue("4000000000000002");
        inputCardHolderField.setValue("Kostyantyn Melnyk");
        cardExpiresMonth.click();
        cardExpiresMonth.selectOptionContainingText("09");
        cardExpiresYear.click();
        cardExpiresYear.selectOptionContainingText("2023");
        cvvField.setValue("111");
        payCardSubmitButton.pressEnter();

        return page(YourBetSearchElements.class);
    }
}

