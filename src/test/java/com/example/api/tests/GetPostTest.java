package com.example.api.tests;

import com.example.api.base.BaseTest;
import com.example.api.client.ApiClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPostTest extends BaseTest {

    @Test
    public void testGetPostById() {
        Response response = ApiClient.get("/posts/1");

        response.then().statusCode(200);
        assertThat(response.jsonPath().getInt("id"), equalTo(1));
    }
}
