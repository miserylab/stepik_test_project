package org.stepik.api.tests;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepikAPI {
    private String client_id = "cdLMcXrG1Ef4PlXdVO7QpAXixLTHQ4DJi8uKj0QF";
    private String client_secret = "zz2volOtQ9HG5vTUwwHqZFeG1uR7cCh1JpIRILLJp4ZfqYODrSBKRqXy12x0WeYon1oFZcaow7j6h6V8nD8WWh2vWtIt8Zu62Y8mODc8DJdAfKbdSI8KrQQxPxBQVRXv";

    public String getAccessToken() {
        RequestSpecification request =
                given()
                        .log().uri()
                        .log().method()
                        .log().body()
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .auth().preemptive().basic(client_id, client_secret)
                        .formParam("grant_type", "client_credentials");

        Response response = request.post("https://stepik.org/oauth2/token/");
        return response.jsonPath().getString("access_token");

    }
}

