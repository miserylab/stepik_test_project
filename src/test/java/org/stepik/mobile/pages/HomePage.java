package org.stepik.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement catalogTab = $(AppiumBy.accessibilityId("Catalog")),
            homeTab = $(AppiumBy.accessibilityId("Home")),
            profileTab = $(AppiumBy.accessibilityId("Profile")),
            notificationsTab = $(AppiumBy.accessibilityId("Notifications")),
            notificationCloseButton = $(AppiumBy.id("android:id/button2"));

    public HomePage homePageIsOpened() {
        catalogTab.shouldHave(attribute("selected", "false"));
        homeTab.shouldHave(attribute("selected", "true"));
        profileTab.shouldHave(attribute("selected", "false"));
        notificationsTab.shouldHave(attribute("selected", "false"));
        return this;
    }

    public HomePage clickNotificationCloseButton() {
        notificationCloseButton.click();
        return this;
    }

    public HomePage clickProfileTab() {
        profileTab.click();
        return this;
    }
}
