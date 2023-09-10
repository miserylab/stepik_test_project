package org.stepik.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
        catalogPage.clickProfileTab();
        profilePage.profilePageIsOpened(mobileTestData.placeholderMessage)
                .clickSigninButton();
        authPage.clickSignInWithEmailButton()
                .setLogin(mobileTestData.userEmail)
                .setPassword(mobileTestData.userPassword)
                .clickloginButton();
        homePage.clickNotificationCloseButton()
                .homePageIsOpened();

        homePage.clickProfileTab();
        profilePage.verifyUserIsLogged(mobileTestData.userName);

    }

    @Test
    @DisplayName("Неуспешный логин под незарегистрированным пользователем")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void unSuccessfullLogin() {
        catalogPage.clickProfileTab();
        profilePage.profilePageIsOpened(mobileTestData.placeholderMessage)
                .clickSigninButton();
        authPage.clickSignInWithEmailButton()
                .setLogin(mobileTestData.unregisteredEmail)
                .setPassword(mobileTestData.userPassword)
                .clickloginButton();
        authPage.verifyLoginErrorMessage(mobileTestData.loginErrorMessageText);
    }
}
