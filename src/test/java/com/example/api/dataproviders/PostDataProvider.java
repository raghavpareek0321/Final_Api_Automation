package com.example.api.dataproviders;

import com.example.api.utils.TestDataLoader;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PostDataProvider {

    @DataProvider(name = "postData")
    public static Iterator<Object[]> providePostData() {
        List<Map<String, Object>> data = TestDataLoader.loadJsonArray("test/posts.json");

        return data.stream()
                .map(entry -> new Object[]{entry})
                .iterator();
    }
}
