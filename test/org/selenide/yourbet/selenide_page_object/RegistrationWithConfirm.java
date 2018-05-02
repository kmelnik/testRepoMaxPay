package org.selenide.yourbet.selenide_page_object;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.SelenideElement;

import com.codeborne.selenide.commands.ScrollTo;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Configuration.timeout;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithConfirm extends ActionsWithElements {

    @FindBy(name = "mail")
    public SelenideElement loginMailFieldTempReg;
    @FindBy(name = "domain")
    public SelenideElement domainNameTempReg;
    @FindBy(id = "postbut")
    public SelenideElement saveButtonTempMail;
    @FindBy(id = "click-to-refresh")
    public SelenideElement refreshLinkTempMail;
    @FindBy (css = "#mails > tbody > tr > td:nth-child(2) > a")
    public SelenideElement clickActivateAccountLinkTempMail;
    @FindBy (xpath="//*//a[contains(text(),'link')]")
    public SelenideElement linkForConfirmAccountTempMail;
    @FindBy (xpath = "/html/body/div[6]/div/div/div/div[2]/span")
    public SelenideElement congratulationsRegPopup;


    public RegistrationWithConfirm checkRegistrationMethodWithConfirm() {
        checkRegistrationMethod();
        switchTo().defaultContent();
        open("https://temp-mail.org/en/option/change/");
        loginMailFieldTempReg.setValue(email);
        domainNameTempReg.selectOptionContainingText("@2odem.com");
        saveButtonTempMail.pressEnter();
        refreshLinkTempMail.click();
        clickActivateAccountLinkTempMail.waitUntil(Condition.visible, 20000);
        clickActivateAccountLinkTempMail.click();
        linkForConfirmAccountTempMail.scrollTo();
        linkForConfirmAccountTempMail.followLink();
        timeout=15000;
        congratulationsRegPopup.shouldHave(Condition.text("Congratulations!"));



        return page(RegistrationWithConfirm.class);
    }



}
