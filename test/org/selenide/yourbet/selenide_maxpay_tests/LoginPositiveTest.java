package org.selenide.yourbet.selenide_maxpay_tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.selenide.yourbet.pageObject_Maxpay.LoginPage;
import org.selenide.yourbet.selenide_page_object.ActionsWithElements;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static org.selenide.yourbet.config_Properties_MaxPay.DataConfigMaxPay.getTestProperty;

public class LoginPositiveTest extends LoginPage {


    @Before
    public void testSetUp()  {

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
    public void loginOnPossitiveTest() {
        LoginPage openURL = open(getTestProperty("url_login_page"), LoginPage.class);
        LoginPage loginOn = openURL.loginPositiveTestMethod();
    }
    @After
    public void testShutDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }
}

