package com.sparta.pt.adv_restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PostCommitCommentWithValidBodyTests extends BaseApiTestSetup {

    private static final String POST_MESSAGE = "Hello, World";
    private static final String DELETE_PATH = "/repos/{owner}/{repo}/comments/{comment_id}";
    private static Response postResponse;
    private static Integer commentId;
    private static Integer initialNumberOfComments;
    private static Integer finalNumberOfComments;
    private static final String OWNER = "patrikturc";
    private static final String REPO_NAME = "Tech261";
    private static final String COMMIT_SHA = "4932ee38a43d2627020d4691a2b75ddba10fd8cc";

    @BeforeAll
    public static void beforeAll() {
        PostCommitCommentWithValidBodyTests instance = new PostCommitCommentWithValidBodyTests();
        initialNumberOfComments = instance.getNumberOfComments();
        System.out.println("Initial comment count: " + initialNumberOfComments);

        postResponse = instance.makeRequest("POST", instance.getPath(), instance.getPathParams(), instance.getRequestBody());
        commentId = postResponse.jsonPath().getInt("id");

        System.out.println("Post response: " + postResponse.asString());
    }

    @Test
    @DisplayName("Validate the response body")
    void validateResponseBody() {
        MatcherAssert.assertThat(postResponse.jsonPath().getString("body"), Matchers.is(POST_MESSAGE));
    }

    @Test
    @DisplayName("Validate the response status code")
    void validateResponseStatusCode() {
        MatcherAssert.assertThat(postResponse.getStatusCode(), Matchers.is(201));
    }

    @Test
    @DisplayName("Validate the number of comments")
    void validateNumberOfComments() {
        MatcherAssert.assertThat(finalNumberOfComments, Matchers.is(initialNumberOfComments + 1));
    }

    @AfterAll
    public static void afterAll() {
        if (commentId != null) {
            Response deleteResponse = RestAssured
                    .given(createRequestSpec())
                    .pathParams(Map.of(
                            "owner", OWNER,
                            "repo", REPO_NAME,
                            "comment_id", commentId))
                    .when()
                    .delete(DELETE_PATH);

            System.out.println("Delete response: " + deleteResponse.asString());
        }
    }

    @Override
    protected String getPath() {
        return "/repos/{owner}/{repo}/commits/{commit_sha}/comments";
    }

    @Override
    protected Map<String, Object> getPathParams() {
        return Map.of(
                "owner", OWNER,
                "repo", REPO_NAME,
                "commit_sha", COMMIT_SHA
        );
    }

    @Override
    protected String getHttpMethod() {
        return "POST";
    }

    @Override
    protected Object getRequestBody() {
        return Map.of("body", POST_MESSAGE);
    }

    private int getNumberOfComments() {
        Response getAllResponse = RestAssured
                .given(createRequestSpec())
                .basePath("/repos/{owner}/{repo}/comments")
                .pathParams(Map.of(
                        "owner", OWNER,
                        "repo", REPO_NAME
                ))
                .when()
                .get();

        return getAllResponse.jsonPath().getList("").size();
    }
}
