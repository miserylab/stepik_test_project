package org.stepik.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StepikAPITest1 {
    private String token = "your_token";

    @Test
    public void testGetCourses() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);

        Response response = request.get("https://stepik.org/api/courses");
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().getList("courses"));
    }
}
