package org.selenide.examples.google.selenide_page_object;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class YourBetTests extends YourBetPages {


    @Test
    public void checkOpenSite () {

    YourBetPages page = open("https://yourbet.com/", YourBetPages.class);
    SearchResultsPage results = page.searchForCasinoText("КАЗИНО");
    results.getResults();

}
}
