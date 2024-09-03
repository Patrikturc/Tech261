package com.sparta.pt.adv_restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetSpecificCommitCommentTests {
    private static Response response;
    private static final String BASE_URI = "https://api.github.com";
    private static final String PATH = "/repos/{owner}/{repo}/comments/{comment_id}";
    private static final String OWNER = "patrikturc";
    private static final String REPO_NAME = "Tech261";
    private static final String BEARER_TOKEN = "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";
    private static final int COMMENT_ID = 146184534;

    @BeforeAll
    public static void beforeAll() {
        response = RestAssured
                .given()
                .baseUri(BASE_URI)
                .basePath(PATH)
                .headers(Map.of(
                        "Accept", "application/vnd.github+json",
                        "Authorization", "Bearer " + BEARER_TOKEN,
                        "X-GitHub-Api-Version", "2022-11-28"
                ))
                .pathParams(Map.of(
                        "owner", OWNER,
                        "repo", REPO_NAME,
                        "comment_id", COMMENT_ID
                ))
                .when()
                .get()
                .thenReturn();
    }

    @Test
    @DisplayName("Get comment with a specific ID returns a comment with that ID")
    void getCommentWithId_ReturnsThatComment() {
        int returnedCommentId = response.jsonPath().getInt("id");
        MatcherAssert.assertThat(returnedCommentId, Matchers.is(COMMENT_ID));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the Server header")
    void getCommentWithId_ChecksServerHeader() {
        String serverHeader = response.getHeader("Server");
        MatcherAssert.assertThat(serverHeader, Matchers.is("github.com"));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the status code")
    void getCommentWithId_ChecksStatusCode() {
        int statusCode = response.getStatusCode();
        MatcherAssert.assertThat(statusCode, Matchers.is(200));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the reactions total count")
    void getCommentWithId_ChecksReactionsTotalCount() {
        int reactionsTotalCount = response.jsonPath().getInt("reactions.total_count");
        MatcherAssert.assertThat(reactionsTotalCount, Matchers.is(0));
    }
}
