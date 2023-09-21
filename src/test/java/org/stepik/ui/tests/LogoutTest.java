package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Authorization")
@Feature("Log out")
@Story("Log out")
@Owner("o.demina")
@Tag("web")
public class LogoutTest extends BaseTest {

    @BeforeEach
    void successfullLogin() {
        step("Successfull Login", () ->
                mainPage.openLoginModal()
                        .setUserEmail(testData.userEmail)
                        .setUserPassword(testData.userPassword)
                        .clickLogin()
                        .checkAvatarIsVisible());
    }

    @Test
    @DisplayName("Успешный Logout")
    @Severity(BLOCKER)
    void successfullLogOut() {
        step("Click Logout Button", () ->
                mainPage.clickOnUserAvatar()
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
    @Severity(CRITICAL)
    void canceledLogOut() {
        step("Click Logout Button", () ->
                mainPage.clickOnUserAvatar()
                        .clickLogoutInDropDownMenu());
        step("Log out Modal appeared", () ->
                mainPage.logoutModalAppeared());
        step("Click Cancel log out", () ->
                mainPage.clickCancelLogout());
        step("Verify user is still logged in", () ->
                mainPage.checkAvatarIsVisible());
    }
}
