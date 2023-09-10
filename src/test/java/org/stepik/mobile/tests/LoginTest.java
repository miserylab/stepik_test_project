package org.stepik.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Auth Mobile")
@Feature("Auth Mobile")
@Story("Log in with credentials")
@Tag("mobile")
public class LoginTest extends BaseMobileTest {

    @Test
    @DisplayName("Успешный логин")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void successfullLogin() {
        step("Open profile tab", () ->
                catalogPage.clickProfileTab());
        step("Click signin buttoon", () ->
                profilePage.clickSigninButton());
        step("Open auth page", () ->
                authPage.clickSignInWithEmailButton());
        step("Fill Email and Password", () ->
                authPage.setLogin(mobileTestData.userEmail)
                        .setPassword(mobileTestData.userPassword)
                        .clickloginButton());
        step("Close notification modal", () ->
                homePage.clickNotificationCloseButton()
                        .homePageIsOpened());
        step("Open profile tab", () ->
                homePage.clickProfileTab());
        step("Verify user is logged", () ->
                profilePage.verifyUserIsLogged(mobileTestData.userName));

    }

    @Test
    @DisplayName("Неуспешный логин под незарегистрированным пользователем")
    @Owner("o.demina")
    @Severity(CRITICAL)
    @Tag("remote")
    void unSuccessfullLogin() {
        step("Open profile tab", () ->
                catalogPage.clickProfileTab());
        step("Click signin buttoon", () ->
                profilePage.clickSigninButton());
        step("Open auth page", () ->
                authPage.clickSignInWithEmailButton());
        step("Fill Unregistered Email and Password", () ->
                authPage.setLogin(mobileTestData.unregisteredEmail)
                        .setPassword(mobileTestData.userPassword)
                        .clickloginButton());
        step("Verify user is not logged in", () ->
                authPage.verifyLoginErrorMessage(mobileTestData.loginErrorMessageText));
    }
}
