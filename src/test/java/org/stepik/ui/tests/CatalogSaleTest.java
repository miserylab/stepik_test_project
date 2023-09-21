package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Epic("Sale")
@Feature("Catalog Sale")
@Story("Catalog Sale Page")
@Owner("o.demina")
@Tag("web")
public class CatalogSaleTest extends BaseTest {
    @Test
    @DisplayName("По баннеру распродажи производится переход на страницу с каталогом распродаж")
    @Severity(CRITICAL)
    void catalogSaleBannerShouldOpenCatalogSalePage1() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Banner should be visible", () ->
                mainPage.checkBannerIsVisible()
                        .clickBannerSale());
        step("Verify catalog sale page is open", () ->
                catalogSalePage.verifyUrl(testData.catalogSalePageUrl)
                        .verifyCatalogSaleHeaderText(testData.catalogSalePageTitle));
    }
}
