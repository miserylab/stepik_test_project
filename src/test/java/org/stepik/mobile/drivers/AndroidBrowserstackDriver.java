package org.stepik.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.stepik.config.WebConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidBrowserstackDriver implements WebDriverProvider {
    private final WebConfig config = ConfigFactory.create(WebConfig.class);

    @Override
    @Nonnull
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformName("Android");
        options.setPlatformVersion(config.getAndroidversion());
        options.setDeviceName(config.getAndroidDevice());
        options.setNewCommandTimeout(Duration.ofSeconds(11));
        options.setFullReset(false);
        options.setApp(config.getAndroidApp());
        options.setCapability("build", config.getBuildName());

        try {
            return new AndroidDriver(new URL("http://" + config.getBrowserStackUser() + ":" +
                    config.getBrowserStackKey() + "@hub-cloud.browserstack.com/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}