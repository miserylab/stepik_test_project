package org.stepik.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement bannerSale = $(".catalog-block-banner");

    public MainPage openPage(){
        open("/");
        return this;
    }

    public MainPage bannerSaleIsDisplayed() {
        bannerSale.isDisplayed();
        return this;
    }

    public MainPage clickBannerSale () {
        bannerSale.click();
        return this;
    }

}
