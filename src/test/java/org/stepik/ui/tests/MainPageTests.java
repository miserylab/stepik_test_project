package org.stepik.ui.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class MainPageTests extends RemoteTestBase {

    @Tag("web")
    @DisplayName("Проверка редиректа нас страницу каталога при переходе по основной ссылке сайта")
    @Test
    void mainPageShouldHaveRedirectToCatalog() {
        open("/");
        webdriver().shouldHave(url("https://stepik.org/catalog"));
    }

    @Tag("web")
    @Disabled
    @DisplayName("Здесь будет параметризованный тест на каталоги в зависимости от выбранного языка")
    @Test
    void mainPageShouldHaveCatalogs() {
        open("/");
    }
}
