package org.stepik.api.tests;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = System.getProperty("BaseUri","https://stepik.org");
        RestAssured.basePath = System.getProperty("BasePath","/api");
    }
}
