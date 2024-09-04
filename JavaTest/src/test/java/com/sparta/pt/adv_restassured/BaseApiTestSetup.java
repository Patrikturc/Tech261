package com.sparta.pt.adv_restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public abstract class BaseApiTestSetup {
    protected static final String BASE_URI = "https://api.github.com";
    protected static String BEARER_TOKEN;
    protected Response response;

    static {
        try (InputStream input = BaseApiTestSetup.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            BEARER_TOKEN = properties.getProperty("github.token");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load configuration.", ex);
        }
    }

    protected abstract String getPath();
    protected abstract Map<String, Object> getPathParams();

    @BeforeEach
    public void setUp() {
        response = RestAssured
                .given(createRequestSpec())
                .basePath(getPath())
                .pathParams(getPathParams())
                .when()
                .get()
                .thenReturn();
    }

    private RequestSpecification createRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("Authorization", "Bearer " + BEARER_TOKEN)
                .addHeader("X-GitHub-Api-Version", "2022-11-28")
                .build();
    }
}
