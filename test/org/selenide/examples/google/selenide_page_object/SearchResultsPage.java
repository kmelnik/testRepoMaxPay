package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import com.sun.org.apache.xpath.internal.operations.String;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class SearchResultsPage {


  @FindBy (xpath = "//*[@id=\"applicationContainer\"]/div/div/div[2]/div/div/div[2]/div/ul/li[1]/a/div/div")
  private SelenideElement searchText;

  public SearchResultsPage searchCasinoText () {
  searchText.shouldHave(text("КАЗИНО"));
    return  page(SearchResultsPage.class);
  }
}

