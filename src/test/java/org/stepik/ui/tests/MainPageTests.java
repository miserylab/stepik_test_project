package org.stepik.ui.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Story("Catalog")
@Tag("web")
public class MainPageTests extends TestBase {

    @DisplayName("Проверка редиректа на страницу каталога при переходе по основной ссылке сайта")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @Test
    void mainPageShouldRedirectToCatalog() {
        step("Open main page", () ->
        mainPage.openPage());
        step("Verify redirect to " + testData.catalogPage, () ->
        webdriver().shouldHave(url(testData.catalogPage)));
    }


    @ParameterizedTest
//            (Русский, [ghjfgf]
//            Englidh, [fdfds])
    @DisplayName("Здесь будет параметризованный тест на каталоги в зависимости от выбранного языка")
    @Test
    void mainPageShouldHaveCatalogs() {
        open("/");
    }

    @DisplayName("По баннеру распродажи производится переход на страницу с каталогом распродаж")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @Test
    void catalogSaleBannerShouldOpenCatalogSalePage() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Banner should be visible", () ->
                mainPage.bannerSaleIsDisplayed()
                        .clickBannerSale());
        step("Verify is open", () ->
                catalogSalePage.getCatalogSaleHeaderText(testData.catalogSalePageTitle));
    }

    @DisplayName("По баннеру распродажи производится переход на страницу с каталогом распродаж")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @Test
    void catalogSaleBannerShouldOpenCatalogSalePage1() {
        step("Open main page", () ->
                catalogSalePage.openPage());
//        step("Banner should be visible", () ->
//                mainPage.bannerSaleIsDisplayed()
//                        .clickBannerSale());
        step("Verify is open", () ->
                catalogSalePage.getCatalogSaleHeaderText(testData.catalogSalePageTitle));
    }
}
