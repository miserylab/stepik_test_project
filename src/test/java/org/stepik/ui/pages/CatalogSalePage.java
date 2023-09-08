package org.stepik.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogSalePage {
    SelenideElement catalogSalePageHeader = $(".t396__elem.tn-elem.tn-elem__6337934411693343301237");

    public CatalogSalePage openPage(){
        open("https://welcome.stepik.org/catalog-sale");
        return this;
    }

    public CatalogSalePage verifyCatalogSaleHeaderText(String value){
        catalogSalePageHeader.shouldHave(text(value));
        return this;
    }

}
