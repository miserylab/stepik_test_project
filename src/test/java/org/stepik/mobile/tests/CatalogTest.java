package org.stepik.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Epic("Сatalog")
@Feature("Catalog Tab")
@Story("Catalog categories")
@Owner("o.demina")
@Tag("mobile")
public class CatalogTest extends BaseMobileTest {

    @Test
    @DisplayName("Проверка категорий на странице каталога")
    @Severity(CRITICAL)
    void categoriesShouldBePresent() {
        step("Catalog tab is opened", () ->
                catalogPage.catalogTabIsSelected());
        step("Verify categories on page:" + mobileTestData.categories, () ->
                catalogPage.verifyCategories(mobileTestData.categories));
    }
}