package com.example.api.base;

import com.example.api.config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigManager.get("baseURI");
        RestAssured.config = RestAssured.config()
                .httpClient(
                    RestAssured.config().getHttpClientConfig()
                        .setParam("http.connection.timeout", ConfigManager.getInt("timeout"))
                        .setParam("http.socket.timeout", ConfigManager.getInt("timeout"))
                );
    }
}
