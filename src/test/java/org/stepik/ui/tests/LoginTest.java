package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Authorization")
@Feature("Log in")
@Story("Log in with credentials")
@Tag("web")
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Успешный логин")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfullLogin() {
        step("Open main page", () ->
                mainPage.openLoginModal());
        step("Fill Email and Password", () ->
                mainPage.setUserEmail(testData.userEmail)
                        .setUserUserPassword(testData.userPassword));
        step("Click Login Button", () ->
                mainPage.clickLogin());
        step("Verify user is logged in", () ->
                mainPage.userAvatarIsVisible());
    }

    @Test
    @DisplayName("Неуспешный логин под незарегистрированным пользователем")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void unSuccessfullLogin() {
        step("Open main page", () ->
                mainPage.openLoginModal());
        step("Fill Email and Password", () ->
                mainPage.setUserEmail(testData.unregisteredEmail)
                        .setUserUserPassword(testData.userPassword));
        step("Click Login Button", () ->
                mainPage.clickLogin());
        step("Verify user is logged in", () ->
                mainPage.verifyUnSuccessfullLoginAlert(testData.unSuccessfullAlert));
    }
}
