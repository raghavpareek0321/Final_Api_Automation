package com.example.api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    static {
        // This is critical - what base URI are you using?
        // If it's "http://localhost:8080" and no server is running, you'll get Connection Refused.
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; 
    }

    public static Response get(String path) {
        return RestAssured.given()
                .when()
                .get(path)
                .then()
                .extract()
                .response();
    }
}
