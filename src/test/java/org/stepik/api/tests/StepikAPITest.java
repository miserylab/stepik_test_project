package org.stepik.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StepikAPITest {
    private StepikAPI api = new StepikAPI();

    @Test
    public void testGetCourses() {
        String token = api.getAccessToken();

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);

        Response response = request.get("https://stepik.org/api/courses");
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().getList("courses"));
    }

    @Test
    public void testPostWishlist() {
        String token = api.getAccessToken();
        long courseId = 5293317; // Replace with the ID of the course you want to add to your wishlist

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.contentType("application/json");
        request.body("{\"wishlist\":{\"course\":" + courseId + "}}");

        Response response = request.post("https://stepik.org/api/wishlist");


    }
}