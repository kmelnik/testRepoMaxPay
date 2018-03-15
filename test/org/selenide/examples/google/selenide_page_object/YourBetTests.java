package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.isChrome;


public class YourBetTests {

   @Test
   public void openSite() {
       isChrome();
       open("https://yourbet.com/");
       $(By.xpath("//*[@id=\"applicationContainer\"]//div[3]/a[1]/img")).shouldBe(visible).shouldHave(text(""));
       $(By.xpath("//*[@id=\"applicationContainer\"]//div[2]/div/ul/li[1]/a/div/div")).shouldHave(text("КАЗИНО"));
   }

}
