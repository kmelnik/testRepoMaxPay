package org.selenide.examples.google.selenide_page_object;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;


public class YourBetTests extends YourBetSearchElements {
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
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        YourBetSearchElements searchLogo = openURL.searchLogoPresent();

    }

    @Test
    public void loginOnPossitiveTest() {
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        YourBetSearchElements searchLogo = openURL.searchLogoPresent();
        YourBetSearchElements loginOn = openURL.loginMethod();
    }

    @Test
    public void loginOnNegativeTest() {
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        YourBetSearchElements searchLogo = openURL.searchLogoPresent();
        YourBetSearchElements loginOn = openURL.loginMethodNegative();
    }

    @Test
    public void checkRegistrationTest() {
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        YourBetSearchElements searchLogo = openURL.searchLogoPresent();
        YourBetSearchElements registrationOn = openURL.checkRegistrationMethod();
    }

    @Test
    public void checkProfileUpdate() {
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        loginOnPossitiveTest();
        YourBetSearchElements profileUpdate = openURL.profileUpdateMethod();
    }

    @Test
    public void checkDepositByCreditCard () {
        YourBetSearchElements openURL = open("https://yourbet.com", YourBetSearchElements.class);
        loginOnPossitiveTest();
        YourBetSearchElements checkDepositbyCreditCard = openURL.bankCardDepositMethod();

    }
    @After
    public void testShutDown() {
        WebDriverRunner.clearBrowserCache();
    }
}
