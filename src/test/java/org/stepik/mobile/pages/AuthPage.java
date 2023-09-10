package org.stepik.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.stepik.ui.pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    SelenideElement signInWithEmailButton = $(AppiumBy.id("org.stepic.droid:id/signInWithEmail")),
    loginInput = $(AppiumBy.id("org.stepic.droid:id/loginField")),
    passwordInput = $(AppiumBy.id("org.stepic.droid:id/passwordField")),
    loginButton = $(AppiumBy.id("org.stepic.droid:id/loginButton")),
    loginErrorMessage = $(AppiumBy.id("org.stepic.droid:id/loginErrorMessage"));

    public AuthPage  clickSignInWithEmailButton() {
        signInWithEmailButton.click();
        return this;
    }

    public AuthPage setLogin(String value) {
        loginInput.sendKeys(value);
        return this;
    }

    public AuthPage setPassword(String value) {
        passwordInput.sendKeys(value);
        return this;
    }

    public AuthPage  clickloginButton() {
        loginButton.click();
        return this;
    }

    public AuthPage verifyLoginErrorMessage(String value) {
        loginErrorMessage.shouldHave(text(value));
        return this;
    }
}