package org.selenide.yourbet.pageObject_Maxpay;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.page;
import static org.selenide.yourbet.config_Properties_MaxPay.DataConfigMaxPay.getTestProperty;

public class LoginPage {

    @FindBy(css = "div.text-center.push-50 > div")
    SelenideElement logoMaxPay;
    @FindBy(id = "login-email")
    SelenideElement emailFieldForLogin;
    @FindBy(id = "login-password")
    SelenideElement passwordFieldForLogin;
    @FindBy(css = "button")
    SelenideElement buttonSignIn;
    @FindBy(id = "setting")
    SelenideElement settingDropBox;
    @FindBy(xpath = "//*[@id=\"header-navbar\"]//div/ul//span")
    SelenideElement displayedLoginEmail;
    @FindBy (css="div > p")
    SelenideElement errorMessege;

    public LoginPage loginPositiveTestMethod() {
        logoMaxPay.shouldBe(visible);
        emailFieldForLogin.isDisplayed();
        emailFieldForLogin.setValue(getTestProperty("positive_login"));
        passwordFieldForLogin.isDisplayed();
        passwordFieldForLogin.setValue(getTestProperty("positive_password"));
        buttonSignIn.isDisplayed();
        buttonSignIn.pressEnter();
        timeout = 15000;
        settingDropBox.isDisplayed();
        settingDropBox.click();
        displayedLoginEmail.shouldHave(text(getTestProperty("positive_login")));

        return page(LoginPage.class);
    }

    public LoginPage loginNegativeTestMethod() {
        logoMaxPay.shouldBe(visible);
        emailFieldForLogin.isDisplayed();
        emailFieldForLogin.setValue(getTestProperty("negative_login"));
        passwordFieldForLogin.isDisplayed();
        passwordFieldForLogin.setValue(getTestProperty("positive_password"));
        buttonSignIn.isDisplayed();
        buttonSignIn.pressEnter();
        errorMessege.shouldHave(text(getTestProperty("login_Error_Message")));

        return page(LoginPage.class);
    }
}