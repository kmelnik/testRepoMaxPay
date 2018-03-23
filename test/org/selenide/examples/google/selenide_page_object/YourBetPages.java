package org.selenide.examples.google.selenide_page_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class YourBetPages {

  public SearchResultsPage searchForCasinoText (String text) {
    return page(SearchResultsPage.class);
  }
}
