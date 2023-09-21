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
@Owner("o.demina")
@Tag("web")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Успешный логин")
    @Severity(BLOCKER)
    void successfullLogin() {
        step("Open main page", () ->
                mainPage.openLoginModal());
        step("Fill Email and Password", () ->
                mainPage.setUserEmail(testData.userEmail)
                        .setUserPassword(testData.userPassword));
        step("Click Login Button", () ->
                mainPage.clickLogin());
        step("Verify user is logged in", () ->
                mainPage.checkAvatarIsVisible());
    }

    @Test
    @DisplayName("Неуспешный логин под незарегистрированным пользователем")
    @Severity(CRITICAL)
    void unSuccessfullLogin() {
        step("Open main page", () ->
                mainPage.openLoginModal());
        step("Fill unregistered Email and Password", () ->
                mainPage.setUserEmail(testData.unregisteredEmail)
                        .setUserPassword(testData.userPassword));
        step("Click Login Button", () ->
                mainPage.clickLogin());
        step("Verify user is not logged in", () ->
                mainPage.verifyUnSuccessfullLoginAlert(testData.unSuccessfullAlert));
    }
}
