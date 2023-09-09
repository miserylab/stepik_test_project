package org.stepik.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.stepik.config.WebConfig;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AndroidLocalDriver implements WebDriverProvider {
    private final WebConfig config = ConfigFactory.create(WebConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.getLocalAndroidVersion())
                .setDeviceName(config.getLocalAndroidDevice())
                .setNewCommandTimeout(Duration.ofSeconds(11))
                .setFullReset(false)
//                .setApp(getApk().getAbsolutePath())
                .setApp(new File(config.getLocalAndroidAppPath()).getAbsolutePath())
                .setAppPackage(config.getLocalAndroidAppPackage())
                .setAppActivity(config.getLocalAndroidAppActivity())
        ;
        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    private File getApk() {
//        return new File("src/test/resources/apps/org.stepic.droid.apk");
//    }
}