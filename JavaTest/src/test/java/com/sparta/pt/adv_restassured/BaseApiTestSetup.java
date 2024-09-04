package com.sparta.pt.adv_restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public abstract class BaseApiTestSetup {
    protected static final String BASE_URI = "https://api.github.com";
    protected static String BEARER_TOKEN;

    static {
        try (InputStream input = BaseApiTestSetup.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            BEARER_TOKEN = properties.getProperty("github.token");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load configuration.", ex);
        }
    }

    protected static RequestSpecification createRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("Authorization", "Bearer " + BEARER_TOKEN)
                .addHeader("X-GitHub-Api-Version", "2022-11-28")
                .build();
    }

    protected Response makeRequest(String method, String path, Map<String, Object> pathParams, Object requestBody) {
        RequestSpecification requestSpec = RestAssured
                .given(createRequestSpec())
                .basePath(path)
                .pathParams(pathParams);

        if (requestBody != null) {
            requestSpec.body(requestBody);
        }

        return switch (method.toUpperCase()) {
            case "POST" -> requestSpec.when().post();
            case "PUT" -> requestSpec.when().put();
            case "DELETE" -> requestSpec.when().delete();
            default -> requestSpec.when().get();
        };
    }

    protected abstract String getPath();
    protected abstract Map<String, Object> getPathParams();
    protected abstract String getHttpMethod();
    protected abstract Object getRequestBody();
}
