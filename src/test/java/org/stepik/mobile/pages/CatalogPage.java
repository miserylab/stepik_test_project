package org.stepik.mobile.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.CollectionElement;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {

    SelenideElement catalogTab = $(AppiumBy.accessibilityId("Catalog")),
            homeTab = $(AppiumBy.accessibilityId("Home")),
            profileTab = $(AppiumBy.accessibilityId("Profile")),
            notificationsTab = $(AppiumBy.accessibilityId("Notifications")),
            searchInput = $(AppiumBy.id("org.stepic.droid:id/search_src_text"));

    ElementsCollection categories = $$(AppiumBy.id("org.stepic.droid:id/containerTitle")),
            courseItems = $$(AppiumBy.id("org.stepic.droid:id/courseItemName"));

    public CatalogPage clickProfileTab() {
        profileTab.click();
        return this;
    }

    public CatalogPage catalogTabIsSelected(){
        catalogTab.shouldHave(attribute("selected","true"));
        homeTab.shouldHave(attribute("selected","false"));
        profileTab.shouldHave(attribute("selected","false"));
        notificationsTab.shouldHave(attribute("selected","false"));
        return this;
    }

    public CatalogPage verifyCategories(List<String> values) {
        categories.shouldHave(CollectionCondition.textsInAnyOrder(values));
        return this;
    }

    public CatalogPage setSearchValue(String value) {
        searchInput.click();
        searchInput.sendKeys(value);
        return this;
    }

    public CatalogPage androidPressEnter() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public CatalogPage verifyCourseInResult(String value) {
        courseItems.get(0).shouldHave(text(value));
        return this;
    }
}
