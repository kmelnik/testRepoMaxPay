package org.selenide.examples;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.selenide.yourbet.selenide_page_object.ActionsWithElements;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;


public class YourBetTests extends ActionsWithElements {
    @Before
    public void testSetUp() {

        //CHROME Browser
        browser = "chrome";
        // System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        //FIREFOX Browser

        //SAFARI Browser

        //IE Browser

        //EDGE Browser
    }

    @Test
    public void checkOpenSite() {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        ActionsWithElements searchLogo = openURL.searchLogoPresent();

    }

    @Test
    public void loginOnPossitiveTest() {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        ActionsWithElements searchLogo = openURL.searchLogoPresent();
        ActionsWithElements loginOn = openURL.loginMethod();
    }

    @Test
    public void loginOnNegativeTest() {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        ActionsWithElements searchLogo = openURL.searchLogoPresent();
        ActionsWithElements loginOn = openURL.loginMethodNegative();
    }

    @Test
    public void checkRegistrationTest() {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        ActionsWithElements searchLogo = openURL.searchLogoPresent();
        ActionsWithElements registrationOn = openURL.checkRegistrationMethod();
    }

    @Test
    public void checkProfileUpdate() {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        loginOnPossitiveTest();
        ActionsWithElements profileUpdate = openURL.profileUpdateMethod();
    }

    @Test
    public void checkDepositByCreditCard () {
        ActionsWithElements openURL = open("https://test.yourbet.com", ActionsWithElements.class);
        loginOnPossitiveTest();
        ActionsWithElements checkDepositbyCreditCard = openURL.bankCardDepositMethod();

    }
    @After
    public void testShutDown() {
        WebDriverRunner.clearBrowserCache();
    }
}
