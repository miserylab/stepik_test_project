package org.stepik.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class CatalogSalePage {
    SelenideElement catalogSalePageHeader = $(".t396__elem.tn-elem.tn-elem__6337934411693343301237");

    public CatalogSalePage verifyCatalogSaleHeaderText(String value){
        switchTo().window(1);
        catalogSalePageHeader.shouldHave(text(value));
        return this;
    }

    public CatalogSalePage verifyUrl(String value) {
        switchTo().window(1);
        webdriver().shouldHave(urlStartingWith(value));
        return this;
    }
}
