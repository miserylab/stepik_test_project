package org.stepik.mobile.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Search")
@Feature("Catalog Search")
@Story("Catalog Search")
@Tag("mobile")
public class SearchTest extends BaseMobileTest {

    @Test
    @DisplayName("Успешный поиск в каталоге")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void successfullCourseSearch() {
        catalogPage.setSearchValue(mobileTestData.courseName)
                .androidPressEnter()
                .verifyCourseInResult(mobileTestData.courseName);
    }
}
