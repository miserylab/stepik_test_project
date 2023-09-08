package org.stepik.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.stepik.config.WebConfig;
import org.stepik.mobile.drivers.AndroidBrowserstackDriver;
import org.stepik.mobile.drivers.AndroidLocalDriver;
import org.stepik.mobile.helpers.Attach;

import static com.codeborne.selenide.Selenide.*;
import static org.stepik.mobile.helpers.Attach.pageSource;
import static org.stepik.mobile.helpers.Attach.screenshotAs;

public class TestBase {
    private final WebConfig config = ConfigFactory.create(WebConfig.class);

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
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
        screenshotAs("Last screenshot");
        pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
//        if (config.getMobilePlatform().equals("browserstack")) {
//            BrowserStackSessionInfo sessionInfo = getSessionInfo(sessionId);
//            getBrowserStackVideo(sessionInfo);
//            logs(sessionInfo);
//            privateLink(sessionInfo);
//            publicLink(sessionInfo);
//        }

//        Attach.screenshotAs("Last screenshot"); //todo
//        pageSource();
//
//        closeWebDriver();

//        Attach.addVideo(sessionId);
    }

}
