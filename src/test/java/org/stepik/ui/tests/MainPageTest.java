package org.stepik.ui.tests;

import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.stepik.ui.utils.TestData;

import java.util.List;


import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Story("Main Page")
//@Tag("web")
public class MainPageTest extends BaseTest {

    @Test
    @DisplayName("Редирект на страницу каталога при переходе по основной ссылке сайта")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void mainPageShouldRedirectToCatalog() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Verify redirect to " + testData.catalogPageUrl, () ->
                mainPage.verifyUrl(testData.catalogPageUrl));
    }

    @ParameterizedTest
    @Flaky
    @DisplayName("В зависимости от выбранного языка выдается определенный набор каталогов")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @ArgumentsSource(TestData.class)
    void languageSelectionShouldHaveDifferentListOfCatalogs(String language, List<String> expectedHeaders) {
        step("Open main page", () ->
                mainPage.openPage());
        step("Select language: " + language, () ->
                mainPage.setLanguage(language));
        step("Verify catalog headers: " + expectedHeaders, () ->
                mainPage.verifyCatalogHeaders(expectedHeaders));
    }
}
