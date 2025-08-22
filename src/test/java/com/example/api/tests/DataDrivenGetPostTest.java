package com.example.api.tests;

import com.example.api.client.ApiClient;
import com.example.api.dataproviders.PostDataProvider;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class DataDrivenGetPostTest {

    @Test(dataProvider = "postData", dataProviderClass = PostDataProvider.class)
    public void testGetPostById(Map<String, Object> data) {
        int postId = ((Number) data.get("id")).intValue();
        String expectedTitle = (String) data.get("expectedTitle");

        Response response = ApiClient.get("/posts/" + postId);

        response.then()
                .statusCode(200)
                .body("id", equalTo(postId))
                .body("title", equalTo(expectedTitle));
    }
}
