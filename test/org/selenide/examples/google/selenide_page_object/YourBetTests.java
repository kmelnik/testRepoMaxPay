package org.selenide.examples.google.selenide_page_object;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class YourBetTests extends SearchResultsPage {

    @Test
    public void checkOpenSite () {
        YourBetTests openPage = open("https://yourbet.com/", YourBetTests.class);
    SearchResultsPage results = openPage.searchCasinoText();
    results.searchCasinoText();


}


}
