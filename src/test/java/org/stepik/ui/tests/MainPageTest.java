package org.stepik.ui.tests;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.stepik.ui.utils.TestData;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.stepik.ui.helpers.WebPageElementsGetter.getHeadersFromPage;

@Story("Main Page")
@Tag("web")
public class MainPageTest extends TestBase {

    @DisplayName("Редирект на страницу каталога при переходе по основной ссылке сайта")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @Test
    void mainPageShouldRedirectToCatalog() {
        step("Open main page", () ->
        mainPage.openPage());
        step("Verify redirect to " + testData.catalogPage, () ->
        webdriver().shouldHave(url(testData.catalogPage)));
    }

//    @Test
    @ParameterizedTest
    @DisplayName("В зависимости от выбранного языка выдается определенный набор каталогов")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @ArgumentsSource(TestData.class)
    void languageSelectionShouldHaveDifferentListOfCatalogs(String language, List<String> expectedHeaders) {
        step("Open main page", () ->
                mainPage.openPage());
        step("Select language: " + language , () ->
                mainPage.setLanguage(language));
        step("Verify catalog headers: " + expectedHeaders , () ->
                mainPage.verifyCatalogHeaders(expectedHeaders));
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
                catalogSalePage.verifyCatalogSaleHeaderText(testData.catalogSalePageTitle));
    }
}
