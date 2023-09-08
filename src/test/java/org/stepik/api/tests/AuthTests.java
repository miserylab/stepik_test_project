package org.stepik.api.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthTests extends BaseTest {

    String authData = "{ \"email\": \"psychosomatic20321@gmail.com\", \"password\": \"F8EhaLCsAp9sB5\" }"; // BAD PRACTICE


    @Test
        public void testSuccessfulAuth() {
            // Given
            given()
                    .log().uri()
                    .log().method()
                    .log().body()
                    .contentType(JSON)
                    .header("Referer", "https://stepik.org/learn?auth=login")
                    .body(authData)
                    .when()
                    .post("https://stepik.org/api/users/login")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200);
        }
}
