package org.stepik.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    SelenideElement catalogTab = $(AppiumBy.accessibilityId("Catalog")),
            homeTab = $(AppiumBy.accessibilityId("Home")),
            profileTab = $(AppiumBy.accessibilityId("Profile")),
            notificationsTab = $(AppiumBy.accessibilityId("Notifications")),
            profileMessage = $(AppiumBy.id("org.stepic.droid:id/placeholderMessage")),
            signinButton = $(AppiumBy.id("org.stepic.droid:id/authAction")),
            profileName = $(AppiumBy.id("org.stepic.droid:id/profileName"));

    public ProfilePage profilePageIsOpened(String value) {
        catalogTab.shouldHave(attribute("selected","false"));
        homeTab.shouldHave(attribute("selected","false"));
        profileTab.shouldHave(attribute("selected","true"));
        notificationsTab.shouldHave(attribute("selected","false"));
        profileMessage.shouldHave(text(value));
        return this;
    }

    public ProfilePage verifyUserIsLogged(String value){
        profileName.shouldHave(text(value));
        return this;
    }

    public ProfilePage clickSigninButton(){
        signinButton.click();
        return this;
    }



}
