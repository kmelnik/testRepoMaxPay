package org.selenide.examples.google.selenide_page_object;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class YourBetTests extends YourBetSearchElements {
    @Before
    public void testSetUp() {

        //CHROME Browser
        Configuration.browser = "chrome";
        // System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        //FIREFOX Browser

        //SAFARI Browser

        //IE Browser

        //EDGE Browser
    }

    @Test
    public void checkOpenSite() {
        YourBetSearchElements searchElement=open("https://yourbet.com", YourBetSearchElements.class);
        searchElement.searchLogoPresent();


    }

    @After
    public void testShutDown() {
        WebDriverRunner.clearBrowserCache();
    }
}
