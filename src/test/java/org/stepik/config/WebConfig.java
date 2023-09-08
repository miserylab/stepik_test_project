package org.stepik.config;

import org.aeonbits.owner.Config;



@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/${env}.properties"
})
public interface WebConfig extends Config {

    // Web tests properties
    @Key("webBrowserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("webBrowserVersion")
    String getBrowserVersion();

    @Key("webBaseUrl")
    @DefaultValue("https://stepik.org")
    String getBaseUrl();


    @Key("webBrowserSize")
    String getBrowserSize();

    @Key("webIsRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("webRemoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud")
    String getRemoteUrl();

    @Key("webPageLoadTimeout")
    Long getPageLoadTimeout();

    @Key("webTimeout")
    Long getTimeout();

    @Key("webIsHeadless")
    Boolean isHeadless();

    // Mobile tests properties
    @Key("browserstack.user")
    @DefaultValue("olgad_107E2i")
    String getBrowserStackUser();

    @Key("browserstack.key")
    @DefaultValue("QUAc8RTzqTeNCLSAi24x")
    String getBrowserStackKey();

    @Key("androidVersion")
    @DefaultValue("9.0")
    String getAndroidversion();

    @Key("androidDevice")
    @DefaultValue("Google Pixel 3")
    String getAndroidDevice();

    @Key("androidApp")
    @DefaultValue("bs://a1100f3ea839df8e4c11d9cfd3b4b21253dbee6e")
    String getAndroidApp();

    @Key("buildName")
    @DefaultValue("build-1")
    String getBuildName();

    @Key("mobilePlatform")
//    @DefaultValue("browserstack")
    @DefaultValue("local")
    String getMobilePlatform();

    @Key("local.url")
    @DefaultValue("http://localhost:4723/wd/hub")
    String getLocalUrl();

    @Key("android.local.version")
    @DefaultValue("14.0")
    String getLocalAndroidVersion();

    @Key("android.local.device")
    @DefaultValue("Pixel 4")
    String getLocalAndroidDevice();

    @Key("android.local.app.path")
    @DefaultValue("src/test/resources/apps/org.stepic.droid.apk")
    String getLocalAndroidAppPath();

    @Key("appPackage")
    String getLocalAndroidAppPackage();

    @Key("appActivity")
    String getLocalAndroidAppActivity();
}