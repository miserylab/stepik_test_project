package org.stepik.mobile.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
public class SearchTests extends BaseTest {


//    @BeforeEach
//    void skipOnboarding() {
////        back();
//        $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();
//        $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")).click();
//        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
//        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
//        sleep(100000);
//    }

    @Test
    @DisplayName("test")
    @Owner("o.demina")
    void successfulSearchTest() {
        $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();
//        $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")).click();
//        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();

        int timeout = 10000;
//        $(AppiumBy.accessibilityId("Catalog")).shouldHave(attribute("selected","true"));
//        $(AppiumBy.accessibilityId("Catalog")).waitUntil(attribute("selected", "true"), timeout);
//        $(AppiumBy.id("org.stepic.droid:id/search_src_text")).sendKeys("Основы java");
//        sleep(100000);
//        back();
//        back();

//        sleep(100000);
//        back();
//        step("Type search", () -> {
//            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
//            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
//        });
//        step("Verify content found", () ->
//                $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
//                        .shouldHave(sizeGreaterThan(0)));
    }
}