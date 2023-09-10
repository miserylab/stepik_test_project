package org.stepik.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.stepik.config.WebConfig;
import org.stepik.mobile.drivers.AndroidBrowserstackDriver;
import org.stepik.mobile.drivers.AndroidLocalDriver;
import org.stepik.mobile.helpers.Attach;
import org.stepik.mobile.pages.AuthPage;
import org.stepik.mobile.pages.CatalogPage;
import org.stepik.mobile.pages.HomePage;
import org.stepik.mobile.pages.ProfilePage;
import org.stepik.mobile.utils.MobileTestData;

import static com.codeborne.selenide.Selenide.*;
import static org.stepik.mobile.helpers.Attach.pageSource;
import static org.stepik.mobile.helpers.Attach.screenshotAs;

public class BaseMobileTest {
    private final WebConfig config = ConfigFactory.create(WebConfig.class);
    MobileTestData mobileTestData = new MobileTestData();
    CatalogPage catalogPage = new CatalogPage();
    ProfilePage profilePage = new ProfilePage();
    AuthPage authPage = new AuthPage();
    HomePage homePage = new HomePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = AndroidBrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void openMobile() {
        if (config.getMobilePlatform().equals("browserstack")) {
            Configuration.browser = AndroidBrowserstackDriver.class.getName();
        } else {
            Configuration.browser = AndroidLocalDriver.class.getName();
        }
        open();
        sleep(3000);
        $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();
        if ($(AppiumBy.id("org.stepic.droid:id/closeOnboarding")).isDisplayed()) {
            $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")).click();
        } else {
            $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
        }
        $(AppiumBy.id("org.stepic.droid:id/dismissButton")).click();
    }


    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
        screenshotAs("Last screenshot");
        pageSource();
        closeWebDriver();
        if (config.getMobilePlatform().equals("browserstack")) {
            Attach.addVideo(sessionId);
        }

    }

}
