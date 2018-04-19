package org.selenide.examples.google.selenide_page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class YourBetSearchElements {

 @FindBy (css = "#applicationContainer img")
  private SelenideElement logoPresent;

  public YourBetSearchElements searchLogoPresent () {
  logoPresent.shouldBe(visible);

   return page(YourBetSearchElements.class);

  }
}

