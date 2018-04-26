package org.selenide.yourbet.selenide_page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byText;
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
    @FindBy (xpath="/html/body/div[2]/div/div/div[2]/div[1]/div[1]/div[3]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]/a")
    public SelenideElement linkForConfirmAccountTempMail;


    public RegistrationWithConfirm checkRegistrationMethodWithConfirm() {
        checkRegistrationMethod();
        // for switching to default window
        switchTo().defaultContent();
        open("https://temp-mail.org/en/option/change/");
        loginMailFieldTempReg.setValue("cow11");
        domainNameTempReg.selectOptionContainingText("@carbtc.net");
        saveButtonTempMail.pressEnter();
        refreshLinkTempMail.click();
        clickActivateAccountLinkTempMail.waitUntil(Condition.visible, 10000);
        clickActivateAccountLinkTempMail.click();
        $(byText("link")).followLink();






        return page(RegistrationWithConfirm.class);
    }
}
