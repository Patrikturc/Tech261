package com.sparta.pt.adv_restassured;

import io.cucumber.java.Before;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetCommitCommentsTests {
    // Response Object

    private static Response response;
    private static final String BASE_URI = "https://api.github.com";
    private static final String PATH = "/repos/{owner}/{repo}/comments";
    private static final String OWNER = "patrikturc";
    private static final String REPO_NAME = "Tech261";
    private static final String BEARER_TOKEN = "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";

    @BeforeAll
    public static void beforeAll(){
        response =
                RestAssured
                        .given()
                        .baseUri(BASE_URI)
                        .basePath(PATH)
                        .headers(Map.of(
                                "Accept", "application/vnd.github+json",
                                "Authorization", "Bearer " + BEARER_TOKEN,
                                "X-GitHub-Api-Version", "2022-11-28"
                        ))
                        //set the path parmaters for the API endpoint
                        .pathParams(Map.of(
                                "owner", OWNER,
                                "repo", REPO_NAME
                        ))
                        .when()
                        .get()
                        .thenReturn();
    }

    @Test
    @DisplayName("Get all comments and check the status code")
    public void testStatusCode200(){
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Check all repositories returns one comment")
    public void testAllRepositoriesReturnsOneComment(){
        MatcherAssert.assertThat(response.jsonPath().getList("id").size(), Matchers.is(1));
    }

    @Test
    @DisplayName("First comment has correct user name associated")
    void firstComment_HasCorrectUserNameAssociated() {
        MatcherAssert.assertThat(response.jsonPath().getString("user.login[0]").toLowerCase(), Matchers.is(OWNER));
    }
}
