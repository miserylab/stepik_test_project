package org.stepik.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.stepik.ui.helpers.WebPageElementsGetter.getHeadersFromPage;

public class MainPage {

    SelenideElement bannerSale = $(".catalog-block-banner"),
            loginModal = $(".sign-form"),
            unsuccessfullLoginAlert = $("li[role='alert']"),
            userEmailInput = $("#id_login_email"),
            userPasswordInput = $("#id_login_password"),
            userAvatar = $("[class^='navbar__profile']"),
            logoutModal = $(".modal-popup__container"),
            logoutCancelButton = $(".modal-popup__container .white"),
            languageButton = $("[class*='language-selector']"),
            searchInput = $(".search-form__input");
    ElementsCollection languageList = $$("li.menu-item"),
            catalogHeaders = $$("[class='catalog-block__title']"),
            buttonList = $$("button");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage verifyUrl(String value) {
        webdriver().shouldHave(url(value));
        return this;
    }

    public MainPage openLoginModal() {
        open("/catalog?auth=login");
        return this;
    }

    public MainPage bannerSaleIsDisplayed() {
        bannerSale.isDisplayed();
        return this;
    }

    public MainPage clickBannerSale() {
        bannerSale.click();
        return this;
    }

    public MainPage loginModalAppeared() {
        loginModal.should(appear);

        return this;
    }

    public MainPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public MainPage setUserUserPassword(String value) {
        userPasswordInput.setValue(value);
        return this;
    }

    public MainPage clickLogin() {
        buttonList.find(text("Войти")).click();
        return this;
    }

    public MainPage userAvatarIsVisible() {
        userAvatar.shouldBe(visible);
        return this;
    }

    public MainPage userAvatarClick() {
        userAvatar.click();
        return this;
    }

    public MainPage clickLogoutInDropDownMenu() {
        buttonList.find(text("Logout")).click();
        return this;
    }

    public MainPage logoutModalAppeared() {
        logoutModal.should(appear);
        return this;
    }

    public MainPage clickConfirmLogout() {
        buttonList.find(text("OK")).click();
        return this;
    }

    public MainPage clickCancelLogout() {
        logoutCancelButton.click();
        return this;
    }

    public MainPage verifyUnSuccessfullLoginAlert(String value) {
        unsuccessfullLoginAlert.shouldHave(text(value));
        return this;
    }

    public MainPage setLanguage(String value) {
        languageButton.click();
        languageList.find(text(value)).click();
        return this;
    }

    public MainPage verifyCatalogHeaders(List<String> expectedHeaders) {
        sleep(1000); // The new lang takes forever to load. Let's stick with 10 000 to ensure it'd work anywhere.
        ElementsCollection headers = catalogHeaders;
        ArrayList<String> webPageHeaders = getHeadersFromPage(headers);

        assert expectedHeaders.equals(webPageHeaders);
        return this;
    }

    public MainPage SearchValue(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

}
