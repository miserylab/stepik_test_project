package org.stepik.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage {

    SelenideElement permissionDenyButton = $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")),
            closeOnboardingButton = $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")),
            dismissButton = $(AppiumBy.id("org.stepic.droid:id/dismissButton"));

    public boolean permissionDenyButtonIsDisplayed() {
        return permissionDenyButton.isDisplayed();
    }

    public OnboardingPage clickPermissionDenyButton() {
        permissionDenyButton.click();
        return this;
    }

    public boolean closeOnboardingButtonIsDisplayed() {
        return closeOnboardingButton.isDisplayed();
    }

    public OnboardingPage clickCloseOnboardingButton() {
        closeOnboardingButton.click();
        return this;
    }

    public OnboardingPage clickDismissButton() {
        dismissButton.click();
        return this;
    }




}
