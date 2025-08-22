package com.example.api.tests;

import com.example.api.base.BaseTest;
import com.example.api.client.ApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SchemaValidationTest extends BaseTest {

    @Test
    public void testPostSchemaValidation() {
        Response response = ApiClient.get("/posts/1");

        response.then().statusCode(200);

        // Hamcrest assertions
        assertThat(response.jsonPath().getInt("id"), equalTo(1));
        assertThat(response.jsonPath().getString("title"), not(isEmptyOrNullString()));

        // Schema validation
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }
}
