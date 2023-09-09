package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Authorization")
@Feature("Log out")
@Story("Log out")
@Tag("web")
public class LogoutTest extends TestBase {

    @BeforeEach
    void successfullLogin() {
        step("Successfull Login", () ->
                mainPage.openLoginModal()
                        .setUserEmail(testData.userEmail)
                        .setUserUserPassword(testData.userPassword)
                        .clickLogin()
                        .userAvatarIsVisible());
    }

    @Test
    @DisplayName("Успешный Logout")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfullLogOut() {
        step("Click Logout Button", () ->
                mainPage.userAvatarClick()
                        .clickLogoutInDropDownMenu());
        step("Log out Modal appeared", () ->
                mainPage.logoutModalAppeared());
        step("Click Confirm log out", () ->
                mainPage.clickConfirmLogout());
        step("Verify user is logged out", () ->
                mainPage.loginModalAppeared());
    }

    @Test
    @DisplayName("Отмена Logout")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void canceledLogOut() {
        step("Click Logout Button", () ->
                mainPage.userAvatarClick()
                        .clickLogoutInDropDownMenu());
        step("Log out Modal appeared", () ->
                mainPage.logoutModalAppeared());
        step("Click Cancel log out", () ->
                mainPage.clickCancelLogout());
        step("Verify user is still logged in", () ->
                mainPage.userAvatarIsVisible());
    }
}
