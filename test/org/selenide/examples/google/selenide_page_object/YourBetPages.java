package org.selenide.examples.google.selenide_page_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class YourBetPages {

  public SearchResultsPage searchForCasinoText (String text) {
    $(By.xpath("//*[@id=\"applicationContainer\"]//div[3]/a[1]/img")).shouldBe(visible);
    $(By.xpath("//*[@id=\"applicationContainer\"]//div[2]/div/ul/li[1]/a/div/div")).shouldHave(text("КАЗИНО"));
    return page(SearchResultsPage.class);
  }
}
