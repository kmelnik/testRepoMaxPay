package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
  @FindBy (xpath = "//*[@id=\"applicationContainer\"]//div[2]/div/ul/li[1]/a/div/div")
  private SelenideElement searchText;
  public SelenideElement getResults() {
    return $(searchText);
  }
}

