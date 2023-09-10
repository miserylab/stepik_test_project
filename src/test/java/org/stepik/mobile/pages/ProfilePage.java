package org.stepik.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    SelenideElement signinButton = $(AppiumBy.id("org.stepic.droid:id/authAction")),
            profileName = $(AppiumBy.id("org.stepic.droid:id/profileName"));

    public ProfilePage verifyUserIsLogged(String value) {
        profileName.shouldHave(text(value));
        return this;
    }

    public ProfilePage clickSigninButton() {
        signinButton.click();
        return this;
    }


}
