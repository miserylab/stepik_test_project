# Test automation project for [Stepik](https://stepik.org/) site

<img src="src/test/resources/images/stepik.png" alt="Stepik">

> Stepik is a cloud-based platform that is designed to create and distribute interactive educational content as well as provide various types of automatically graded assignments with real-time feedback. Platform is suitable for a multitude of e-learning activities, from private on-campus classes to massive open online courses (MOOCs). When designing Stepik, we have kept the requirements of computer science education in mind, for this platform to effectively cater to your educational needs.

# <a name="TableOfContents">Table of contents</a>
+ [Description](#Description)
+ [Tools and technologies](#Technology)
+ [How to run](#HowToRun)
    + [Run in Jenkins](#RunInJenkins)
+ [Telegram Notifications](#TelegramNotifications)
+ [Test results report in Allure Report](#AllureReport)
+ [Allure TestOps integration](#AllureTestOps)
+ [Jira integration](#Jira)
+ [Video of running tests](#Video)


# <a name="Description">Description</a>
The test project consists of ui and mobile(android) tests.

[Back to the table of contents ⬆](#TableOfContents)

# <a name="Technology">Tools and a technologies</a>
## For UI test automation
<p  align="center">
  <img src="src/test/resources/images/logo/Intelij_IDEA.svg" width="5%" alt="Intelij IDEA"/>
  <img src="src/test/resources/images/logo/Java.svg" width="5%" alt="Java"/>
  <img src="src/test/resources/images/logo/Selenide.svg" width="5%" alt="Selenide"/>
  <img src="src/test/resources/images/logo/Selenoid.svg" width="5%" alt="Selenoid"/>
  <img src="src/test/resources/images/logo/Allure_Report.svg" width="5%" alt="Allure"/>
  <img src="src/test/resources/images/logo/Allure_Test_Ops.svg" width="5%" alt="Allure Test Ops"/>
  <img src="src/test/resources/images/logo/Gradle.svg" width="5%"  alt="Gradle"/>
  <img src="src/test/resources/images/logo/JUnit5.svg" width="5%" alt="JUnit5"/>
  <img src="src/test/resources/images/logo/Jenkins.svg"width="5%" alt="Jenkins"/>
  <img src="src/test/resources/images/logo/Telegram.svg"width="5%" alt="Telegram"/>
</p>

## For Mobile test automation
<p  align="center">
  <img src="src/test/resources/images/logo/Intelij_IDEA.svg" width="5%" alt="Intelij IDEA"/>
  <img src="src/test/resources/images/logo/Java.svg" width="5%" alt="Java"/>
  <img src="src/test/resources/images/logo/Selenide.svg" width="5%" alt="Selenide"/>
  <img src="src/test/resources/images/logo/androidstudio.svg" width="5%" alt="Android Studio"/>
  <img src="src/test/resources/images/logo/appium.svg" width="5%" alt="Appium"/>
  <img src="src/test/resources/images/logo/appium_inspector.png" width="5%" alt="Appium Inspector"/>
  <img src="src/test/resources/images/logo/browserstack.svg" width="5%"  alt="Browserstack"/>
  <img src="src/test/resources/images/logo/Allure_Report.svg" width="5%" alt="Allure"/>
  <img src="src/test/resources/images/logo/Allure_Test_Ops.svg" width="5%" alt="Allure Test Ops"/>
  <img src="src/test/resources/images/logo/Gradle.svg" width="5%"  alt="Gradle"/>
  <img src="src/test/resources/images/logo/JUnit5.svg" width="5%" alt="JUnit5"/>
  <img src="src/test/resources/images/logo/Jenkins.svg"width="5%" alt="Jenkins"/>
  <img src="src/test/resources/images/logo/Telegram.svg"width="5%" alt="Telegram"/>
</p>

The autotests in this project are written in `Java` using `Selenide` for ui tests and in `Java` using `Selenide`+ `Appium` for mobile tests.\
`Gradle` is used to automatically build the project.\
`JUnit 5` is used as a unit testing library.\
`Selenoid` runs browsers in Docker containers.\
`Jenkins` - CI/CD for running tests remotely.\
`Browserstack` - to run mobile tests.\
`Android Studio tools`, `Appium Inspector` - to tun mobile tests locally in a mobile device emulator.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.

[Back to the table of contents ⬆](#TableOfContents)

# <a name="HowToRun">How to run</a>

To run locally the following command is used:
```bash
gradle clean test
```
Remote launch via parameter transfer
```bash
clean test
-Denv=test
-Dtag=web
-DwebIsRemote=true
-DwebRemoteUrl=https://{user}:{pass}@selenoid.autotests.cloud
-DwebBaseUrl=https://stepik.org
-DwebBrowserSize=1920x1080
-DwebBrowserName=chrome
-DwebBrowserVersion=100.0
-DmobilePlatform=browserstack
-DandroidDevice=
-DandroidVersion=
-DbuildName=
```

[Back to the table of contents ⬆](#TableOfContents)

## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/C20-miserylab-java_final/)</a>
Main page of the build:

<p  align="center">
  <img src="src/test/resources/images/jenkins1.png" alt="JenkinsBuild"/>
</p>

Parameters:

<p  align="center">
  <img src="src/test/resources/images/jenkins4.png" alt="JenkinsBuild"/>
</p>

After the build is done the test results are available in:
>- <code><strong>*Allure Report*</strong></code>
>- <code><strong>*Allure TestOps*</strong></code>

<p  align="center">
  <img src="src/test/resources/images/jenkins3.png" alt="JenkinsBuild"/>
</p>


[Back to the table of contents ⬆](#TableOfContents)


# <a name="TelegramNotifications">Telegram Notifications</a>
Telegram bot sends a brief report to a specified telegram chat by results of each build.
<p  align="center">
<img src="src/test/resources/images/telegram.png" alt="TelegramNotification" >
</p>


[Back to the table of contents ⬆](#TableOfContents)

# <a name="AllureReport">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/C20-miserylab-java_final/14/allure/)</a>

<p align="center">
  <img src="src/test/resources/images/allure1.png" alt="AllureReport1">
</p>

<p align="center">
  <img src="src/test/resources/images/allure2.png" alt="AllureReport1">
</p>

Also additional test artifacts are available:
>- Page Source
>- Screenshot
>- Browser logs
>- Video

<p align="center">
  <img src="src/test/resources/images/allure3.png" alt="AllureReport1">
</p>

[Back to the table of contents ⬆](#TableOfContents)

# <a name="AllureTestOps">[Allure TestOps](https://allure.autotests.cloud/project/3665/dashboards) integration</a>
> The link can be accessed only by authorized users.

## <a name="AllureTestOpsProject">Project in Allure TestOps</a>

<p align="center">
  <img src="src/test/resources/images/testops1.png" alt="Allure Report"/>
</p>

<p align="center">
  <img src="src/test/resources/images/testops2.png" alt="Allure Report"/>
</p>

<p align="center">
  <img src="src/test/resources/images/testops3.png" alt="Allure Report"/>
</p>


[Back to the table of contents ⬆](#TableOfContents)

# <a name="Jira">[Jira](https://jira.autotests.cloud/browse/HOMEWORK-882) integration</a>
> The link can be accessed only by authorized users.

<p align="center">
  <img src="src/test/resources/images/jira.png" alt="Jira integration"/>
</p>

[Back to the table of contents ⬆](#TableOfContents)


# <a name="Video">Video of running tests</a>

## UI

https://user-images.githubusercontent.com/95403808/201524887-0593a812-b18d-4a54-b8c9-440c7f2623ec.mp4

## Mobile

[Back to the table of contents ⬆](#TableOfContents)



