package org.stepik.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Search")
@Feature("Catalog Search")
@Story("Catalog Search")
@Owner("o.demina")
@Tag("mobile")
public class SearchTest extends BaseMobileTest {

    @Test
    @DisplayName("Успешный поиск в каталоге")
    @Severity(CRITICAL)
    void successfullCourseSearch() {
        step("Input search value", () ->
                catalogPage.setSearchValue(mobileTestData.courseName)
                        .androidPressEnter());
        step("Verify search result", () ->
                catalogPage.verifyCourseInResult(mobileTestData.courseName));
    }
}
