package org.stepik.mobile.helpers;

import org.aeonbits.owner.ConfigFactory;
import org.stepik.config.WebConfig;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;


public class Browserstack {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.getBrowserStackUser(), config.getBrowserStackKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}