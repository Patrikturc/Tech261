package com.sparta.pt.adv_restassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {

    public static RequestSpecification getGithubCommentsRequestSpec(String baseUri, String path, String token, String owner, String repo) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "application/vnd.github+json",
                        "Authorization", "Bearer " + token,
                        "X-GitHub-Api-Version", "2022-11-28"
                ))
                .addPathParams(Map.of(
                        "owner", owner,
                        "repo", repo

                ))
                .build();
    }
}
