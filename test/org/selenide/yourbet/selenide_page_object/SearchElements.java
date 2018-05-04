package org.selenide.yourbet.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.selenide.yourbet.configProperties.DataConfig;

import static com.codeborne.selenide.Selenide.$$;

public class SearchElements extends DataConfig {
    @FindBy(css = "#applicationContainer img")
    public SelenideElement logoPresent;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div")
    public SelenideElement loginButton;
    @FindBy(name = "email")
    public SelenideElement loginField;
    @FindBy(name = "password")
    public SelenideElement passwordFiled;
    @FindBy(tagName = "button")
    public SelenideElement buttonEnter;
    @FindBy(css = "#applicationContainer div.item.pincode.for-desktop-view.ng-binding")
    public SelenideElement pinCodeElement;
    @FindBy(className = "error-popup")
    public SelenideElement popupErrorLogin;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[2]/div[1]/div")
    public SelenideElement registrationButton;
    @FindBy(name = "email")
    public SelenideElement emailFieldRegForm;
    @FindBy(name = "login")
    public SelenideElement loginRegFormField;
    @FindBy(name = "password")
    public SelenideElement passwordFiledRegForm;
    @FindBy(css = "#register > div > div.column-1.input-wrap > form > div.footer-bottom_wrap.column-1 > div.footer-bottom > div.currency-wrapper.p-b_17 > div:nth-child(2) > label")
    public SelenideElement radioButtonEUR;
    @FindBy(css = "#register > div > div.column-1.input-wrap > form > div.footer-bottom_wrap.column-1 > div.footer-bottom > div.checkbox-wrapper > div > label")
    public SelenideElement checkBoxAgreeTerms;
    @FindBy(xpath = "//*[@id=\"register\"]/div/div[2]/form/div[2]/div[1]/input")
    public SelenideElement registrationButtonInForm;
    @FindBy(xpath = "//*//h5[contains (text(), 'Please follow the activation link sent to you by e-mail')]")
    public SelenideElement activateAccountPopupInfo;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/img")
    public SelenideElement profileAvatar;
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div[2]/div[2]/div/form/div/div/div[4]/div/div[4]/div/input")
    public SelenideElement saveProfileDataButton;
    @FindBy(className = "gap")
    public SelenideElement saveProfilePopup;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[1]/div/div/div[3]/div[3]/div")
    public SelenideElement cashierIcon;
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div[3]")
    public SelenideElement visa_mastercard_RadioButton;
    @FindBy(id = "profile-deposit-amount")
    public SelenideElement fieldForSumVisaMastercard;
    @FindBy(id = "profile-process-deposit")
    public SelenideElement depositButtonVisaMastercard;
    @FindBy(xpath = "//*[@id=\"payment-form\"]/section[1]/div[3]/div[2]/strong")
    public SelenideElement cardPaySumPresent;
    @FindBy(id = "card-number")
    public SelenideElement inputCardNumberField;
    @FindBy(id = "card-holder")
    public SelenideElement inputCardHolderField;
    @FindBy(id = "exp-month")
    public SelenideElement cardExpiresMonth;
    @FindBy(id = "exp-year")
    public SelenideElement cardExpiresYear;
    @FindBy(id = "cvc")
    public SelenideElement cvvField;
    @FindBy(id = "btn-submit")
    public SelenideElement payCardSubmitButton;
    @FindBy(id = "success")
    public SelenideElement successPaymentEmulateButton;
    @FindBy(id = "input.0")
    public SelenideElement paymentStatus;
    @FindBy (xpath = "//*//a[@href='/en/promotions']")
    public SelenideElement linkPromoPage;
    @FindBy(xpath = "//*[@id=\"applicationContainer\"]/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/img")
    public SelenideElement welcomeBonusPage;
    @FindBy(css = "#applicationContainer > div > div > div.container.ng-scope > div > div > div.content.promos-content > div > div:nth-child(2) > div.promo-item__cover > img")
    public SelenideElement bonus555Page;
    @FindBy (css = "#applicationContainer > div > div > div.container.ng-scope > div > div > div.content.promos-content > div > div:nth-child(3) > div.promo-item__cover > img")
    public SelenideElement freespinsBonusPage;
    @FindBy (css = "#applicationContainer > div > div > div.container.ng-scope > div > div > div.content.promos-content > div > div:nth-child(4) > div.promo-item__cover > img")
    public SelenideElement megaBonusPage;









}

